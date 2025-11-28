package com.health.patientwebapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientRequest {
    private String PID;
    private String firstName;
	private String lastName;
    private String dob;
    private String gender;
    private String phoneNo;
    private String address;
    private String suburb;
    private String state;
    private String postcode;

    
    /*
return "PatientRequest{" +
				"PID='" + PID + "', firstName='" + firstName + "',
                 lastName='"+ lastName +"', 
                 dob='" + dob +"', 
                 gender='" + gender + "', 
                 phoneNo='" + phoneNo +"', 
                 address='" + address +"',
                 suburb = '" + suburb +"', 
                 state='"+ state +"',
                  postcode='"+ postcode + "'}'';
	}
    */
	@Override
	public String toString() {

        /*return "PatientRequest{" +
            "PID='" + PID '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", dob='" + dob + + '\'' +
            ", gender='" + gender + '\'' +
            ", phoneNo='" + phoneNo + '\'' +
            ", address='" + address + '\'' +
            ", suburb='" + suburb + '\'' +
            ", state='" + state + '\'' +
            ", postcode='" + postcode + '\'' +
        '}'; */
        return String.format(
				"PatientRequest{PID=%s, firstName='%s', lastName='%s', dob='%s', gender='%s', phoneNo='%s', address='%s',suburb = '%s', state='%s', postcode='%s'}",
				PID, firstName, lastName, dob, gender, phoneNo, address, suburb, state, postcode);
	}

	

	public String getPID() {
		return PID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

    public String getDob() {
		return dob;
	}
    
    public String getGender() {
		return gender;
	}

    public String getPhoneNo() {
		return phoneNo;
	}

    public String getAddress() {
		return address;
	}

    public String getSuburb() {
		return suburb;
	}

     public String getState() {
		return state;
	}

     public String getPostCode() {
		return postcode;
     }

	public void setPID(String PID) { this.PID = PID; }
	public void setName(String firstName) { this.firstName = firstName; }
	public void setDob(String dob) { this.dob = dob; }
	public void setGender(String gender) { this.gender = gender; }
	public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
	public void setAddress(String address) { this.address = address; }
	public void setSuburb(String suburb) { this.suburb = suburb; }
	public void setState(String state) { this.state = state; }
	public void setPostCode(String postcode) { this.postcode = postcode; }
}