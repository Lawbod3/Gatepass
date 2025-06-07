package org.bode.com.data.models;

import lombok.Data;
import org.bode.com.data.repositories.VisitorRepository;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document("AccessCode")
public class AccessCode {
    private String token;
    @Id
    private long id;
    private LocalDate creationDate;
    private LocalDate usedDate;
    private LocalDate expirationDate;
    private boolean active;
    private Visitor visitor;
    private Resident resident;
}
