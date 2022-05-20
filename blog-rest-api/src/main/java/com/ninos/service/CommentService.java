package com.ninos.service;

import com.ninos.dto.CommentDTO;

public interface CommentService {

    CommentDTO createComment(long postId, CommentDTO commentDTO);


}
