package net.adebusoyeteeman.springbootthymeleafakinadewebapp.repository;

import net.toheebcode.springbootblogcontentstoreswebapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);


}
