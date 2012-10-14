package com.mymoney.dao;

import com.mymoney.model.Account;

public interface AccountDAO extends GenericDAO<Account, Long> {
	//impl currently in HibernateDAOFactory
}
