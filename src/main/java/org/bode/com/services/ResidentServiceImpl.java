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
import org.bode.com.exceptions.*;
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
        GenerateAccessCodeResponse response = new GenerateAccessCodeResponse();
        Resident resident = residentRepository.findByEmail(request.getResidentEmail())
                .orElseThrow(() -> new ResidentDoesNotExistException("Resident does not exist"));
        
        Visitor visitor = new Visitor();
        visitor.setPhoneNumber(request.getVisitorPhoneNumber());
        visitor.setFullName(request.getVisitorFullName());
        if(!visitorRepository.existsByPhoneNumber(visitor.getPhoneNumber())) visitorRepository.save(visitor);
        else visitor = visitorRepository.findByPhoneNumber(visitor.getId()).
                orElseThrow(() -> new VisitorDoesNotExistException("Visitor does not exist"));
        
        AccessCode accessCode = Mapper.mapToAccessCode(request, resident, visitor);
        accessCode.setToken(generateToken());
        accessCodeRepository.save(accessCode);
        response.setMessage("AccessCode generated successfully");
        Mapper.mapAccessCodeToResponse(accessCode, response);

        return response;
    }

    private String generateToken() {
        String otp = "";
        for (int count = 0; count < 5; count++) {
            char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
            Random rand = new Random();
            int randomNumber = rand.nextInt(10);
            otp += chars[randomNumber];

        }
        return otp;
    }

    @Override
    public FindAccessCodeResponse findAccessCode(FindAccessCodeRequest request) {
        FindAccessCodeResponse response = new FindAccessCodeResponse();
        response.setMessage("AccessCode not found");
        if(accessCodeRepository.existsByToken(request.getToken())){
            AccessCode accessCode = accessCodeRepository.findAccessCodeByToken(request.getToken());
            response.setMessage("Access code found");
            Mapper.mapAccessCodeToResponse(accessCode, response);
        }
        else throw new AccessCodeDoesNotExistException("AccessCode does not exist");
        return response;
    }

}
