package net.adebusoyeteeman.springbootthymeleafakinadewebapp.controller;

import jakarta.validation.Valid;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto.CommentDto;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto.TpostDto;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.service.CommentService;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.service.TpostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    private CommentService commentService;
    private TpostService tpostService; // 81

    public CommentController(CommentService commentService, TpostService tpostService) {
        this.commentService = commentService;
        this.tpostService = tpostService;
    }

    // handler method to createform submit request
    /*th:action="@{/{tpostUrl}/comments(tpostUrl=${tpost.url})}"
    th:object="${comment}"*/
    //th:href="@{/tpost/{tpostUrl}(tpostUrl=${tpost.url})}"
    @PostMapping("/{tpostUrl}/comments")
    public String createComment(@PathVariable("tpostUrl") String tpostUrl,
                                @Valid @ModelAttribute("comment") CommentDto commentDto,
                                BindingResult result, // 81
                                Model model){ //@Valid //81
        // 81

      TpostDto tpostDto = tpostService.findPostByUrl(tpostUrl);
        if(result.hasErrors()){
            model.addAttribute("tpost", tpostDto);
            model.addAttribute("comment", commentDto);
            return "blog/blog_tpost";
        }
        commentService.createComment(tpostUrl, commentDto);
        return "redirect:/tpost/" + tpostUrl;


    }
}



/*@Controller
public class CommentController {

    private CommentService commentService;
    private PostService postService;

    public CommentController(CommentService commentService,PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    // handler method to create form submit request
    @PostMapping("/{postUrl}/comments")
    public String createComment(@PathVariable("postUrl") String postUrl,
                                @Valid @ModelAttribute("comment") CommentDto commentDto,
                                BindingResult result,
                                Model model){

        PostDto postDto = postService.findPostByUrl(postUrl);
        if(result.hasErrors()){
            model.addAttribute("post", postDto);
            model.addAttribute("comment", commentDto);
            return "blog/blog_post";
        }

        commentService.createComment(postUrl, commentDto);
        return "redirect:/post/" + postUrl;
    }
}*/
