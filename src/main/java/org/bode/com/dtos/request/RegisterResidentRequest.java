package org.bode.com.dtos.request;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class RegisterResidentRequest {
    @NotBlank(message = "FullName can not be empty")
    @Size(max = 100, message = "FullName can not exceed 100 characters")
    private String fullName;
    @NotBlank(message = "PhoneNumber can not be empty")
    private String phoneNumber;
    @NotEmpty(message = "Address can not be empty")
    @Size(min= 1,max = 400, message = "Address can not exceed 400 characters")
    private String address;
    @Email(message = "Invalid email format")
    private String email;
    @NotEmpty(message = "Password cant be empty")
    @Size(min=6,max = 50, message = "Password can not exceed 50 characters")
    private String password;

}
