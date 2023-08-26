package net.adebusoyeteeman.springbootthymeleafakinadewebapp.repository;

import net.toheebcode.springbootblogcontentstoreswebapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository <Comment, Long> {

}
