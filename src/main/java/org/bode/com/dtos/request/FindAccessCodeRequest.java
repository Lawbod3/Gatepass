package org.bode.com.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.bode.com.data.models.Visitor;

@Data
public class FindAccessCodeRequest {

    private String token;
    private Visitor visitorId;
    private Boolean active;

}
