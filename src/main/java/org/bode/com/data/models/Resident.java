package org.bode.com.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Resident")
public class Resident {
    @Id
    private String id;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String email;
    private String password;



}
