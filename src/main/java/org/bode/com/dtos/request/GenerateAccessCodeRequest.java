package org.bode.com.dtos.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.time.LocalDate;

@Data
public class GenerateAccessCodeRequest  {

    @NotNull(message = "Visitor PhoneNumber can not be empty")
    private String visitorPhoneNumber;
    @NotNull(message = "Visitor FullName can not be empty")
    private String visitorFullName;
    @Email
    private String residentEmail;

}


