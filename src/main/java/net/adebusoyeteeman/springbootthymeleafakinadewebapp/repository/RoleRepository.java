package net.adebusoyeteeman.springbootthymeleafakinadewebapp.repository;

import net.toheebcode.springbootblogcontentstoreswebapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
