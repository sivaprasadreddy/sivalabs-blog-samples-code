/**
 * 
 */
package com.sivalabs.springmvc.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sivalabs.springmvc.model.User;

/**
 * @author siva
 *
 */
@Component
public class UserFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "emailId", "emailId.required","Email Id is required");
		ValidationUtils.rejectIfEmpty(errors, "password", "password.required","Password is required");
		ValidationUtils.rejectIfEmpty(errors, "firstname", "firstname.required","FirstName is required");
	}

}
