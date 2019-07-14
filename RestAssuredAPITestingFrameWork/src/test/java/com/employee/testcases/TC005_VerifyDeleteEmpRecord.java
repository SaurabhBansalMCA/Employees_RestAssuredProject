/**
 * 
 */
package com.employee.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;
import com.employee.constants.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.http.Method;

/**
 * @author Saurabh Bansal
 *
 */
public class TC005_VerifyDeleteEmpRecord extends TestBase{
	
	@BeforeClass
	void SetUp() {
		GlobalVariables.APPLICATION_LOG.info("*****Started TC005_VerifyDeleteEmpRecord*****");
		HitAPI();
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");
		
		String empID = response.jsonPath().get("[0].id");
		response = httpRequest.request(Method.DELETE,"/delete/"+empID);
	}
	
	@Test
	void ValidateStatusCode() {
		Assert.assertEquals(StatusCode(response),200);
	}
	
	@Test
	void ValidateResponseBody() {
		Assert.assertEquals(ResponseBody(response).contains("successfully! deleted Records"), true);
	}
		
	@Test
	void ValidateContentType() {
		Assert.assertEquals(ContentType(response), "text/html; charset=UTF-8");
	}
	
	@AfterClass
	void TearDown() {
		GlobalVariables.APPLICATION_LOG.info("*****Ending TC002_VerifySingleEmployeeData*****");
	}

}
