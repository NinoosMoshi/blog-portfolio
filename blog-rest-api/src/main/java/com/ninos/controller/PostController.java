package com.ninos.controller;

import com.ninos.dto.PostDto;
import com.ninos.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    // get all Posts
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(){
      List<PostDto> listPosts = postService.getAllPost();
      return new ResponseEntity<>(listPosts,HttpStatus.OK);
    }


    // get Post by id
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") Long id){
      return ResponseEntity.ok(postService.getPostById(id));
    }


    // update Post
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable("id") Long id){
         PostDto postResponse = postService.updatePost(postDto, id);
         return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }


    // delete Post
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully",HttpStatus.OK);
    }





}
