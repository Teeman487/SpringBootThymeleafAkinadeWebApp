package net.adebusoyeteeman.springbootthymeleafakinadewebapp.service;

import net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto.RegistrationDto;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.entity.User;


public interface UserService {
    void saveUser(RegistrationDto registrationDto);
   User findByEmail(String email);
}

/*public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    User findByEmail(String email);
}*/