package org.bode.com.dtos.request;


import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class LoginResidentRequest {

    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Password can not be empty")
    private String password;
}
