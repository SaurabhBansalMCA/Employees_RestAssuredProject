/**
 * 
 */
package com.employee.utilities;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author Saurabh Bansal
 *
 */
public class RestUtils {
	
	public static String EmpName() {
		String generateString = RandomStringUtils.randomAlphabetic(2);
		return "Saurabh"+generateString;
	}
	
	public static String EmpAge() {
		String generateString = RandomStringUtils.randomNumeric(5);
		return generateString;
	}
	
	public static String EmpSalary() {
		String generateString = RandomStringUtils.randomNumeric(2);
		return generateString;
	}

}
