package com.health.patientwebapp;

import com.health.patientwebapp.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

 @Service
    public class PatientService {
        @Autowired
        private PatientRepository patientRepository;

        public Patient savePatient(PatientRequest patientReq) {
            Patient patient = new Patient(
                patientReq.getPID(),
                patientReq.getFirstName(),
                patientReq.getLastName(),
                null,
                patientReq.getGender(),
                patientReq.getPhoneNo(),
                patientReq.getAddress(),
                patientReq.getSuburb(),
                patientReq.getState(),
                patientReq.getPostCode() 
            );

            return patientRepository.save(patient);
        }

        public boolean deletePatient(Patient patient) {
            patientRepository.delete(patient);
            return true;
        }

        public List<Patient> getAllPatient() {
            List<Patient> pats = new ArrayList<Patient>();
            patientRepository.findAll().forEach(pat -> pats.add(pat));
            return pats;
 
        }
        public Patient getPatientById(String id){
            return patientRepository.findByPID(id);
        }

        public boolean updatePatient(String PID, PatientRequest pasienReq)
        {
            Patient patient = patientRepository.findByPID(PID);
            if(patient!=null)
            {
                patient.setAddress(pasienReq.getAddress());
                patient.setName(pasienReq.getFirstName());
                patient.setGender(pasienReq.getGender());
                patient.setPID(pasienReq.getPID());
                patient.setPostCode(pasienReq.getPostCode());
                patient.setSuburb(pasienReq.getSuburb());
                patient.setState(pasienReq.getState());
                patient = patientRepository.save(patient);
                return true;
            }
            return false;
        }
    }
