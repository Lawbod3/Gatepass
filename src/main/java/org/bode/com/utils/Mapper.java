package org.bode.com.utils;


import org.bode.com.data.models.Resident;
import org.bode.com.data.repositories.ResidentRepository;
import org.bode.com.dtos.request.RegisterResidentRequest;
import org.bode.com.dtos.responses.RegisterResidentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Mapper {


    public static Resident map(RegisterResidentRequest request) {
        Resident resident = new Resident();
        resident.setEmail(request.getEmail());
        resident.setFullName(request.getFullName());
        resident.setPhoneNumber(request.getPhoneNumber());
        resident.setAddress(request.getAddress());

        return resident;


    }

    public static RegisterResidentResponse map(Resident resident) {
        RegisterResidentResponse registerResidentResponse = new RegisterResidentResponse();
        registerResidentResponse.setFullName(resident.getFullName());
        registerResidentResponse.setEmail(resident.getEmail());
        registerResidentResponse.setPhoneNumber(resident.getPhoneNumber());
        registerResidentResponse.setAddress(resident.getAddress());
        registerResidentResponse.setMessage("Registered Successfully");
        return registerResidentResponse;

    }
}
