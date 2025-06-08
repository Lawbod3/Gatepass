package org.bode.com.controllers;

import jakarta.validation.Valid;
import org.bode.com.dtos.request.LoginResidentRequest;
import org.bode.com.dtos.request.RegisterResidentRequest;
import org.bode.com.dtos.responses.ApiResponse;
import org.bode.com.dtos.responses.RegisterResidentResponse;
import org.bode.com.dtos.responses.RegisteredLoginResidentResponse;
import org.bode.com.exceptions.GatePassException;
import org.bode.com.services.ResidentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/resident")
public class ResidentController {
    @Autowired
    ResidentServices residentServices;

    @GetMapping("/test")
    public String testEndpoint() {
        return "API is working!";
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerResidentService(@Valid @RequestBody RegisterResidentRequest registerResidentRequest) {

        try{
            RegisterResidentResponse registerResidentResponse = residentServices.register(registerResidentRequest);
           return new ResponseEntity<>(new ApiResponse(true, registerResidentResponse), HttpStatus.CREATED);
        }catch (GatePassException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginResidentService(@Valid @RequestBody LoginResidentRequest loginResidentRequest) {
        try {
            RegisteredLoginResidentResponse registeredLoginResidentResponse = residentServices.login(loginResidentRequest);
            return new ResponseEntity<>(new ApiResponse(true, registeredLoginResidentResponse), HttpStatus.OK);
        }
        catch (GatePassException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


}
