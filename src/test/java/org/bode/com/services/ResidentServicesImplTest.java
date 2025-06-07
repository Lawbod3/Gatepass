package org.bode.com.services;

import org.bode.com.data.repositories.ResidentRepository;
import org.bode.com.dtos.request.LoginResidentRequest;
import org.bode.com.dtos.request.RegisterResidentRequest;
import org.bode.com.dtos.responses.RegisterResidentResponse;
import org.bode.com.dtos.responses.RegisteredLoginResidentResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ResidentServicesImplTest {
    @Autowired
    private ResidentRepository repo;
    @Autowired
    private ResidentServices service;

    private RegisterResidentRequest request;
    private RegisterResidentResponse response;
    private LoginResidentRequest loginRequest;
    private RegisteredLoginResidentResponse registeredLoginResponse;

    @BeforeEach
    public void setUp() {
       repo.deleteAll();
       request = new RegisterResidentRequest();
        request.setAddress("olabode address");
        request.setEmail("olabode@gmail.com");
        request.setFullName("Lawal olabode");
        request.setPhoneNumber("1234567890");
        request.setPassword("password");
         response = new RegisterResidentResponse();

         loginRequest = new LoginResidentRequest();
         loginRequest.setEmail("olabode@gmail.com");
         loginRequest.setPassword("password");

         registeredLoginResponse = new RegisteredLoginResidentResponse();


    }

    @Test
    public void testServiceCanRegister() {
        response =  service.register(request);
        assertEquals("Registered Successfully", response.getMessage());

    }

    @Test
    public void testServiceCanLogin() {
        response = service.register(request);
        assertEquals("Registered Successfully", response.getMessage());
        registeredLoginResponse = service.login(loginRequest);
        assertEquals("Login Successfully", registeredLoginResponse.getMessage());


    }
}
