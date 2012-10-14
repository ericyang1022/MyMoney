package com.mymoney.dao;

import com.mymoney.dao.hibernate.HibernateDAOFactory;


/**
 * Defines all DAOs and the concrete factories to get the conrecte DAOs.
 * <p>
 * To get a concrete DAOFactory, call <tt>instance()</tt> with one of the
 * classes that extend this factory.
 * <p>
 * Implementation: If you write a new DAO, this class has to know about it.
 * If you add a new persistence mechanism, add an additional concrete factory
 * for it as a constant, like <tt>HIBERNATE</tt>.
 *
 * @author Christian Bauer
 */
public abstract class DAOFactory {

//    private static Log log = LogFactory.getLog(DAOFactory.class);

    /**
     * Creates a standalone DAOFactory that returns unmanaged DAO
     * beans for use in any environment Hibernate has been configured
     * for. Uses HibernateUtil/SessionFactory and Hibernate context
     * propagation (CurrentSessionContext), thread-bound or transaction-bound,
     * and transaction scoped.
     */
	public static final Class<HibernateDAOFactory> HIBERNATE = com.mymoney.dao.hibernate.HibernateDAOFactory.class;

    /**
     * Factory method for instantiation of concrete factories.
     */
    public static DAOFactory instance(Class<?> factory) {
        try {
//            log.debug("Creating concrete DAO factory: " + factory);
            return (DAOFactory)factory.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Couldn't create DAOFactory: " + factory);
        }
    }

    // Add your DAO interfaces here
    public abstract AccountDAO getAccountDAO();
    public abstract TransactionDAO getTransactionDAO();

}
