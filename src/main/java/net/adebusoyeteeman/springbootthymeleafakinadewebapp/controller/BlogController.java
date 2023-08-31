package net.adebusoyeteeman.springbootthymeleafakinadewebapp.controller;

import net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto.CommentDto;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto.TpostDto;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.service.TpostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {
    private TpostService tpostService;

    public BlogController(TpostService tpostService) {
        this.tpostService=tpostService;
    }


    //68 handler method to handle http://localhost:8080/
    @GetMapping("/")
    public String viewBlogPosts(Model model){
        List<TpostDto> tpostsResponse = tpostService.findAllPosts();
        model.addAttribute("tpostsResponse", tpostsResponse);
        return "blog/view_tposts";

    }

    //70 handler method to handle view post request
   @GetMapping("/tpost/{tpostUrl}")
    private String showPost(@PathVariable("tpostUrl") String tpostUrl,
                            Model model) {
        TpostDto tpost = tpostService.findPostByUrl(tpostUrl);
        //79 Create comment form Handling
        CommentDto commentDto = new CommentDto();  //79 Create comment form Handling
        model.addAttribute("tpost", tpost);
        model.addAttribute("comment",commentDto);  //79 Create comment form Handling
        return "blog/blog_tpost";
    }
     // 71 handler method to handle blog post search request
    // http://localhost:8080/page/search?query=java
    @GetMapping("/page/search")

    public String searchPosts(@RequestParam(value="query") String query,
                              Model model) {
        List<TpostDto> tpostsResponse = tpostService.searchPosts(query);
        model.addAttribute("tpostsResponse", tpostsResponse);
        return "blog/view_tposts";
    }









}





/*@Controller
public class BlogController {

    private PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

    // handler method to handle http://localhost:8080/
    @GetMapping("/")
    public String viewBlogPosts(Model model){
        List<PostDto> postsResponse = postService.findAllPosts();
        model.addAttribute("postsResponse", postsResponse);
        return "blog/view_posts";
    }

    // handler method to handle view post request
    @GetMapping("/post/{postUrl}")
    private String showPost(@PathVariable("postUrl") String postUrl,
                            Model model){
        PostDto post = postService.findPostByUrl(postUrl);

        CommentDto commentDto = new CommentDto();
        model.addAttribute("post", post);
        model.addAttribute("comment", commentDto);
        return "blog/blog_post";
    }

    // handler method to handle blog post search request
    // http://localhost:8080/page/search?query=java
    @GetMapping("/page/search")
    public String searchPosts(@RequestParam(value = "query") String query,
                              Model model){
        List<PostDto> postsResponse = postService.searchPosts(query);
        model.addAttribute("postsResponse", postsResponse);
        return "blog/view_posts";
    }
}*/
