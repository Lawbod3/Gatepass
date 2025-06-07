package org.bode.com.dtos.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.bode.com.data.models.AccessCode;
import org.bode.com.data.models.Resident;
import org.bode.com.data.models.Visitor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;

@Data
public class GenerateAccessCodeRequest  {
    private String token;
    private LocalDate issuedDate;
    private LocalDate expirationDate;
    @NotEmpty(message = "Visitor PhoneNumber can not be empty")
    private String visitorPhoneNumber;
    @NotEmpty(message = "Visitor FullName can not be empty")
    private String visitorFullName;
    @Email
    private String residentEmail;


    public GenerateAccessCodeRequest(){
        issuedDate = LocalDate.now();
        expirationDate = LocalDate.now().plusDays(7);
    }
}


