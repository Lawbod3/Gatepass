package org.bode.com.dtos.request;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterResidentRequest {
    @NotNull(message = "FullName can not be empty")
    @Size(max = 100, message = "FullName can not exceed 100 characters")
    private String fullName;
    @NotNull(message = "PhoneNumber can not be empty")
    private String phoneNumber;
    @NotNull(message = "Address can not be empty")
    @Size(max = 400, message = "Address can not exceed 400 characters")
    private String address;
    @Email(message = "Invalid email format")
    private String email;
    @NotNull(message = "Password cant be empty")
    @Size(max = 50, message = "Password can not exceed 50 characters")
    private String password;

}
