package com.mymoney.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mymoney.dao.AccountDAO;
import com.mymoney.model.Account;

/**
 * JavaBean Form controller that is used to edit an existing <code>Account</code>.
 *
 * @author Shaun Abram
 */
@Controller
@RequestMapping("/editAccount.htm")
@SessionAttributes(types = Account.class)
public class EditAccountForm {

	private final AccountDAO accountDAO;

	@Autowired
	public EditAccountForm(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(@RequestParam("accountId") long accountId, Model model) {
		Account account = this.accountDAO.findById(accountId, false);
		model.addAttribute(account);
		return "accountForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute Account account, SessionStatus status) {
        accountDAO.makePersistent(account);
        status.setComplete();
        return "redirect:accountList.htm";
	}

}
