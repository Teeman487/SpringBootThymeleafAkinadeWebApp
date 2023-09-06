package net.adebusoyeteeman.springbootthymeleafakinadewebapp.service.Impl;

import net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto.CommentDto;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.entity.Comment;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.entity.Tpost;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.entity.User;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.mapper.CommentMapper;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.repository.CommentRepository;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.repository.TpostRepository;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.repository.UserRepository;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.service.CommentService;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.util.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;




@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private TpostRepository tpostRepository;
    private UserRepository userRepository; //108 Refactor Admin Side List Comments Feature

    public CommentServiceImpl(CommentRepository commentRepository, TpostRepository tpostRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.tpostRepository = tpostRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createComment(String postUrl, CommentDto commentDto) {

        Tpost tpost = tpostRepository.findByUrl(postUrl).get();
        Comment comment = CommentMapper.mapToComment(commentDto);
        comment.setTpost(tpost);
        commentRepository.save(comment);
    }


    @Override
    public List<CommentDto> findAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(CommentMapper::mapToCommentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override  //108 Refactor Admin Side List Comments Feature
    public List<CommentDto> findCommentsByPost() {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User createdBy = userRepository.findByEmail(email);
        Long userId = createdBy.getId();
        List<Comment> comments = commentRepository.findCommentsByPost(userId);
        return comments.stream()
                .map((comment) -> CommentMapper.mapToCommentDto(comment))
                .collect(Collectors.toList());
    }

}
