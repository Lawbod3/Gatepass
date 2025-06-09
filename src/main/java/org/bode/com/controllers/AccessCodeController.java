package org.bode.com.controllers;

import jakarta.validation.Valid;
import org.bode.com.dtos.request.FindAccessCodeRequest;
import org.bode.com.dtos.request.GenerateAccessCodeRequest;
import org.bode.com.dtos.responses.ApiResponse;
import org.bode.com.dtos.responses.FindAccessCodeResponse;
import org.bode.com.dtos.responses.GenerateAccessCodeResponse;
import org.bode.com.exceptions.AccessCodeDoesNotExistException;
import org.bode.com.exceptions.GatePassException;
import org.bode.com.exceptions.ResidentDoesNotExistException;
import org.bode.com.services.ResidentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/access-code")
public class AccessCodeController {
    @Autowired
    ResidentServices residentServices;

    @PostMapping("/generate-access-code")
    public ResponseEntity<?> generateAccessCode(@Valid @RequestBody GenerateAccessCodeRequest generateAccessCodeRequest) {
        try{
            GenerateAccessCodeResponse generateAccessCodeResponse = residentServices.generateAccessCode(generateAccessCodeRequest);
            return new ResponseEntity<>(new ApiResponse(true, generateAccessCodeResponse), HttpStatus.CREATED);
        }
        catch (ResidentDoesNotExistException | GatePassException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find-access-code")
    public ResponseEntity<?> findAccessCode(@RequestParam("token") String token) {
        try{
            FindAccessCodeRequest findAccessCodeRequest = new FindAccessCodeRequest();
            findAccessCodeRequest.setToken(token);

            FindAccessCodeResponse findAccessCodeResponse = residentServices.findAccessCode(findAccessCodeRequest);
            return new ResponseEntity<>(new ApiResponse(true, findAccessCodeResponse), HttpStatus.OK);
    }
        catch (AccessCodeDoesNotExistException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
