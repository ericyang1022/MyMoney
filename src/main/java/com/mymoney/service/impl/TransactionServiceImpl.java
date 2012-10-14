package com.mymoney.service.impl;

import org.hibernate.Session;

import com.mymoney.dao.TransactionDAO;
import com.mymoney.model.Transaction;
import com.mymoney.persistence.HibernateUtil;
import com.mymoney.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {

	private TransactionDAO transactionDAO = null;
	
	public TransactionDAO getTransactionDAO() {
		return transactionDAO;
	}

	public void setTransactionDAO(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;		
	}
	
	public void addTransaction(Transaction transaction) {
		try {
			//TODO must be a more elegant way to do this 
			//rather than have transaction code in every service method?
			//Look into Spring Transaction Management
			//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			transactionDAO.makePersistent(transaction);	
			
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
