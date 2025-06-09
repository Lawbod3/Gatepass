package org.bode.com.dtos.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.time.LocalDate;

@Data
public class GenerateAccessCodeRequest  {

    @NotBlank(message = "Visitor PhoneNumber can not be empty")
    private String visitorPhoneNumber;
    @NotBlank(message = "Visitor FullName can not be empty")
    private String visitorFullName;
    @Email
    private String residentEmail;

}


