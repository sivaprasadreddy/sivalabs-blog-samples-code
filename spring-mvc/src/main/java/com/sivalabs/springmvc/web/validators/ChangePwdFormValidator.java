package com.sivalabs.springmvc.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sivalabs.springmvc.web.forms.ChangePwdForm;


/**
 * @author K. Siva Prasad Reddy
 */
@Component
public class ChangePwdFormValidator  implements Validator
{

	@Override
	public boolean supports(Class<?> clazz)
	{
		return ChangePwdForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPwd", "currentPwd.required", "Cureent Pwd is Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPwd", "newPwd.required", "New Pwd is Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPwd", "confirmPwd.required", "Confirm Pwd is Empty");
		ChangePwdForm changePwdForm = (ChangePwdForm) obj;
		if(!changePwdForm.getNewPwd().equals(changePwdForm.getConfirmPwd())){
			errors.reject("changePwd", "Password and Confirm Password mismatch.");
		}
	}

}
