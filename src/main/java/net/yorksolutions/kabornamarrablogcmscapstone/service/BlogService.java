package net.yorksolutions.kabornamarrablogcmscapstone.service;

import net.yorksolutions.kabornamarrablogcmscapstone.dto.NewBlogRequestDTO;
import net.yorksolutions.kabornamarrablogcmscapstone.entity.Account;
import net.yorksolutions.kabornamarrablogcmscapstone.entity.Blog;
import net.yorksolutions.kabornamarrablogcmscapstone.repository.AccountRepository;
import net.yorksolutions.kabornamarrablogcmscapstone.repository.BlogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Optional;

@Service
public class BlogService {

    BlogRepository blogRepository;
    AccountRepository accountRepository;

    public BlogService(BlogRepository blogRepository, AccountRepository accountRepository) {
        this.blogRepository = blogRepository;
        this.accountRepository = accountRepository;
    }

    public Blog createBlog(NewBlogRequestDTO blogRequestDTO){
        Optional<Account> accountOpt = this.accountRepository.findById(blogRequestDTO.authorID);

        if(accountOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Blog newBlog = new Blog(blogRequestDTO.title, blogRequestDTO.body, new Date(), accountOpt.get());

        return this.blogRepository.save(newBlog);
    }

    public Blog getBlog(Long id){
        Optional<Blog> blogOptional = this.blogRepository.findById(id);

        if(blogOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return blogOptional.get();
    }

    public Iterable<Blog> getAccountBlogs(Long id){
        Optional<Account> accountOpt = this.accountRepository.findById(id);

        if(accountOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return this.blogRepository.findAllByAuthor(accountOpt.get());
    }

    public Iterable<Blog> getAllBlogs(){
        return this.blogRepository.findAll();
    }

    public Blog updateBlog(Blog blog){
        Optional<Blog> blogOptional = this.blogRepository.findById(blog.getId());
        if(blogOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Blog updatedBlog = blogOptional.get();
        updatedBlog.setTitle(blog.getTitle());
        updatedBlog.setBody(blog.getBody());
        updatedBlog.setUpdatedDate(new Date());

        return this.blogRepository.save(updatedBlog);
    }

    public void deleteBlog(Long id){
        Optional<Blog> blogOptional = this.blogRepository.findById(id);
        if(blogOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        this.blogRepository.delete(blogOptional.get());
    }

}
