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

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientResponse> createPatient(
            @Valid @RequestBody PatientRequest patientRequest) {

        PatientResponse response = patientService.createPatient(patientRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<String> updatePatient(
            @PathVariable int id,
            @Valid @RequestBody Patient patient) {

        return ResponseEntity.ok(patientService.updatePatient(id, patient));
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable int id){
        return ResponseEntity.ok(patientService.deletePatientById(id));
    }



}
