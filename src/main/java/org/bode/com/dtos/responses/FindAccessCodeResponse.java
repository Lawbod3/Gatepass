package org.bode.com.dtos.responses;

import lombok.Data;
import org.bode.com.data.models.AccessCode;

import java.time.LocalDate;

@Data
public class FindAccessCodeResponse {
    private String token;
    private String visitorPhoneNumber;
    private String VisitorFullName;
    private LocalDate creationDate;
    private LocalDate expirationDate;
    private LocalDate usedDate;
    private Boolean active;
    private String residentAddress;
}
