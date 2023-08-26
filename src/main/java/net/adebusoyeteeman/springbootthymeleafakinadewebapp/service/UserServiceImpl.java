package net.adebusoyeteeman.springbootthymeleafakinadewebapp.service;

import net.toheebcode.springbootblogcontentstoreswebapp.dto.RegistrationDto;
import net.toheebcode.springbootblogcontentstoreswebapp.entity.Role;
import net.toheebcode.springbootblogcontentstoreswebapp.entity.User;
import net.toheebcode.springbootblogcontentstoreswebapp.repository.RoleRepository;
import net.toheebcode.springbootblogcontentstoreswebapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service  // 91
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository repository) {
        this.userRepository = userRepository;
        this.roleRepository = repository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setName(registrationDto.getFirstName() + " " + registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        // use spring security to encrypt the password
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("ROLE_GUEST");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

//92
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}


/*
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    // private PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        //  this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setName(registrationDto.getFirstName() + " " + registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        // use spring security to encrypt the password
        // user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_GUEST");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
*/
