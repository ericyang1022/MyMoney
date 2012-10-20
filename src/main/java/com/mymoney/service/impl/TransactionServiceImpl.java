package com.mymoney.service.impl;

import org.hibernate.Session;

import com.mymoney.dao.TransactionDAO;
import com.mymoney.model.Transaction;
import com.mymoney.persistence.HibernateUtil;
import com.mymoney.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {

	private TransactionDAO transactionDAO = null;

	public void setTransactionDAO(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;		
	}
	
	public void addTransaction(Transaction transaction) {
        //TODO must be a more elegant way to do this
        //rather than have transaction code in every service method?
        //e.g. Look into Spring Transaction Management
        //Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
			session.beginTransaction();
			transactionDAO.makePersistent(transaction);
			session.getTransaction().commit();
        } catch (Exception ex) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
	}
}
