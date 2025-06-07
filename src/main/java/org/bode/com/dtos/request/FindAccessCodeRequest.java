package org.bode.com.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.bode.com.data.models.Visitor;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class FindAccessCodeRequest {

    private String token;
    private String visitorPhoneNumber;

    private Boolean active;

}
