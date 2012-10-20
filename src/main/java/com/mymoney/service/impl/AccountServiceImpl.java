package com.mymoney.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.mymoney.dao.AccountDAO;
import com.mymoney.model.Account;
import com.mymoney.persistence.HibernateUtil;
import com.mymoney.service.AccountService;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAO = null;
	
	public AccountServiceImpl() {
		//TODO hack! remove ASAP
		accountDAO = new com.mymoney.dao.hibernate.HibernateDAOFactory.AccountDAOHibernate();
	}
	
	public List<Account> getAccounts() {
		List<Account> accounts = null;

//        Session session = HibernateUtil.getSession();
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			//TODO must be a more elegant way to do this 
			//rather than have transaction code in every service method?
			//Look into Spring Transaction Management
			//Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			session.beginTransaction();
			
			boolean sessionOpen = session.isOpen();
			accounts = accountDAO.findAll();			
			
			// End the unit of work
			session.getTransaction().commit();             
			//session.close();

        } catch (Exception ex) {
            HibernateUtil.getSessionFactory()
                    .getCurrentSession().getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        
		return accounts;
	}
	
	//TODO hack! remove ASAP
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
		//accountDAO = new com.mymoney.dao.hibernate.HibernateDAOFactory.AccountDAOHibernate();
	}
	
	public void addAccount(Account account) {
		try {
			//TODO must be a more elegant way to do this 
			//rather than have transaction code in every service method?
			//Look into Spring Transaction Management
			//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			accountDAO.makePersistent(account);	
			
			// End the unit of work
			session.getTransaction().commit();             
			//session.close();

        } catch (Exception ex) {
            HibernateUtil.getSessionFactory()
                    .getCurrentSession().getTransaction().rollback();
            ex.printStackTrace();
        }
	}
	
}
