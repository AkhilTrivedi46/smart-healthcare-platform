package com.hospital.patient.controller;

import jakarta.validation.Valid;
import com.hospital.patient.dto.PatientRequest;
import com.hospital.patient.dto.PatientResponse;
import com.hospital.patient.entity.Patient;
import com.hospital.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable  int id){
        return patientService.getPatientById(id);
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientResponse> createPatient(
            @Valid @RequestBody PatientRequest patientRequest) {

        PatientResponse response = patientService.createPatient(patientRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("patients/{id}")
    public String updatePatient(@PathVariable int id, @RequestBody Patient patient){
        return patientService.updatePatient(id,patient);
    }

    @DeleteMapping("/patients/{id}")
    public String deletePatient(@PathVariable int id){
        return patientService.deletePatientById(id);
    }



}
