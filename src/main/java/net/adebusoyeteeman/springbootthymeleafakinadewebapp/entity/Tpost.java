package net.adebusoyeteeman.springbootthymeleafakinadewebapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // building design pattern for the class
@Entity  // specifies that the class is an entity, next we need to map this JPA entity with a class table
@Table(name="tposts")  // to customize table
public class Tpost {   //post jpa entity // To verify whether hibernate will create a database table for this post jpa entity or not
    //whenever you create Entity, create at least 1 primary key
    @Id  // specifies the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key Generated strategy; identity behind the scene uses database providing Auto increment feature; when hibernate enters or insert the record, then database will Auto increment the primary key and store in the dataBaseTable
    private Long id;
    @Column(nullable = false)  // optional annotation that enables you to customize the mapping between the entity field(title) and the database column
    private String projectTitle;
    private String url;
    @Lob
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String content; // content field not null
    private String adebusoyeBriefContent;

    @CreationTimestamp    // will help to automatically populate value for the field createdOn
    private LocalDateTime createdOn;  //blogPost creation date
    @UpdateTimestamp     // will auto populate value
    private LocalDateTime updateOn;   //blogPost updated date
    //75

    @ManyToOne   // 102
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @OneToMany(mappedBy = "tpost", cascade = CascadeType.REMOVE)
    private Set<Comment> comments = new HashSet<>();

}
