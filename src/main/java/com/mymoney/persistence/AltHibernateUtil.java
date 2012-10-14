package com.mymoney.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/* Alternative HibernateUtil class that uses ThreadLocal
 * Taken from http://www.devarticles.com/c/a/Java/Managing-Transactions-with-Hibernate/
 */
public class AltHibernateUtil {

		public static final SessionFactory sessionFactory;

		    static {
		        try {
		            // Create the SessionFactory from hibernate.cfg.xml
		            sessionFactory = new Configuration().configure().buildSessionFactory();
		        } catch (Throwable ex) {
		            // Make sure you log the exception, as it might be swallowed
		            System.err.println("Initial SessionFactory creation failed." + ex);
		            throw new ExceptionInInitializerError(ex);
		        }
		    }
		 public static final ThreadLocal session = new ThreadLocal();

		 public static Session getSession() throws HibernateException {
		        Session s = (Session) session.get();
		        // Open a new Session, if this thread has none yet
		        if (s == null) {
		            s = sessionFactory.openSession();
		            // Store it in the ThreadLocal variable
		            session.set(s);
		        }
		        return s;
		    }

		    public static void closeSession() throws HibernateException {
		        Session s = (Session) session.get();
		        if (s != null)
		            s.close();
		        session.set(null);
		    }
		/**
		     * @return the hibernate session factory
		     */
		    public static SessionFactory getSessionFactory( ) {
		      return sessionFactory;
		    }

		/**
		     * This is a simple method to reduce the amount of
		code that needs
		     * to be written every time hibernate is used.
		     */
		    public static void rollback(org.hibernate.Transaction
		tx) {
		        if (tx != null) {
		            try {
		                tx.rollback( );
		            }
		            catch (HibernateException ex) {
		                // Probably don't need to do anything - this is likely being
		                // called because of another exception, and we don't want to
		                // mask it with yet another exception.
		            }
		        }
		    }
		/**
		     * This is a simple method to reduce the amount of
		code that needs
		     * to be written every time hibernate is used.
		     */
		    public static void commit(org.hibernate.Transaction tx) {
		        if (tx != null) {
		            try {
		                tx.commit( );
		            }
		            catch (HibernateException ex) {
		                // Probably don't need to do anything - this is likely being
		                // called because of another exception, and we don't want to
		                // mask it with yet another exception.
		            }
		        }
		    }

}
