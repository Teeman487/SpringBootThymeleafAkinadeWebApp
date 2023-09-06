package net.adebusoyeteeman.springbootthymeleafakinadewebapp.repository;

import net.adebusoyeteeman.springbootthymeleafakinadewebapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "select c.* from comments c inner join tposts p\n" +
            "where c.tpost_id = p.id and p.created_by =:userId", nativeQuery = true)
    List<Comment> findCommentsByPost(Long userId);
    // 108 Refactor Admin Side List Commewnts Feature

}
