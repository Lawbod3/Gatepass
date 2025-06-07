package org.bode.com.dtos.responses;

import lombok.Data;
import org.bode.com.data.models.AccessCode;

import java.time.LocalDate;

@Data
public class FindAccessCodeResponse {
  private String message;
}
