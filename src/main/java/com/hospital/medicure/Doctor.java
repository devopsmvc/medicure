package com.hospital.medicure;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int DoctorRegNo;	
	private String DoctorName;
	
	
	//Private //public //protected //default
	
	public Doctor() {
		
	}
	
	public Doctor(int DoctorRegNo, String DoctorName) {
		
		this.DoctorRegNo=DoctorRegNo;
		this.DoctorName=DoctorName;
	
	}

	public int getDoctorRegNo() {
		return DoctorRegNo;
	}

	public void setDoctorRegNo(int doctorRegNo) {
		DoctorRegNo = doctorRegNo;
	}

	public String getDoctorName() {
		return DoctorName;
	}

	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}
		
}
