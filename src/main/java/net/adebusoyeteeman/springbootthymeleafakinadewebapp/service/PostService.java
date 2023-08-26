package net.adebusoyeteeman.springbootthymeleafakinadewebapp.service;

import net.toheebcode.springbootblogcontentstoreswebapp.dto.PostDto;

import java.util.List;

public interface PostService { // Define a method that will retrieve all the posts from database table
    List<PostDto> findAllPosts();

    void createPost(PostDto postdto); //Create Handler Method to Save Post: // handle method to handle form submit request; Once we handle the form request we need to also save the form data to the database - change service lauer-
   // go to PostService, create a method

    PostDto findPostById(Long postId);

    void updatePost(PostDto postDto);

    void deletePost(Long postId);

    PostDto findPostByUrl(String postUrl);

    List<PostDto> searchPosts(String query);  //64
}