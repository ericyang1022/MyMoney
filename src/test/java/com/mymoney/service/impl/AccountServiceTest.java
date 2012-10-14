package com.mymoney.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.integration.junit3.MockObjectTestCase;

import com.mymoney.dao.AccountDAO;
import com.mymoney.model.Account;
import com.mymoney.service.AccountService;

public class AccountServiceTest extends MockObjectTestCase {

		private AccountDAO accountDAO;
		private AccountService service;
		List<Account> accounts = new ArrayList<Account>();
		//accounts.

		@Override
		protected void setUp() throws Exception {
			super.setUp();
			accountDAO = mock(AccountDAO.class);
			service = new AccountServiceImpl();
			
			//bad hack until I can figure out Spring injection better!
			AccountServiceImpl asi = (AccountServiceImpl)service;
			asi.setAccountDAO(accountDAO);
		}

		public void testGetAccounts() {

			checking(new Expectations() {
				{
					one(accountDAO).findAll();
					will(returnValue(accounts));										
				}
			});

			List<Account> accounts = service.getAccounts();	
			
			assert(accounts != null);
			
		}
		
		public void testGetAccounts_MultipleInvocations() {

			checking(new Expectations() {
				{
					one(accountDAO).findAll();
					will(returnValue(accounts));
					
					one(accountDAO).findAll();
					will(returnValue(accounts));
				}
			});

			List<Account> accounts = service.getAccounts();				
			assert(accounts != null);
			
			accounts = service.getAccounts();				
			assert(accounts != null);
		}
		
		

}
