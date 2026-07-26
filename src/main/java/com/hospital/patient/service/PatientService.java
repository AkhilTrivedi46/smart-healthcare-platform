package com.hospital.patient.service;

import com.hospital.patient.dto.PatientRequest;
import com.hospital.patient.dto.PatientResponse;
import com.hospital.patient.entity.Patient;
import com.hospital.patient.exception.PatientNotFoundException;
import com.hospital.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(int id) {
        return patientRepository.findById(id)
                .orElseThrow(() ->
                        new PatientNotFoundException(
                                "Patient not found with id: " + id));
    }

    public PatientResponse createPatient(PatientRequest patientRequest) {

        Patient patient = new Patient();

        patient.setId(patientRequest.getId());
        patient.setName(patientRequest.getName());
        patient.setAge(patientRequest.getAge());
        patient.setGender(patientRequest.getGender());
        patient.setCity(patientRequest.getCity());
        patient.setBloodGroup(patientRequest.getBloodGroup());

        Patient savedPatient = patientRepository.save(patient);

        PatientResponse response = new PatientResponse();

        response.setId(savedPatient.getId());
        response.setName(savedPatient.getName());
        response.setAge(savedPatient.getAge());
        response.setGender(savedPatient.getGender());
        response.setCity(savedPatient.getCity());
        response.setBloodGroup(savedPatient.getBloodGroup());

        return response;
    }

    public String updatePatient(int id, Patient patient) {

        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new PatientNotFoundException(
                                "Patient not found with id: " + id));

        existingPatient.setName(patient.getName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setGender(patient.getGender());
        existingPatient.setCity(patient.getCity());
        existingPatient.setBloodGroup(patient.getBloodGroup());

        patientRepository.save(existingPatient);

        return "Updated Successfully";
    }

    public String deletePatientById(int id) {

        patientRepository.findById(id)
                .orElseThrow(() ->
                        new PatientNotFoundException(
                                "Patient not found with id: " + id));

        patientRepository.deleteById(id);

        return "Patient deleted successfully";
    }

}