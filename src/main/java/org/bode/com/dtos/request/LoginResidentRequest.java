package org.bode.com.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginResidentRequest {

    @Email(message = "Invalid email format")
    private String email;
    @NotEmpty(message = "Password can not be empty")
    private String password;
}
