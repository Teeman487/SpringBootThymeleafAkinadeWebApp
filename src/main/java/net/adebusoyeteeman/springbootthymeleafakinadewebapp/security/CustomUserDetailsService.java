package net.adebusoyeteeman.springbootthymeleafakinadewebapp.security;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/*
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user != null){
            org.springframework.security.core.userdetails.User authenticatedUser =
                    new org.springframework.security.core.userdetails.User(
                            user.getEmail(),
                            user.getPassword(),
                            user.getRoles().stream()
                                    .map((role) -> new SimpleGrantedAuthority(role.getName()))
                                    .collect(Collectors.toList())
                    );
            return authenticatedUser;
        }else {
            throw new UsernameNotFoundException("Invalid username and password");
        }
    }
}*/
