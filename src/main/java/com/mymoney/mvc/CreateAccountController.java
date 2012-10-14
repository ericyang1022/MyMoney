package com.mymoney.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.mymoney.model.Account;
import com.mymoney.service.AccountService;
import com.mymoney.validation.AccountValidator;

@Controller
@RequestMapping("/createAccount.htm")
public class CreateAccountController {

	private AccountService accountService;
	//private AccountDAO accountDAO;

	@Autowired
	public CreateAccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		Account account = new Account();
		model.addAttribute(account);
		return "accountForm";
	}

//	@ModelAttribute maps a model attribute to the method parameter.
//	This is how the controller gets a reference to the object holding
//	the data entered in the form.
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute Account account, BindingResult result, SessionStatus status) {
		new AccountValidator().validate(account, result);
		if (result.hasErrors()) {
			return "accountForm";
		}
		else {
			accountService.addAccount(account);
			status.setComplete();
			return "redirect:accountList.htm";
		}
	}
	
}
