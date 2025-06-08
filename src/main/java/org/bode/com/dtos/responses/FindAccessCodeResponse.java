package org.bode.com.dtos.responses;

import lombok.Data;
import org.bode.com.data.models.AccessCode;
import org.bode.com.data.models.Visitor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;

@Data
public class FindAccessCodeResponse {
  private String message;
  private String token;
  private String id;
  private LocalDate creationDate;
  private LocalDate usedDate;
  private LocalDate expirationDate;
  private boolean active;
  @DBRef
  private Visitor visitor;
  private String residentPhoneNumber;
}
