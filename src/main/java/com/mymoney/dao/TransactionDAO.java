package com.mymoney.dao;

import com.mymoney.model.Transaction;

public interface TransactionDAO extends GenericDAO<Transaction, Long> {
	//impl currently in HibernateDAOFactory
}
