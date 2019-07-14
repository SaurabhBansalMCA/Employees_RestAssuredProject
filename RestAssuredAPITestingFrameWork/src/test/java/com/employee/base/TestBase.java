/**
 * 
 */
package com.employee.base;



import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeSuite;

import com.employee.constants.GlobalVariables;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * @author Saurabh Bansal
 *
 */
public class TestBase extends GlobalVariables{

	public String ResponseBody(Response res) {
		return res.getBody().asString();
	}
	
	public int StatusCode(Response res) {
		return res.getStatusCode();
	}
	
	public long ResponseTime(Response res) {
		return res.getTime();
	}
	
	public String ContentType(Response res) {
		return res.header("Content-Type");
	}
	
	public void HitAPI() {
		RestAssured.baseURI = GlobalVariables.URI;
	}
	
	@BeforeSuite
	public void LogSetUp() {
		APPLICATION_LOG = Logger.getLogger("devpinoyLogger");
		PropertyConfigurator.configure("log4j.properties");
		APPLICATION_LOG.setLevel(Level.ALL);
	}
	
	
}
