package org.bode.com.data.repositories;

import jakarta.validation.constraints.NotEmpty;
import org.bode.com.data.models.AccessCode;
import org.bode.com.data.models.Visitor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitorRepository extends MongoRepository<Visitor, String> {


    boolean existsByPhoneNumber(String phoneNumber);

    Optional<Visitor> findByPhoneNumber(String id);
}
