package com.ninos.controller;

import com.ninos.dto.PostDto;
import com.ninos.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    private PostService postService;


    // create Blog Post
    @PostMapping
    public ResponseEntity<PostDto> createNewPost(@RequestBody PostDto postDto){
        PostDto newPostDto = postService.createPost(postDto);
        return new ResponseEntity<>(newPostDto, HttpStatus.CREATED);
    }





}
