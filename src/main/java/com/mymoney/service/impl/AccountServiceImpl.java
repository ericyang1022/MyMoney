package com.mymoney.service.impl;

import java.util.List;

import org.hibernate.Session;

import com.mymoney.dao.AccountDAO;
import com.mymoney.model.Account;
import com.mymoney.persistence.HibernateUtil;
import com.mymoney.service.AccountService;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAO = null;
	
	public AccountServiceImpl() {
		//TODO tmp workaround - change to use dependency injection
		accountDAO = new com.mymoney.dao.hibernate.HibernateDAOFactory.AccountDAOHibernate();
	}
	
	public List<Account> getAccounts() {
		List<Account> accounts = null;

        //TODO must be a more elegant way to do this
        //rather than have transaction code in every service method?
        //Look into Spring Transaction Management
        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			accounts = accountDAO.findAll();
			session.getTransaction().commit();
        } catch (Exception ex) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        
		return accounts;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	public void addAccount(Account account) {
        //TODO must be a more elegant way to do this
        //rather than have transaction code in every service method?
        //e.g. Look into Spring Transaction Management
        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			accountDAO.makePersistent(account);
			session.getTransaction().commit();
        } catch (Exception ex) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
	}
	
}
