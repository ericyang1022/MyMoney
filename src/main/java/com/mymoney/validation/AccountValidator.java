package com.mymoney.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mymoney.model.Account;

public class AccountValidator implements Validator {
	private final String defaultMessage = "Required Field";

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return Account.class.equals(clazz);
	}

	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "name", "name.empty", defaultMessage);
	}
}
