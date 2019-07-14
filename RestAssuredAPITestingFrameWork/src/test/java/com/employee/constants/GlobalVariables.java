package com.employee.constants;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GlobalVariables {
	
	public static String URI = "http://dummy.restapiexample.com/api/v1";
	public static RequestSpecification httpRequest;
	public static Response response;
	public static Logger APPLICATION_LOG;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	
	
	public static final String EMPLOYEE_ID = "12314";

}
