package net.adebusoyeteeman.springbootthymeleafakinadewebapp.repository;

import net.adebusoyeteeman.springbootthymeleafakinadewebapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}



/*package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
*/
