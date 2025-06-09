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
import org.bode.com.exceptions.ValidationException;

import java.time.LocalDate;
import java.util.Optional;
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

    public static RegisteredLoginResidentResponse mapToRegisteredLoginResidentResponse(Resident resident) {
        RegisteredLoginResidentResponse registerResidentResponse = new RegisteredLoginResidentResponse();
                registerResidentResponse.setMessage("Login Successfully");
                registerResidentResponse.setEmail(resident.getEmail());
                registerResidentResponse.setAddress(resident.getAddress());
                registerResidentResponse.setPhoneNumber(resident.getPhoneNumber());
                registerResidentResponse.setId(String.valueOf(resident.getId()));
                registerResidentResponse.setFullName(resident.getFullName());

            return registerResidentResponse;

    }

    public static AccessCode mapToAccessCode( Resident resident) {
        AccessCode accessCode = new AccessCode();
        accessCode.setCreationDate(LocalDate.now());
        accessCode.setExpirationDate(LocalDate.now().plusDays(7));
        accessCode.setActive(true);
        accessCode.setResidentPhoneNumber(resident.getPhoneNumber());
        return accessCode;
    }

    public static void mapAccessCodeToResponse(AccessCode accessCode, FindAccessCodeResponse response) {
        response.setId(accessCode.getId());
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

    public static void mapToRequestException(GenerateAccessCodeRequest request) {
        if(request.getVisitorPhoneNumber().isEmpty()) throw new ValidationException("Visitor phone number is empty");
        if(request.getVisitorFullName().isEmpty()) throw new ValidationException("Visitor full name is empty");
    }










}
