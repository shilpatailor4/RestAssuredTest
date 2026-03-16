package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.models.request.LoginRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {  //wrapper for rest assured
	
	//1. base uri
	//2. creating the request
	//3. handling the response
	//4. http://64.227.160.186:8080/swagger-ui/index.html#/admin-controller
	//5. https://swift.techwithjatin.com/dashboard
	
	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	public BaseService() {
		requestSpecification = given().baseUri(BASE_URL);
	}
	
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer " + token);
	}
	
	protected Response postRequest(Object payload, String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endPoint);
	}
	
	protected Response putRequest(Object payload, String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endPoint);
	}
	
	protected Response getRequest(String endPoint) {
		return requestSpecification.get(endPoint);
	}
	
	protected Response posRequest(String baseUrl, Object payload, String endPoint) {
		return requestSpecification.baseUri(baseUrl).contentType(ContentType.JSON).body(payload).post(endPoint);
	}

}
