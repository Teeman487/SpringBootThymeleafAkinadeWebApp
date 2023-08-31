package net.adebusoyeteeman.springbootthymeleafakinadewebapp.service;

import net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto.TpostDto;

import java.util.List;

public interface TpostService {// Define a method that will retrieve all the posts from database table
    List<TpostDto> findAllPosts();

    void createYourPost(TpostDto tpostDto); //Create Handler Method to Save Post: // handle method to handle form submit request; Once we handle the form request we need to also save the form data to the database - change service lauer-

    TpostDto findPostById(Long tpostId);
    // go to PostService, create a method
    void updatePost(TpostDto tpostDto);

   void deletePost(Long tpostId);

    TpostDto findPostByUrl(String tpostUrl); // fir view Tpost Request

   List<TpostDto> searchPosts(String query); //64
}