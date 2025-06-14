package org.bode.com.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Visitor")
public class Visitor {
    @Id
    private String id;
    private String fullName;
    private String phoneNumber;
}
