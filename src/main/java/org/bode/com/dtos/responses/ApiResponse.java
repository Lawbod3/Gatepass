package org.bode.com.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<Object> {
    private boolean success;
    private String message;
    private Object data;
}
