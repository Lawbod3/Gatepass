package org.bode.com.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterResidentRequest {
    @NotEmpty(message = "FullName can not be empty")
    @Size(max = 100, message = "FullName can not exceed 100 characters")
    private String fullName;
    @NotEmpty(message = "PhoneNumber can not be empty")
    private String phoneNumber;
    @NotEmpty(message = "Address can not be empty")
    @Size(max = 400, message = "Address can not exceed 400 characters")
    private String address;
    @Email(message = "Invalid email format")
    private String email;

}
