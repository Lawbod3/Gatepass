package org.bode.com.dtos.request;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class LoginResidentRequest {

    @Email(message = "Invalid email format")
    private String email;
    private String id;
}
