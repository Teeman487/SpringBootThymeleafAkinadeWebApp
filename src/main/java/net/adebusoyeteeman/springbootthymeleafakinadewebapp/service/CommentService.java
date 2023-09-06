package net.adebusoyeteeman.springbootthymeleafakinadewebapp.service;

import net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto.CommentDto;

import java.util.List;

public interface CommentService {
    void createComment(String tpostUrl, CommentDto commentDto);

    List<CommentDto> findAllComments();

   void deleteComment(Long commentId);  // 85

    // 83
    List<CommentDto> findCommentsByPost();
}
