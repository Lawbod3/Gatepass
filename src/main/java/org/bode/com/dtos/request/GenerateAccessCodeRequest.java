package org.bode.com.dtos.request;


import lombok.Data;
import org.bode.com.data.models.AccessCode;
import org.bode.com.data.models.Visitor;

import java.time.LocalDate;

@Data
public class GenerateAccessCodeRequest  {
   private String residentId;
    private LocalDate expirationDate;
    private String visitorId;
}
