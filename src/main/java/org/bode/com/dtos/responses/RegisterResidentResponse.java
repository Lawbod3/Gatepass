package org.bode.com.dtos.responses;

import lombok.Data;

@Data
public class RegisterResidentResponse {
    private String fullName;
    private String address;
    private String email;
    private String phoneNumber;
    private String message;
    private String id;
}
