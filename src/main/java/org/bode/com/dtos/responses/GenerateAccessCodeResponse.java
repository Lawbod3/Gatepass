package org.bode.com.dtos.responses;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GenerateAccessCodeResponse {
    private String token;
    private String visitorId;
    private LocalDate expirationDate;
    private Boolean active;
    private String residentAddress;
}
