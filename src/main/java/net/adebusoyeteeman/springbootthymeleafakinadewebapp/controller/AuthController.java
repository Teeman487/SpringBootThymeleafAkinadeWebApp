package net.adebusoyeteeman.springbootthymeleafakinadewebapp.controller;

import jakarta.validation.Valid;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto.RegistrationDto;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.entity.User;
import net.adebusoyeteeman.springbootthymeleafakinadewebapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController { // 89

    private UserService userService; // 91

    public AuthController(UserService userService) {
        this.userService = userService; // 91
    }


    // handler method to handle login page request
    @GetMapping("/login")
    public String loginPage(){  /*  <a th:href="@{/login}"> Login Here</a>*/
        return "login";
    }

    // handler method to handle user registration request
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        //this object holds from data
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";

    }

    // handler method to handel user registration form submit request 91
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user, // @Valid //92
                           BindingResult result,
                           Model model){
        User existingUser = userService.findByEmail(user.getEmail()); //92
        if(existingUser != null && existingUser.getEmail() !=null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null, "There is already a user with same email id");
        }

        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success"; // to show the success message
    }
}



/* @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user,
                           BindingResult result,
                           Model model){
        User existingUser = userService.findByEmail(user.getEmail());
        if(existingUser != null && existingUser.getEmail() !=null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null, "There is already a user with same email id");
        }

        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }*/





/*@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // handler method to handle login page request
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    // handler method to handle user registration request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // this object holds form data
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user,
                           BindingResult result,
                           Model model){
        User existingUser = userService.findByEmail(user.getEmail());
        if(existingUser != null && existingUser.getEmail() !=null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null, "There is already a user with same email id");
        }

        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }
}*/