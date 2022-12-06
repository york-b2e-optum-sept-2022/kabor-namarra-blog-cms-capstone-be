package net.yorksolutions.kabornamarrablogcmscapstone.service;

import net.yorksolutions.kabornamarrablogcmscapstone.dto.NewCommentRequestDTO;
import net.yorksolutions.kabornamarrablogcmscapstone.entity.Account;
import net.yorksolutions.kabornamarrablogcmscapstone.entity.Blog;
import net.yorksolutions.kabornamarrablogcmscapstone.entity.Comment;
import net.yorksolutions.kabornamarrablogcmscapstone.repository.AccountRepository;
import net.yorksolutions.kabornamarrablogcmscapstone.repository.BlogRepository;
import net.yorksolutions.kabornamarrablogcmscapstone.repository.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Optional;

@Service
public class CommentService {

    CommentRepository commentRepository;
    BlogRepository blogRepository;
    AccountRepository accountRepository;

    public CommentService(CommentRepository commentRepository, BlogRepository blogRepository, AccountRepository accountRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
        this.accountRepository = accountRepository;
    }

    public Comment createComment(NewCommentRequestDTO commentRequestDTO){
        Optional<Blog> blogOptional = this.blogRepository.findById(commentRequestDTO.blogID);
        if(blogOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Optional<Account> accountOptional = this.accountRepository.findById(commentRequestDTO.authorID);
        if(accountOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Comment comment = new Comment(new Date(), commentRequestDTO.body, accountOptional.get(), blogOptional.get());

        return this.commentRepository.save(comment);
    }

    public Comment getComment(Long id){
        Optional<Comment> commentOptional = this.commentRepository.findById(id);
        if(commentOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return commentOptional.get();
    }

    public Comment updateComment(Comment comment){
        Optional<Comment> commentOptional = this.commentRepository.findById(comment.getId());
        if(commentOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Comment updatedComment = commentOptional.get();
        updatedComment.setUpdatedDate(new Date());
        updatedComment.setBody(comment.getBody());

        return this.commentRepository.save(updatedComment);
    }

    public void deleteComment(Long id){
        Optional<Comment> commentOptional = this.commentRepository.findById(id);
        if(commentOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        this.commentRepository.delete(commentOptional.get());
    }


}
