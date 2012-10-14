package com.mymoney;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.domainlanguage.money.Money;
import com.mymoney.model.Account;
import com.mymoney.persistence.HibernateUtil;

/**
 * A simple class for testing the creation , persistence and retrieval of Accounts.
 * It either creates and stores accounts in the database
 * or lists the accounts already in the database
 * 
 * See http://www.hibernate.org/hib_docs/reference/en/html/tutorial-firstapp.html#tutorial-firstapp-workingpersistence
 */
public class AccountManager {
	
	static Logger logger = Logger.getLogger(AccountManager.class);
	
	    public static void main(String[] args) {
	    	AccountManager mgr = new AccountManager();
	    	
	    	//com.mymoney.dao.hibernate.HibernateDAOFactory.AccountDAOHibernate a = new com.mymoney.dao.hibernate.HibernateDAOFactory.AccountDAOHibernate();

//	    	args[0] = "store";
//	    	args[0] = "list";
	    	
//	        if (args[0].equals("store")) {
	            mgr.createAndStoreEvent();
//	        } else if (args[0].equals("list")) {
	            List<Account> accounts = mgr.listAccounts();
	            for (int i = 0; i < accounts.size(); i++) {
	                Account account = accounts.get(i);
	                System.out.println("Account: " + account.toString());
	            }
//	        } else {
//	        	logger.warn("Incorrect param - must be 'store' or 'list'");
//	        }

	        HibernateUtil.getSessionFactory().close();
	    }

	    private void createAndStoreEvent() {

	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	        session.beginTransaction();

	        Account account = new Account();
	        account.setName("Name");
	        account.setShortName("ShortName");
	        account.setAccountNum("C1234");
	        account.setNotes("1st Account!");
	        Money openingBalance = Money.dollars(0.00);
	        account.setOpeningBalance(openingBalance);

	        session.save(account);

	        session.getTransaction().commit();
	    }
	    
	    @SuppressWarnings("unchecked")
	    private List<Account> listAccounts() {

	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	        session.beginTransaction();

	        List<Account> result = session.createQuery("from Account").list();

	        session.getTransaction().commit();

	        return result;
	    }

	}