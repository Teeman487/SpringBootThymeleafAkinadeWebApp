package net.adebusoyeteeman.springbootthymeleafakinadewebapp.repository;

import net.toheebcode.springbootblogcontentstoreswebapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> { // Post-Entity Type, Long-Primary Type
    Optional<Post> findByUrl(String url);  // SetupRules: Query or find method

    @Query("SELECT p from Post p WHERE " +
            " p.title LIKE CONCAT('%', :query, '%') OR " +
             " p.shortDescription LIKE CONCAT('%', :query, '%') " )  // JPQL is Java Persistnce Query Language defined in JPA specification. It is used to create queries against entities to store relational datbase
    List<Post> searchPosts (String query);
}
// jpaRepository<Post, Long> is a Generic interface , Long type of primary key
//all method in JpaRepository are by default Transactional