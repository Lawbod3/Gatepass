package org.bode.com.services;

import org.bode.com.data.models.AccessCode;
import org.bode.com.data.models.Resident;
import org.bode.com.data.models.Visitor;
import org.bode.com.data.repositories.AccessCodeRepository;
import org.bode.com.data.repositories.ResidentRepository;
import org.bode.com.data.repositories.VisitorRepository;
import org.bode.com.dtos.request.FindAccessCodeRequest;
import org.bode.com.dtos.request.GenerateAccessCodeRequest;
import org.bode.com.dtos.request.LoginResidentRequest;
import org.bode.com.dtos.request.RegisterResidentRequest;
import org.bode.com.dtos.responses.*;
import org.bode.com.exceptions.ResidentDoesNotExistException;
import org.bode.com.exceptions.ResidentExistException;
import org.bode.com.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ResidentServiceImpl implements ResidentServices{
    @Autowired
    private ResidentRepository residentRepository;

    @Autowired
    private AccessCodeRepository accessCodeRepository;

    @Autowired
    private VisitorRepository visitorRepository;


    @Override
    public RegisterResidentResponse register(RegisterResidentRequest request) {
        if (residentRepository.existsByEmail(request.getEmail())) throw new ResidentExistException("Resident already exist");
        Resident resident = Mapper.mapToResident(request);
        residentRepository.save(resident);
        return  Mapper.mapToResponse(resident);
    }

    @Override
    public RegisteredLoginResidentResponse login(LoginResidentRequest loginRequest) {
        return Mapper.mapToRegisteredLoginResidentResponse(loginRequest, residentRepository);
    }

    @Override
    public GenerateAccessCodeResponse generateAccessCode(GenerateAccessCodeRequest request) {
        return null;
    }

    @Override
    public FindAccessCodeResponse findAccessCode(FindAccessCodeRequest request) {
        return null;
    }

}
