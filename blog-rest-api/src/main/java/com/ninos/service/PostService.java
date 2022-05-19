package com.ninos.service;

import com.ninos.dto.PostDto;

import java.util.List;

public interface PostService {

     PostDto createPost(PostDto postDto);
     List<PostDto> getAllPost();
     PostDto getPostById(Long id);
     PostDto updatePost(PostDto postDto, Long id);
     void deletePostById(Long id);

}
