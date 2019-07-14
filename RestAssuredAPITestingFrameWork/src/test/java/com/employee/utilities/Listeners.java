/**
 * 
 */
package com.employee.utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.employee.constants.GlobalVariables;

/**
 * @author Saurabh Bansal
 *
 */

public class Listeners extends TestListenerAdapter{
	
	public void onStart(ITestContext testContext) {
		GlobalVariables.htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\CustomReport.html");
		GlobalVariables.htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\ConfigFiles\\extent-config.xml"),true);
		GlobalVariables.extent = new ExtentReports();
		GlobalVariables.extent.attachReporter(GlobalVariables.htmlReporter);
		GlobalVariables.extent.setSystemInfo("USER", "Saurabh Bansal");
	}
	
	public void onTestSuccess(ITestResult result) {
		GlobalVariables.test = GlobalVariables.extent.createTest(result.getName());
		GlobalVariables.test.log(Status.PASS, "Test Case Passed : " + result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		GlobalVariables.test = GlobalVariables.extent.createTest(result.getName());
		GlobalVariables.test.log(Status.FAIL, "Test Case Passed : " + result.getName());
	}
	
	public void onFinish(ITestContext testContext) {
		GlobalVariables.extent.flush();
	}
}
