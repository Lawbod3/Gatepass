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
import org.bode.com.dtos.responses.FindAccessCodeResponse;
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

            Resident resident = residentRepository.findByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new ResidentDoesNotExistException("Resident not found"));
            if(resident.getPassword().equals(loginRequest.getPassword())) registerResidentResponse.setMessage("Login Successfully");
            else throw new PasswordException("Wrong password");
            registerResidentResponse.setEmail(resident.getEmail());
            registerResidentResponse.setAddress(resident.getAddress());
            registerResidentResponse.setPhoneNumber(resident.getPhoneNumber());
            registerResidentResponse.setId(String.valueOf(resident.getId()));
            registerResidentResponse.setFullName(resident.getFullName());

       return registerResidentResponse;
    }

    public static AccessCode mapToAccessCode(GenerateAccessCodeRequest request, Resident resident, Visitor visitor) {
        AccessCode accessCode = new AccessCode();
        accessCode.setCreationDate(request.getIssuedDate());
        accessCode.setExpirationDate(request.getExpirationDate());
        accessCode.setVisitor(visitor);
        accessCode.setActive(true);
        accessCode.setResidentPhoneNumber(resident.getPhoneNumber());
        return accessCode;
    }

    public static void mapAccessCodeToResponse(AccessCode accessCode, FindAccessCodeResponse response) {
        response.setId(String.valueOf(accessCode.getId()));
        response.setActive(accessCode.isActive());
        response.setResidentPhoneNumber(accessCode.getResidentPhoneNumber());
        response.setVisitor(accessCode.getVisitor());
        response.setCreationDate(accessCode.getCreationDate());
        response.setExpirationDate(accessCode.getExpirationDate());
        response.setUsedDate(accessCode.getUsedDate());
        response.setToken(accessCode.getToken());
    }

    public static void mapAccessCodeToResponse(AccessCode accessCode, GenerateAccessCodeResponse response) {
        response.setId(String.valueOf(accessCode.getId()));
        response.setActive(accessCode.isActive());
        response.setResidentPhoneNumber(accessCode.getResidentPhoneNumber());
        response.setVisitor(accessCode.getVisitor());
        response.setCreationDate(accessCode.getCreationDate());
        response.setExpirationDate(accessCode.getExpirationDate());
        response.setUsedDate(accessCode.getUsedDate());
        response.setToken(accessCode.getToken());
    }











}
