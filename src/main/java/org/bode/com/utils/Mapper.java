package org.bode.com.utils;


import org.bode.com.data.models.AccessCode;
import org.bode.com.data.models.Resident;
import org.bode.com.data.models.Visitor;
import org.bode.com.data.repositories.AccessCodeRepository;
import org.bode.com.data.repositories.ResidentRepository;
import org.bode.com.data.repositories.VisitorRepository;
import org.bode.com.dtos.request.GenerateAccessCodeRequest;
import org.bode.com.dtos.request.LoginResidentRequest;
import org.bode.com.dtos.request.RegisterResidentRequest;
import org.bode.com.dtos.responses.GenerateAccessCodeResponse;
import org.bode.com.dtos.responses.RegisterResidentResponse;
import org.bode.com.dtos.responses.RegisteredLoginResidentResponse;
import org.bode.com.exceptions.PasswordException;
import org.bode.com.exceptions.ResidentDoesNotExistException;

import java.util.Random;


public class Mapper {

    public static Resident mapToResident(RegisterResidentRequest request) {
        Resident resident = new Resident();
        resident.setEmail(request.getEmail());
        resident.setFullName(request.getFullName());
        resident.setPhoneNumber(request.getPhoneNumber());
        resident.setAddress(request.getAddress());
        resident.setPassword(request.getPassword());

        return resident;


    }

    public static RegisterResidentResponse mapToResponse(Resident resident) {
        RegisterResidentResponse registerResidentResponse = new RegisterResidentResponse();
        registerResidentResponse.setFullName(resident.getFullName());
        registerResidentResponse.setEmail(resident.getEmail());
        registerResidentResponse.setPhoneNumber(resident.getPhoneNumber());
        registerResidentResponse.setAddress(resident.getAddress());
        registerResidentResponse.setId(String.valueOf(resident.getId()));
        registerResidentResponse.setMessage("Registered Successfully");
        return registerResidentResponse;
    }

    public static RegisteredLoginResidentResponse mapToRegisteredLoginResidentResponse(LoginResidentRequest loginRequest, ResidentRepository residentRepository) {
        RegisteredLoginResidentResponse registerResidentResponse = new RegisteredLoginResidentResponse();
        if(residentRepository.existsByEmail(loginRequest.getEmail())) {
            Resident resident = residentRepository.findByEmail(loginRequest.getEmail());
            if(resident.getPassword().equals(loginRequest.getPassword())) registerResidentResponse.setMessage("Login Successfully");
            else throw new PasswordException("Wrong password");
        }
        else throw new ResidentDoesNotExistException("Email not found");
       return registerResidentResponse;
    }









}
