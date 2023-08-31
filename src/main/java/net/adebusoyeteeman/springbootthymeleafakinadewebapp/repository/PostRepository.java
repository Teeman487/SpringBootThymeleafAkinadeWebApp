package net.adebusoyeteeman.springbootthymeleafakinadewebapp.repository;

import net.adebusoyeteeman.springbootthymeleafakinadewebapp.entity.Tpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Tpost, Long> { // Post-Entity Type, Long-Primary Type
    Optional<Tpost> findByUrl(String url);  // SetupRules: Query or find method


    @Query("SELECT p from Tpost p WHERE " +
            " p.projectTitle LIKE CONCAT('%', :query, '%') OR " +
            " p.adebusoyeBriefContent LIKE CONCAT('%', :query, '%') " )  // JPQL is Java Persistnce Query Language defined in JPA specification. It is used to create queries against entities to store relational datbase
    List<Tpost> searchPosts (String query);
}
// jpaRepository<Post, Long> is a Generic interface , Long type of primary key
//all method in JpaRepository are by default Transactional

/*
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByUrl(String url);

    @Query("SELECT p from Post p WHERE " +
            " p.title LIKE CONCAT('%', :query, '%') OR " +
            " p.shortDescription LIKE CONCAT('%', :query, '%')")
    List<Post> searchPosts(String query);

    @Query(value = "select * from posts p where p.created_by =:userId", nativeQuery = true)
    List<Post> findPostsByUser(Long userId);
}*/
