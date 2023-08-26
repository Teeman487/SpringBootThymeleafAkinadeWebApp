package net.adebusoyeteeman.springbootthymeleafakinadewebapp.mapper;

import net.toheebcode.springbootblogcontentstoreswebapp.dto.PostDto;
import net.toheebcode.springbootblogcontentstoreswebapp.entity.Post;

import java.util.stream.Collectors;

public class PostMapper {

    // map Post entity to PostDto
    public static PostDto mapToPostDto(Post post){
        // PostDto  postDto = PostDto.builder()
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .url(post.getUrl())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .createdOn(post.getCreatedOn())
                .updateOn(post.getUpdateOn())
                //82
                .comments(post.getComments().stream()
                        .map(comment -> CommentMapper.mapToCommentDto(comment))
                        .collect(Collectors.toSet())) //82

                .build();
        //return postDto;
    }

    // MAP Postdto to Post entity
    public static Post mapToPost(PostDto postDto) {
        return Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .url(postDto.getUrl())
                .content(postDto.getContent())
                .shortDescription(postDto.getShortDescription())
                .createdOn(postDto.getCreatedOn())
                .updateOn(postDto.getUpdateOn())
                .build();
    }
}


/*public class PostMapper {

    // map Post entity to PostDto
    public static PostDto mapToPostDto(Post post){
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .url(post.getUrl())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .createdOn(post.getCreatedOn())
                .updatedOn(post.getUpdatedOn())
                .comments(post.getComments().stream()
                        .map((comment) -> CommentMapper.mapToCommentDto(comment))
                        .collect(Collectors.toSet()))
                .build();
    }

    // map Postdto to Post entity
    public static Post mapToPost(PostDto postDto){
        return Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .url(postDto.getUrl())
                .shortDescription(postDto.getShortDescription())
                .createdOn(postDto.getCreatedOn())
                .updatedOn(postDto.getUpdatedOn())
                .build();
    }
}*/