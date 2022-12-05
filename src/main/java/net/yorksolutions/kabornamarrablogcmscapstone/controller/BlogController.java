package net.yorksolutions.kabornamarrablogcmscapstone.controller;

import net.yorksolutions.kabornamarrablogcmscapstone.dto.NewBlogRequestDTO;
import net.yorksolutions.kabornamarrablogcmscapstone.entity.Blog;
import net.yorksolutions.kabornamarrablogcmscapstone.service.BlogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public Blog createBlog(@RequestBody NewBlogRequestDTO blogRequestDTO){
        return this.blogService.createBlog(blogRequestDTO);
    }

    @GetMapping
    public Blog getBlog(@RequestParam Long id){
        return this.blogService.getBlog(id);
    }

    @GetMapping("/all")
    public Iterable<Blog> getAllBlogs(){
        return this.blogService.getAllBlogs();
    }

    @GetMapping("/accounts")
    public Iterable<Blog> getAccountBlogs(@RequestParam Long id){
        return this.blogService.getAccountBlogs(id);
    }

    @PutMapping
    public Blog updateBlog(@RequestBody Blog blog){
        return this.blogService.updateBlog(blog);
    }

    @DeleteMapping
    public void deleteBlog(@RequestParam Long id){
        this.blogService.deleteBlog(id);
    }
}
