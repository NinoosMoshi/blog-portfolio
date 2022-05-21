package com.ninos.controller;

import com.ninos.dto.CommentDTO;
import com.ninos.model.Comment;
import com.ninos.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("api/v1")
public class CommentController {

    private CommentService commentService;

    // create a comment
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDTO> createComment(@PathVariable("postId") Long postId, @RequestBody CommentDTO commentDTO){
      return new ResponseEntity<>(commentService.createComment(postId, commentDTO), HttpStatus.CREATED);
    }


    // get all the comments
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDTO> getAllComments(@PathVariable("postId") Long postId){
       return commentService.getAllCommentsByPostId(postId);
    }


    // get comment by comment id
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable("postId") Long postId,@PathVariable("commentId") Long commentId){

        CommentDTO commentDTO = commentService.getCommentById(postId,commentId);
        return new ResponseEntity<>(commentDTO,HttpStatus.OK);
    }


    // update a comment
    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable("postId") Long postId,
                                                    @PathVariable("commentId") Long commentId,
                                                    @RequestBody CommentDTO commentDTO){
        CommentDTO updatedComment = commentService.updateComment(postId,commentId,commentDTO);

        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }


    // delete a comment
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(
            @PathVariable("postId") Long postId,
            @PathVariable("commentId") Long commentId
    ){

        commentService.deleteComment(postId,commentId);
        return new ResponseEntity<>("Comment deleted successfully",HttpStatus.OK);
    }



}
