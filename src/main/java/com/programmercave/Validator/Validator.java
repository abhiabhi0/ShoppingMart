package com.programmercave.Validator;

import com.programmercave.Model.Customer;

public class Validator {
	/*
	 * This method takes an employee object as arguments and validates all
	 * attributes of it. If any attribute validation fails then
	 * InfyEmployeeException is thrown with corresponding message.
	 */
	public String validate(Customer employee) {
		String responseStatus = null;
		if (!isValidMembership(employee.getMembership()))
			responseStatus = "Validator.INVALID_MEMBERSHIP";
		else
			responseStatus = "Validator.SUCCESS";
			
		return responseStatus;
		}
	
	/*
	 * This method takes String object as argument. It validates the department
	 * attribute of employee. Entered department is should be one from ECE, CSE, IT
	 * or EEE. Department cannot be null. If any of the given condition fails then
	 * it return false else it will return true.
	 */
	private boolean isValidMembership(String membership) {
		if (membership != null && membership.matches("(Silver|Gold|Platinum)"))
			return true;
		return false;
	}
}
