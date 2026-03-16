package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description = "Verify if Signup API is working..")
	
	public void createAccountTest() {
		
		SignUpRequest signUpRequest = new SignUpRequest.Builder()
				.userName("disha1234")
				.email("disha1@gmail.com")
				.firstName("Disha1")
				.lastName("tailor1")
				.mobileNumber("7777717777")
				.Build();
		
		
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(), "user registered successfully!");
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	

}
