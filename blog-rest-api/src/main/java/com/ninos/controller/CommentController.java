package com.ninos.controller;

import com.ninos.dto.CommentDTO;
import com.ninos.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("api/v1")
public class CommentController {

    private CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDTO> createComment(@PathVariable("postId") Long postId, @RequestBody CommentDTO commentDTO){
      return new ResponseEntity<>(commentService.createComment(postId, commentDTO), HttpStatus.CREATED);
    }


}
