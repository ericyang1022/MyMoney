package com.mymoney.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.domainlanguage.money.Money;
import com.mymoney.dao.AccountDAO;
import com.mymoney.editor.MoneyEditor;
import com.mymoney.model.Account;
import com.mymoney.model.Transaction;
import com.mymoney.service.TransactionService;

@Controller
@RequestMapping("/createTransaction.htm")
@SessionAttributes("transaction")
public class CreateTransactionController {

	private TransactionService transactionService;
	private AccountDAO accountDAO;

	@Autowired
	public CreateTransactionController(TransactionService transactionService, AccountDAO accountDAO) {
		this.transactionService = transactionService;
		this.accountDAO = accountDAO;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(@RequestParam("accountId") long accountId, Model model) {
		Account account = accountDAO.findById(accountId);
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		model.addAttribute(transaction);
		return "transactionForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute Transaction transaction) {
		Account account = transaction.getAccount();
		account.addTransaction(transaction);
		transactionService.addTransaction(transaction);
		return "redirect:transactionList.htm?accountId=" + account.getId();
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {		
		binder.registerCustomEditor(Money.class, new MoneyEditor());
	}
}
