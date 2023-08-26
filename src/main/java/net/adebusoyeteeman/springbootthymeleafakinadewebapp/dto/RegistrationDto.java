package net.adebusoyeteeman.springbootthymeleafakinadewebapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    private Long id;

    @NotEmpty // 92
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty(message = "Email should not be empty or null") // 92
    @Email // 92
    private String email;

    @NotEmpty(message = "Password should not be empty") // 92
    private String password;
}

/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty(message = "Email should not be empty or null")
    @Email
    private String email;

    @NotEmpty(message = "Password should not be empty")
    private String password;
}*/


