package com.mymoney.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.domainlanguage.money.Money;
import com.mymoney.model.Account;

public class AccountValidator implements Validator {
	private final String defaultMessage = "Required Field";
	/**
	 * This Validator validates just Person instances
	 */
	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return Account.class.equals(clazz);
	}

	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "name", "name.empty", defaultMessage);
//		Account account = (Account) obj;
//		Money openingBalance = account.getOpeningBalance();
//		if (account.getAge() < 0) {
//			e.rejectValue("age", "negativevalue");
//		} else if (account.getAge() > 110) {
//			e.rejectValue("age", "too.darn.old");
//		}
	}
}