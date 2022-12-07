package net.yorksolutions.kabornamarrablogcmscapstone.controller;

import net.yorksolutions.kabornamarrablogcmscapstone.dto.NewCommentRequestDTO;
import net.yorksolutions.kabornamarrablogcmscapstone.entity.Comment;
import net.yorksolutions.kabornamarrablogcmscapstone.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin
public class CommentController {

    CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public Comment createComment(@RequestBody NewCommentRequestDTO commentRequestDTO){
        return this.commentService.createComment(commentRequestDTO);
    }

    @GetMapping
    public Comment getComment(@RequestParam Long id){
        return this.commentService.getComment(id);
    }

    @PutMapping
    public Comment updateComment(@RequestBody Comment comment){
        return this.commentService.updateComment(comment);
    }

    @DeleteMapping
    public void deleteComment(@RequestParam Long id){
        this.commentService.deleteComment(id);
    }
}
