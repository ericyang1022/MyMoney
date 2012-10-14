package com.mymoney.service;

import java.util.List;

import com.mymoney.model.Account;

public interface AccountService {
	
	public List<Account> getAccounts();
	public void addAccount(Account account);
	
}
