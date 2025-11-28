package com.health.patientwebapp;
import java.io.Serializable;

import jakarta.persistence.Id;

import java.util.*;
 
public class PatientResponse implements Serializable  {
    private static final long serialVersionUID = 1L;

    private List<Patient> lPatient;

      
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
     public List<Patient> getPatient() {
		return lPatient;
     }

	public void setPatient(List<Patient> lPatient) { this.lPatient = lPatient; }

    @Override
    public String toString() {
        return "PatientResponse{" +
            ", patient=" + lPatient +
            '}';
    }
}