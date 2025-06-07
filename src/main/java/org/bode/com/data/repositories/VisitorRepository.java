package org.bode.com.data.repositories;

import org.bode.com.data.models.AccessCode;
import org.bode.com.data.models.Visitor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends MongoRepository<Visitor, String> {
    Visitor findVisitorByPhoneNumber(String PhoneNumber);
    Visitor findVisitorById(String Id);

}
