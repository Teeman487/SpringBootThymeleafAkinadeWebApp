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
@Table(name="posts")  // to customize table
public class Post {   //post jpa entity // To verify whether hibernate will create a database table for this post jpa entity or not
      //whenever you create Entity, create at least 1 primary key
    @Id  // specifies the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primarykey Generated strategy; identity behind the scene uses database providing Auto increment feature; when hibernate enters will insert the record, then database will Auto increment the primary key and store in the dataBaseTable
    private Long id;
    @Column(nullable = false)  // optional annotation that enables you to customize the mapping between the entity field(title) and the database column
    private String title;
    private String url;
    @Lob
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String content; // content field not null
    private String shortDescription;

    @CreationTimestamp    // will help to automatically populate value for the field createdon
    private LocalDateTime createdOn;  //blogPost creation date
    @UpdateTimestamp     // will auto populate value
    private LocalDateTime updateOn;   //blogPost updated date

    //75
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private Set<Comment> comments = new HashSet<>();

}


/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String url;

    @Lob
    @Column(nullable = false)
    private String content;
    private String shortDescription;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private Set<Comment> comments = new HashSet<>();
}
*/