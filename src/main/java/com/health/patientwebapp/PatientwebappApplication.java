package com.health.patientwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@SpringBootApplication
@RestController
@RequestMapping(path = "/api")
public class PatientwebappApplication {
	@Autowired
    private PatientService patientService;

	public static void main(String[] args) {
		SpringApplication.run(PatientwebappApplication.class, args);
	}

	@GetMapping("/check")
    public String hello(@RequestParam(value = "name", defaultValue = "OK") String name) {
      return String.format("200 %s!", name);
    }

	@PostMapping("/create")
 	public ResponseEntity<Patient> create(@RequestBody PatientRequest patientReq) {
        Patient savedPatient = patientService.savePatient(patientReq);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
	}
	@GetMapping("/patiens")
	public List<Patient> getAll(@RequestParam(value = "name", defaultValue = "World") String name) {
      return patientService.getAllPatient();
    }
	
	@DeleteMapping("/patien/{PID}")
   	public ResponseEntity<HttpStatus> deletePatient(@PathVariable("PID") String PID) {
		Patient patient = patientService.getPatientById(PID);
		Boolean b = false;
		if(patient != null){
			b = patientService.deletePatient(patient);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/patien/{PID}")
 	public ResponseEntity<Patient> updatePatient(@PathVariable("PID") String PID, @RequestBody PatientRequest patientReq) {
		Boolean a = patientService.updatePatient(PID, patientReq);
        return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
