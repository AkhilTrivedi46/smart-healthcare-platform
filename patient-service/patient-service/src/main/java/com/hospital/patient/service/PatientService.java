package com.hospital.patient.service;


import com.hospital.patient.model.Patient;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PatientService {

    public List<Patient> getAllPatients(){
        return Arrays.asList(
                new Patient(1, "Akhil", 24, "Male", "Chennai", "O+"),
                new Patient(3, "Bobby", 35, "Male", "Bangalore", "A+"),
                new Patient(4, "Swetha", 27, "Female", "Hyderabad", "AB+"),
                new Patient(5, "Shyam", 42, "Male", "Mumbai", "O-")
        );

    }
}
