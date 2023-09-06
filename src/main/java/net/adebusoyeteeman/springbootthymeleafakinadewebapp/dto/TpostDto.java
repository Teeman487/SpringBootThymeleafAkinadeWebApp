package net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;


@Data  // auto generate Getter &Setters method, ToString method, equals and Hashcode methods etc
@Builder // Generate building pattern for this class

@NoArgsConstructor
// we intend to instantiate  handler method to handle new post request  PostDto postDto = new PostDto();
@AllArgsConstructor //
public class TpostDto { //Model entity- is useful when we want to transport data between Controller layer & View Layer
    private Long id;
    @NotEmpty(message = "project title should not be empty")
    private String projectTitle;
    private String url;
    @NotEmpty (message = "content should not be empty")
    private String content;
    @NotEmpty (message = "brief title description should not be empty")
    private String adebusoyeBriefContent;

    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
    private Set<CommentDto> comments; // 82 Display list of comments for Blog post
}




    /*@NotEmpty(message = "post title should not be empty")
    private String title;
    private String url;

    @NotEmpty(message = "post content should not be empty")
    private String content;
    @NotEmpty(message = "post short description should not be empty")
    private String shortDescription;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
    private Set<CommentDto> comments; // 82*/
