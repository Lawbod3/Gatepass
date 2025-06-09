package org.bode.com.dtos.request;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FindAccessCodeRequest {
    @NotNull(message = "Token can not be Null")
    private String token;




}
