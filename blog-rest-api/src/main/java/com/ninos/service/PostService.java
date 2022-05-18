package com.ninos.service;

import com.ninos.dto.PostDto;

import java.util.List;

public interface PostService {

    public PostDto createPost(PostDto postDto);
    public List<PostDto> getAllPost();

}
