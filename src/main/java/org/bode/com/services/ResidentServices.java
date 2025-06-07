package org.bode.com.services;

import org.bode.com.data.models.AccessCode;
import org.bode.com.dtos.request.FindAccessCodeRequest;
import org.bode.com.dtos.request.GenerateAccessCodeRequest;
import org.bode.com.dtos.request.LoginResidentRequest;
import org.bode.com.dtos.request.RegisterResidentRequest;
import org.bode.com.dtos.responses.*;
import org.springframework.stereotype.Service;

@Service
public interface ResidentServices {
    RegisterResidentResponse register(RegisterResidentRequest request);
    RegisteredLoginResidentResponse login(LoginResidentRequest loginRequest);
    GenerateAccessCodeResponse generateAccessCode(GenerateAccessCodeRequest request);
    FindAccessCodeResponse findAccessCode(FindAccessCodeRequest request);
}
