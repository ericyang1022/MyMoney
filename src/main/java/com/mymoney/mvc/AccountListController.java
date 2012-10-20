package com.mymoney.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.domainlanguage.money.Money;
import com.mymoney.editor.MoneyEditor;
import com.mymoney.model.Account;
import com.mymoney.service.AccountService;

@Controller
@RequestMapping("/accountList.htm")
public class AccountListController {

	private AccountService accountService;
	
	@Autowired
	public AccountListController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal()  {
		List<Account> accounts = accountService.getAccounts(); //should take user Id at some point!
		String viewName = "accountList";
		String modelName = "accounts";
		return new ModelAndView(viewName, modelName, accounts);	
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {		
		binder.registerCustomEditor(Money.class, new MoneyEditor());
	}

	
}
