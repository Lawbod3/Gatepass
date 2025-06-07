package org.bode.com.data.repositories;

import org.bode.com.data.models.Resident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class ResidentsTest {
    @Autowired
    private ResidentRepository residents;

    @BeforeEach
    public void setUp() {
        residents.deleteAll();
    }

    @Test
    public void testResidentsIsZeroByCount() {
        assertEquals(0, residents.count());
    }

    @Test
    public void TestResidentsIsOneByCount() {
        Resident resident = new Resident();
        residents.save(resident);
        assertEquals(1, residents.count());

    }

    @Test
    public void TestResidentsCanFindById() {

        Resident resident = new Resident();
        Resident savedResident = residents.save(resident);
        Resident foundResident = residents.findById(savedResident.getId()).get();
        assertEquals(savedResident, foundResident);

    }






}
