package net.adebusoyeteeman.springbootthymeleafakinadewebapp.service;

import net.toheebcode.springbootblogcontentstoreswebapp.dto.RegistrationDto;
import net.toheebcode.springbootblogcontentstoreswebapp.entity.User;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    User findByEmail(String email);
}

/*public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    User findByEmail(String email);
}*/