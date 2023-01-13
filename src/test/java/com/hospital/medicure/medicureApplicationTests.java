package com.hospital.medicure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SpringBootTest
class medicureApplicationTests {

	@Test
	void contextLoads() {
	}
	
//	@Test
//	void testRegisterDoctor() {
//		Doctor doctor = new Doctor(12345, "Mahesh");
//		DoctorService dService = new DoctorService();
//		assertEquals(doctor.getDoctorRegNo(), dService.generateDummyDoctor().getDoctorRegNo());
//	}
//	
//	@Test
//	void testCreateDoctor() {
//		RestAssured.baseURI="http://localhost:8082/RegisterDoctor";
//		RequestSpecification httpRequest = RestAssured.given();
//		Response response =httpRequest.request(Method.POST);
//		System.out.println(response.getStatusCode());
//		assertEquals(response.statusCode(), 200);
//				
//	}
//
//	@Test
//	void testGetDoctorDetails() {
//		RestAssured.baseURI="http://localhost:8082/SearchDoctor";
//		RequestSpecification httpRequest = RestAssured.given();
//		Response response =httpRequest.request(Method.GET,"/3");
//		System.out.println(response.getStatusCode());
//		assertEquals(response.statusCode(), 200);
//				
//	}
	
//	@Test
//	void testUpdateAccountDetails() {
//		RestAssured.baseURI="http://13.127.141.134:8090/UpdateAccount";
//		RequestSpecification httpRequest = RestAssured.given();
//		httpRequest.contentType(ContentType.JSON);
//	    httpRequest.body(new Account(33, "Vikul", "Savings"));
//		Response response =httpRequest.put("10");
//		System.out.println(response.getStatusCode());
//		assertEquals(response.statusCode(), 200);
//				
//	}
//
}
