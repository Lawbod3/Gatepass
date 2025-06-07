package org.bode.com.services;

import org.bode.com.data.repositories.ResidentRepository;
import org.bode.com.dtos.request.GenerateAccessCodeRequest;
import org.bode.com.dtos.request.LoginResidentRequest;
import org.bode.com.dtos.request.RegisterResidentRequest;
import org.bode.com.dtos.responses.GenerateAccessCodeResponse;
import org.bode.com.dtos.responses.RegisterResidentResponse;
import org.bode.com.dtos.responses.RegisteredLoginResidentResponse;
import org.bode.com.exceptions.PasswordException;
import org.bode.com.exceptions.ResidentDoesNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class
ResidentServicesImplTest {
    @Autowired
    private ResidentRepository repo;
    @Autowired
    private ResidentServices service;

    private RegisterResidentRequest request;
    private RegisterResidentResponse response;
    private LoginResidentRequest loginRequest;
    private LoginResidentRequest wrongRequest;
    private LoginResidentRequest loginWrongPassword;
    private RegisteredLoginResidentResponse registeredLoginResponse;
    private GenerateAccessCodeRequest generateAccessCodeRequest;
    private GenerateAccessCodeResponse generateAccessCodeResponse;

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

         wrongRequest = new LoginResidentRequest();
         wrongRequest.setEmail("bode@gmail.com");
         wrongRequest.setPassword("password");

         loginWrongPassword = new LoginResidentRequest();
         loginWrongPassword.setEmail("olabode@gmail.com");
         loginWrongPassword.setPassword("wrongPassword");

         registeredLoginResponse = new RegisteredLoginResidentResponse();

         generateAccessCodeRequest = new GenerateAccessCodeRequest();
         generateAccessCodeRequest.setResidentEmail("olabode@gmail.com");
         generateAccessCodeRequest.setVisitorFullName("Aloba Humble");
         generateAccessCodeRequest.setVisitorPhoneNumber("2222222222");



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

    @Test
    public void testServiceCanThrowExceptionForLoginEmail() {
        response = service.register(request);
        assertEquals("Registered Successfully", response.getMessage());
       assertThrows(ResidentDoesNotExistException.class, () -> service.login(wrongRequest));
    }

    @Test
    public void testServiceCanThrowExceptionForLoginPassword() {
        response = service.register(request);
        assertEquals("Registered Successfully", response.getMessage());
        assertThrows(PasswordException.class, () -> service.login(loginWrongPassword));
    }

    @Test
    public void testServiceCanGenerateAccessCode() {
        response = service.register(request);
        assertEquals("Registered Successfully", response.getMessage());
        assertTrue(repo.existsByEmail(request.getEmail()));
        generateAccessCodeResponse = service.generateAccessCode(generateAccessCodeRequest);
        assertEquals("AccessCode generated successfully", generateAccessCodeResponse.getMessage());

    }


}
