package com.hospital.patient.controller;


import com.hospital.patient.entity.Patient;
import com.hospital.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Patient createUser(@RequestBody Patient patient){
        return patientService.createPatient(patient);
    }

    @PutMapping("patients/{id}")
    public String updatePatient(@PathVariable int id, @RequestBody Patient patient){
        return patientService.updatePatient(id,patient);
    }


}
