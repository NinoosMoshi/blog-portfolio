package com.ninos.service;

import com.ninos.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    CommentDTO createComment(long postId, CommentDTO commentDTO);
    List<CommentDTO> getAllCommentsByPostId(Long postId);
    CommentDTO getCommentById(Long postId, Long commentId);
    CommentDTO updateComment(Long postId, Long commentId, CommentDTO commentRequest);
    void deleteComment(Long postId, Long commentId);


}
