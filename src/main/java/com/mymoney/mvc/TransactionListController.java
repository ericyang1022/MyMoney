package com.mymoney.mvc;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.domainlanguage.money.Money;
import com.mymoney.dao.AccountDAO;
import com.mymoney.editor.MoneyEditor;
import com.mymoney.model.Account;
import com.mymoney.model.Transaction;

@Controller
@RequestMapping("/transactionList.htm")
public class TransactionListController {

	private AccountDAO accountDAO;
	
	@Autowired
	public TransactionListController(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(@RequestParam("accountId") long accountId)  {
		Account account = accountDAO.findById(accountId);
		//Set<Transaction> transactions = account.getTransactions();
		
		String viewName = "transactionList";
		String modelName = "account";
		return new ModelAndView(viewName, modelName, account);	
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {		
		binder.registerCustomEditor(Money.class, new MoneyEditor());
	}

	
}
