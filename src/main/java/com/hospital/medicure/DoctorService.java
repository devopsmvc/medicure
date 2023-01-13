package com.hospital.medicure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository DoctorRepository;
	
	
	public Doctor RegisterDoctor() {
		Doctor Doctor = generateDummyDoctor();
		return DoctorRepository.save(Doctor);
	}
	
	
	public Doctor generateDummyDoctor() {
		return new Doctor(12345, "Mahesh");
	}
	
	public Doctor UpdateDoctor(Doctor Doctor) {
		return DoctorRepository.save(Doctor);
	}

	public Doctor SearchDoctor(int DoctorRegNo) {
		return DoctorRepository.findById(DoctorRegNo).get();
	}
	
	public void  DeleteDoctor(int DoctorRegNo) {
		DoctorRepository.deleteById(DoctorRegNo);
	}

}
