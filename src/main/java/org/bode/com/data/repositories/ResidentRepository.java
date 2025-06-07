package org.bode.com.data.repositories;

import jakarta.validation.constraints.Email;
import org.bode.com.data.models.Resident;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResidentRepository  extends MongoRepository<Resident, Long> {



   Optional< Resident> findByEmail(String email);
      boolean existsByEmail(String email);
}
