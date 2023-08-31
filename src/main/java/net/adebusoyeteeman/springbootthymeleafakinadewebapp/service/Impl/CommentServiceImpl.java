package net.adebusoyeteeman.springbootthymeleafakinadewebapp.service.Impl;

import net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto.CommentDto;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.entity.Comment;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.entity.Tpost;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.mapper.CommentMapper;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.repository.CommentRepository;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.repository.PostRepository;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.service.CommentService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void createComment(String postUrl, CommentDto commentDto) {

        Tpost tpost = postRepository.findByUrl(postUrl).get();
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

}