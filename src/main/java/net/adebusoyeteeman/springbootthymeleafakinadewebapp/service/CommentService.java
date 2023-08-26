package net.adebusoyeteeman.springbootthymeleafakinadewebapp.service;

import net.toheebcode.springbootblogcontentstoreswebapp.dto.CommentDto;

import java.util.List;

public interface CommentService {
    void createComment(String postUrl, CommentDto commentDto);

    List<CommentDto> findAllComments();

    void deleteComment(Long commentId);  // 85

    // 83
}
