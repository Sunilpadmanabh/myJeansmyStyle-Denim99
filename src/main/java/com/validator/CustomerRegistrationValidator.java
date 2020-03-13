package com.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.model.Customer;


public class CustomerRegistrationValidator implements Validator {

	//which objects can be validated by this validator

	public boolean supports(Class<?> paramClass) {
		return Customer.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		
		Customer emp = (Customer) obj;
		if(emp.getFirstName().isEmpty()){
			errors.rejectValue("firstName", "empty", new Object[]{"'firstname'"}, "firstname can't be empty");
		}
		if(emp.getFirstName().matches("\\`|\\~|\\!|\\@|\\#|\\$|\\%|\\^|\\&|\\*|\\(|\\)|\\+|\\=|\\[|\\{|\\]|\\}|\\||\\\\|\\'|\\<|\\,|\\.|\\>|\\?|\\/|\\\"\"|\\;|\\:|\\s")){
			errors.rejectValue("firstName", "special character", new Object[]{"'firstname'"}, "firstname can't use special character");
		}
		
		
		if(!emp.getUsers().getEmailId().matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$"))
		{
			errors.rejectValue("users.emailId", "emailinvalid");
		}
		if(emp.getUsers().getPassword().isEmpty()||emp.getUsers().getPassword().length()<5)
		{
			errors.rejectValue("users.password", "emptyPassword");
		}
		
		
		
		
		/*if (!emp.getCustomerPhone().matches("^((\\+){0,1}91(\\s){0,1}(\\-){0,1}(\\s){0,1}){0,1}98(\\s){0,1}(\\-){0,1}(\\s){0,1}[1-9]{1}[0-9]{7}$")) {
			errors.rejectValue("customerPhone", "special character", new Object[] { "'customerPhone'" },
					"customerPhone can't use alphabets character");
		}*/
	}

}
