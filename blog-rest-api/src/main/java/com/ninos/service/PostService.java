package com.ninos.service;

import com.ninos.dto.PostDto;
import com.ninos.dto.PostResponse;

import java.util.List;

public interface PostService {

     PostDto createPost(PostDto postDto);
     PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
     PostDto getPostById(Long id);
     PostDto updatePost(PostDto postDto, Long id);
     void deletePostById(Long id);

}
