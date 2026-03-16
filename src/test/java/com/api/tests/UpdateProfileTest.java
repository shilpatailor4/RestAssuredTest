package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test
	public void getProfileInfoTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("shilpatailor", "12345678"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		
		System.out.println(".........................................");
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getPofile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
		Assert.assertEquals(userProfileResponse.getUsername(), "shilpatailor");
		
		System.out.println(".........................................");
		
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstName("shilpa")
				.lastName("tailor")
				.email("shilpatailorqa80@gmail.com")
				.mobileNumber("8787878878")
				.Build();
		
		response = userProfileManagementService.updatePofile(loginResponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());
		
	}

}
