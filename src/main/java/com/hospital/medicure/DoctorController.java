package com.hospital.medicure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
	
	@Autowired
	DoctorService DoctorService;
	
	@GetMapping("/helloworld")
	public String helloWorld() {  
		return "Hello World"; 
	}
	 
	@GetMapping("/sayhi")
	public String sayhi() {
		return "Hi from Spring Boot";
	}
	
	
	@PostMapping("/RegisterDoctor")
	public Doctor CreateRegisterDoctor() {
		
		return DoctorService.RegisterDoctor();
	}
	
	@PutMapping("/UpdateDoctor")
	public Doctor UpdateDoctor(@RequestBody Doctor Doctor) {
		
		return DoctorService.UpdateDoctor(Doctor);
	}

	
	@GetMapping("/SearchDoctor/{DoctorRegNo}")
	public Doctor SearchDoctorDetails(@PathVariable(value="DoctorRegNo") int DoctorRegNo) {
		return DoctorService.SearchDoctor(DoctorRegNo);
	}
	
	@DeleteMapping("/DeleteAccount/{AccountID}")
	public void DeleteAccountDetails(@PathVariable(value="DoctorRegNo") int DoctorRegNo) {
		DoctorService.DeleteDoctor(DoctorRegNo);
	}


}
