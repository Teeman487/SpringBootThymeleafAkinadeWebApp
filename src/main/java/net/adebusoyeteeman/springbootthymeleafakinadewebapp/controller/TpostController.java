package net.adebusoyeteeman.springbootthymeleafakinadewebapp.controller;

import jakarta.validation.Valid;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto.CommentDto;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto.TpostDto;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.service.CommentService;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.service.TpostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller  //
public class TpostController { // Spring tea recomend to use interface for injecting the dependency to achieve loose coupling

    private TpostService tpostService; // Spring tea recomend to use interface for injecting the dependency to achieve loose coupling
    private CommentService commentService; // 83
    public TpostController(TpostService postService, CommentService commentService) {
        this.tpostService = postService; this.commentService=commentService;
    }

    // create handler method, GET request and return model view
    // http://localhost:8080/admin/tposts
    @GetMapping("/admin/tposts")
    public String tposts(Model model) {
        List<TpostDto> tposts = tpostService.findAllPosts();
        model.addAttribute("tposts", tposts);
        return "/admin/tposts"; // Thymeleaf view name

    }

    // handler method to handle list comments request 83
    @GetMapping("/admin/tposts/comments")
    public String postComments(Model model) {
        List<CommentDto> comments = commentService.findAllComments();
        model.addAttribute("comments", comments);
        return "admin/comments";
    }
    // handler method to handle delete comment request 85
    @GetMapping("/admin/tposts/comments/{commentId}")
    public String deleteComment(@PathVariable("commentId") Long commentId){
        commentService.deleteComment(commentId);
        return "redirect:/admin/tposts/comments";
    }


    // 46  handler method to handle new post request
    @GetMapping("admin/tposts/newtpost")
    //  build tposts and newtpost in tposts.html/header in nav <li , <a @{admin/tposts /a> T-Post
    // handler method to handle new post request
    public String newTpostForm(Model model) {
        TpostDto tpostDto = new TpostDto();  // empty to use it in create post thymeleaf template
        model.addAttribute("tpost", tpostDto);   ///
        return "admin/create_tpost"; // Create Post Form Handling in template.admin in Html and design

    }

    // 48 handler method to handle form submit request
    @PostMapping("/admin/tposts")
    public String createYourPost(@Valid @ModelAttribute("tpost") TpostDto tpostDto, //Step3: Enable Validation using @Valid Annotation in // handler method to handle form submit request
                             BindingResult result,   // step4:Use BindingResult to Check Errors and Return to UI
                             Model model          // step5 @ModelAttribute(""post) will pass coment for empty submission
    ){ // ModelAttribute annotation will read form data and set the values to fields of the model object
        if(result.hasErrors()){
            model.addAttribute("tpost", tpostDto);
            return "admin/create_tpost";
        }


        tpostDto.setUrl(getUrl(tpostDto.getProjectTitle()));
        tpostService.createYourPost(tpostDto);
        return "redirect:/admin/tposts";
    }

    //50 handler method to handle edit post request
    @GetMapping("/admin/tposts/{tpostId}/edit")
    public String editPostForm(@PathVariable("tpostId") Long tpostId,
                               Model model){

        TpostDto tpostDto = tpostService.findPostById(tpostId);
        model.addAttribute("tpost", tpostDto);
        return "admin/edit_tpost";

    }

    // 55 handler method to handle edit post form submit request
    @PostMapping("/admin/tposts/{tpostId}")
    public  String  updatePost(@PathVariable("tpostId") Long tpostId,
                               @Valid @ModelAttribute("tpost") TpostDto tpost,
                               BindingResult result,
                               Model model) {
        if(result.hasErrors()){
            model.addAttribute("tpost",tpost);
            return  "admin/edit_tpost";
        }
        tpost.setId(tpostId);
        tpostService.updatePost(tpost);
        return "redirect:/admin/tposts";
    }


    // handler method to handle delete post request
    @GetMapping("/admin/tposts/{tpostId}/delete")
    public String deletePost(@PathVariable("tpostId") Long tpostId){
        tpostService.deletePost(tpostId);
        return "redirect:/admin/tposts";

    }

    // 60 handle method to handle view post request
    @GetMapping("/admin/tposts/{tpostUrl}/view")
    public String viewPost(@PathVariable("tpostUrl") String tpostUrl,
                           Model model) {
        TpostDto tpostDto = tpostService.findPostByUrl(tpostUrl);
        model.addAttribute("tpost", tpostDto);
        return "admin/view_tpost";
    }



    //Handler method to handle search blog posts request
    // localhost:8080/admin/tposts/search?query=java
    @GetMapping("/admin/tposts/search")
    public String searchPosts(@RequestParam(value = "query") String query,
                              Model model){
        List<TpostDto> tposts = tpostService.searchPosts(query);
        model.addAttribute("tposts", tposts);
        return "admin/tposts";

    }


    ///////
    private static String getUrl(String postTitle) { //   // handler method to handle form submit request---
        // OOPS Concepts Explained in Java
        // oops-concepts-explained-in-java
        String title = postTitle.trim().toLowerCase();
        String url= title.replaceAll("\\s+","-");
        url = url.replaceAll("[^A-Za-z0-9]","-");
        return url;
    }


}



