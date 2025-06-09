package org.bode.com.dtos.request;


import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class FindAccessCodeRequest {
    @NotBlank(message = "Token can not be Null")
    private String token;




}
