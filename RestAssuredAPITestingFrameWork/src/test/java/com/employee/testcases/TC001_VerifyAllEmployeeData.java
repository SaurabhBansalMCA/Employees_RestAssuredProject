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
public class TC001_VerifyAllEmployeeData extends TestBase{
	
	
	@BeforeClass
	void SetUp() {
		APPLICATION_LOG.info("*****Started TC001_VerifyAllEmployeeData*****");
		HitAPI();
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees"); 
	}

	@Test
	void ValidateResponseBody() {
		APPLICATION_LOG.info("*****Checking Resppnse Body*****");
		Assert.assertTrue(ResponseBody(response)!=null);
	}
	
	@Test 
	void ValidateStatusCode(){
		GlobalVariables.APPLICATION_LOG.info("*****Checking Status code*****");
		GlobalVariables.APPLICATION_LOG.info("Status Code is : " + StatusCode(response));
		Assert.assertEquals(StatusCode(response), 200);
	}
	
	@Test
	void ValidateresponseTime() {
		GlobalVariables.APPLICATION_LOG.info("****Checking response time*****");
		Assert.assertTrue(ResponseTime(response)<10000);
	}
	
	@AfterClass
	void TearDown() {
		GlobalVariables.APPLICATION_LOG.info("**** Ending TC001_VerifyAllEmployeeData*****");
	}
}
