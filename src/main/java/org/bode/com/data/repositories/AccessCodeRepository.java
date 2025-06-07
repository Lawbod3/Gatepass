package org.bode.com.data.repositories;

import org.bode.com.data.models.AccessCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessCodeRepository extends MongoRepository<AccessCode, String> {
    boolean existsByToken(String token);

    AccessCode findAccessCodeByToken(String token);
    AccessCode findAccessCodeByVisitorPhoneNumber(String phoneNumber);


}
