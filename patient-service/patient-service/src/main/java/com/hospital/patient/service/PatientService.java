package com.hospital.patient.service;


import com.hospital.patient.entity.Patient;
import com.hospital.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();

    }

    public Patient getPatientById(int id){
        return patientRepository.findById(id).orElse(null);
    }

    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public String updatePatient(int id, Patient patient){
        Patient existingPatient = patientRepository.findById(id).orElse(null);

        if(existingPatient != null){
            existingPatient.setName(patient.getName());
            existingPatient.setAge(patient.getAge());
            existingPatient.setGender(patient.getGender());
            existingPatient.setCity(patient.getCity());
            existingPatient.setBloodGroup(patient.getBloodGroup());

            patientRepository.save(existingPatient);

            return "Updated Successfully";

        }
        else{
            return "Patient not found";
        }
    }

    public String deletePatientById(int id){
        Patient delExistingPatient = patientRepository.findById(id).orElse(null);

        if(delExistingPatient != null){
            patientRepository.deleteById(id);
            return "This patient is no longer available , Deleted from the records";
        }
        else{
            return "Id not found";
        }
    }
}
