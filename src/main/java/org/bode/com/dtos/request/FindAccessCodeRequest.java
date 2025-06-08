package org.bode.com.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.bode.com.data.models.Visitor;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class FindAccessCodeRequest {
    @NotNull(message = "Token can not be Null")
    private String token;
    private String visitorPhoneNumber;



}
