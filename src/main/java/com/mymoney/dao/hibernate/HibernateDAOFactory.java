package com.mymoney.dao.hibernate;

import com.mymoney.dao.AccountDAO;
import com.mymoney.dao.DAOFactory;
import com.mymoney.dao.TransactionDAO;
import com.mymoney.model.Account;
import com.mymoney.model.Transaction;

/**
 * Returns Hibernate-specific instances of DAOs.
 * <p/>
 * If for a particular DAO there is no additional non-CRUD functionality, we use
 * a nested static class to implement the interface in a generic way. This allows clean
 * refactoring later on, should the interface implement business data access
 * methods at some later time. Then, we would externalize the implementation into
 * its own first-level class.
 *
 * @author Christian Bauer
 */
public class HibernateDAOFactory extends DAOFactory {

    //private static Log log = LogFactory.getLog(HibernateDAOFactory.class);

    public AccountDAO getAccountDAO() {
        return (AccountDAO)instantiateDAO(AccountDAOHibernate.class);
    }
    public TransactionDAO getTransactionDAO() {
        return (TransactionDAO)instantiateDAO(TransactionDAOHibernate.class);
    }

    

    private GenericHibernateDAO instantiateDAO(Class daoClass) {
        try {
            //log.debug("Instantiating DAO: " + daoClass);
            return (GenericHibernateDAO)daoClass.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
        }
    }

    // Inline concrete DAO implementations with no business-related data access methods.
    // If we use public static nested classes, we can centralize all of them in one source file.

    public static class AccountDAOHibernate
    	extends GenericHibernateDAO<Account, Long>
    	implements AccountDAO {}
    
    public static class TransactionDAOHibernate
	extends GenericHibernateDAO<Transaction, Long>
	implements TransactionDAO {}
    


}
