package org.bode.com.data.repositories;

import org.bode.com.data.models.AccessCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AccessCodeRepositoryTest {
    @Autowired
    private AccessCodeRepository repo;

    @BeforeEach
    public void setUp() {
        repo.deleteAll();
    }

    @Test
    public void testThatAccessCodeRepositoryIsEmpty() {
        assertTrue(repo.findAll().isEmpty());
    }

    @Test
    public void testThatAccessCodeRepositoryIsNotEmpty() {
        AccessCode accessCode = new AccessCode();
        repo.save(accessCode);
        assertTrue(repo.findAll().contains(accessCode));
    }



}
