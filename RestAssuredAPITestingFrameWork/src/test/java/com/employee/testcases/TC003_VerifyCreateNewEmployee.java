/**
 * 
 */
package com.employee.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;
import com.employee.constants.GlobalVariables;
import com.employee.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

/**
 * @author Saurabh Bansal
 *
 */
public class TC003_VerifyCreateNewEmployee extends TestBase{

	String eName = RestUtils.EmpName();
	String eSalary = RestUtils.EmpSalary();
	String eAge = RestUtils.EmpAge();
	
	@BeforeClass
	void SetUp() {
		GlobalVariables.APPLICATION_LOG.info("*****Started TC003_VerifyCreateNewEmployee*****");
		HitAPI();
		httpRequest = RestAssured.given();
		
		JSONObject json = new JSONObject();
		json.put("name", eName);
		json.put("salary", eSalary);
		json.put("age", eAge);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(json.toJSONString());
		
		response = httpRequest.request(Method.POST,"/create"); 
	}
	
	@Test
	void ValidateStatusCode() {
		Assert.assertEquals(StatusCode(response), 200);
	}
	
	@Test
	void ValidateResponseBody() {
		Assert.assertTrue(ResponseBody(response).contains(eName));
		Assert.assertTrue(ResponseBody(response).contains(eSalary));
		Assert.assertTrue(ResponseBody(response).contains(eAge));
	}
	
	@AfterClass
	void TearDown() {
		GlobalVariables.APPLICATION_LOG.info("**** Ending TC003_VerifyCreateNewEmployee*****");
	}
}
