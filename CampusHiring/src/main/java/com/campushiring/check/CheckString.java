package com.campushiring.check;

import org.apache.commons.lang3.StringUtils;

/*
 * This class is used to check that String entered is null or not
 * */
public class CheckString {

	/*
	 * In this Method, printing message if String entered is int It is used to check
	 * parameters like Emp_Name should not be integer
	 */
	public static boolean isStringCorrect(String emp_name) {

		boolean right = StringUtils.isNumeric(emp_name);

		return right;
	}
}