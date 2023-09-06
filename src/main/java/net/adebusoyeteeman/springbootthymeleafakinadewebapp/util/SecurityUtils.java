// 105 Refactor Create Post Feature for LoggedIn User
// write the code to get the login User id from the spring security

package net.adebusoyeteeman.springbootthymeleafakinadewebapp.util;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

/*package net.javaguides.springboot.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;*/

public class SecurityUtils {

    public static User getCurrentUser(){
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principle instanceof User){
            return (User) principle;
        }
        return null;
    }


    /*109 Refactor List Posts and Comments Feature for Admin*/

    public static String getRole(){
        User user = getCurrentUser();
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        for(GrantedAuthority authority: authorities){
            return authority.getAuthority();
        }
        return null;
    }
}
