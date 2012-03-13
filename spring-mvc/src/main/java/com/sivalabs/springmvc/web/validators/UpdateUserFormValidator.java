package com.sivalabs.springmvc.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sivalabs.springmvc.entities.User;


/**
 * @author K. Siva Prasad Reddy
 */
@Component
public class UpdateUserFormValidator  implements Validator
{

	@Override
	public boolean supports(Class<?> clazz)
	{
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required", "FirstName is Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required", "Email is Empty");
		
	}

}
