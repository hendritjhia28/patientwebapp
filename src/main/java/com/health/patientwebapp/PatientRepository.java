package com.health.patientwebapp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {
	List<Patient> findByLastName(String lastName);

	List<Patient> findByFirstName(String firstName);

	Patient findByPID(String PID);

	void deletePatientByPID(String PID);
}
