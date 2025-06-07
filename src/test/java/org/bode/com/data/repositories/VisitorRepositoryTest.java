package org.bode.com.data.repositories;

import lombok.Data;
import org.bode.com.data.models.Visitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class VisitorRepositoryTest {
   @Autowired
   private VisitorRepository repository;

   @BeforeEach
   public void setUp() {
      repository.deleteAll();
   }

   @Test
   public void testThatRepositoryIsEmpty() {
      assertTrue(repository.findAll().isEmpty());
   }

   @Test
   public void testThatRepositoryIsNotEmpty() {
      Visitor visitor = new Visitor();
      repository.save(visitor);
      assertNotNull(repository.findAll());
   }



}
