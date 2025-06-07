package org.bode.com.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Visitor")
public class Visitor {
    private String id;
    private String phoneNumber;
}
