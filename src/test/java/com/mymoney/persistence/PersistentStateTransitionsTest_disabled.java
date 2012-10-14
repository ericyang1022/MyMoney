package com.mymoney.persistence;

import java.math.BigDecimal;
import java.util.Currency;

import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Hibernate;
import org.hibernate.StatelessSession;
import org.junit.Ignore;
import org.testng.annotations.Test;

import com.domainlanguage.money.Money;
import com.mymoney.dao.AccountDAO;
import com.mymoney.dao.DAOFactory;
import com.mymoney.model.Account;
import com.mymoney.persistence.HibernateUtil;

/**
 * Load and store various objects to see if they change state correctly.
 *
 * @author Shaun Abram
 * @originalAuthor Christian Bauer
 */
@Ignore
public class PersistentStateTransitionsTest_disabled extends HibernateIntegrationTest {

    DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);

    protected void prepareSettings() {
        dataSetLocation = "accountTestData.xml";
        beforeTestOperations.add(DatabaseOperation.CLEAN_INSERT);
    }

    @Ignore
    @Test(groups = "integration-hibernate")
    public void storeAndLoadItem() {

        // Start a unit of work
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

        // Prepare the DAOs
        AccountDAO accountDAO = daoFactory.getAccountDAO();

        // Prepare an account object
        Account account = new Account();
        account.setName("name");
        account.setShortName("shortname");
        account.setNotes("notes");
        account.setOpeningBalance(Money.dollars(1.00));
        
        //persist account object
        accountDAO.makePersistent(account);        

        // End the unit of work
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();

        // Direct SQL query for database state in auto-commit mode
        StatelessSession s = HibernateUtil.getSessionFactory().openStatelessSession();
        Object[] result = (Object[])
                s.createSQLQuery("select name, shortName, accountNum, notes, amount, currency from ACCOUNT where ACCOUNT_ID = :accountid")
                  .addScalar("name",  Hibernate.STRING)
                  .addScalar("shortName", Hibernate.STRING)
                  .addScalar("notes", Hibernate.STRING)
                  .addScalar("amount", Hibernate.BIG_DECIMAL)
                  .addScalar("currency", Hibernate.CURRENCY)
                  .setParameter("accountid", account.getId())
                  .uniqueResult();
        s.close();

        // Assert correctness of state
        assert result[0].getClass() == String.class;
        assert result[0].equals( account.getName() );
        assert result[1].equals( account.getShortName() );
        assert result[2].equals( account.getNotes() );
        assert result[3].getClass() == BigDecimal.class;
        assert result[4].getClass() == Currency.class;
        BigDecimal bd = (BigDecimal)result[3];
        Currency c = (Currency)result[4];
        Money money = new Money(bd,c);
        assert(money.equals(Money.dollars(1.00)));
        
        //assert(false);

    }

}
