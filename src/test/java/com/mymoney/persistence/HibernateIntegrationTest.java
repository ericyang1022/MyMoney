package com.mymoney.persistence;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.datatype.DataType;
import org.dbunit.dataset.datatype.DataTypeException;
import org.dbunit.dataset.datatype.DefaultDataTypeFactory;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.impl.SessionFactoryImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.mymoney.persistence.HibernateUtil;

public abstract class HibernateIntegrationTest {

    protected String dataSetLocation;
    protected List<DatabaseOperation> beforeTestOperations
            = new ArrayList<DatabaseOperation>();
    protected List<DatabaseOperation> afterTestOperations
            = new ArrayList<DatabaseOperation>();

    private ReplacementDataSet dataSet;

    @BeforeClass(groups = "integration-hibernate")
    public void prepareDataSet() throws Exception {

        // Check if subclass has prepared everything
        prepareSettings();
        if (dataSetLocation == null)
            throw new RuntimeException("Test subclass needs to prepare a dataset location");

        // Load the base dataset file
        try {

            InputStream input =
                    Thread.currentThread().getContextClassLoader()
                            .getResourceAsStream(dataSetLocation);

            dataSet = new ReplacementDataSet(new FlatXmlDataSet(input));
            dataSet.addReplacementObject("[NULL]", null);

        } catch (DataSetException ex) {
            throw new RuntimeException("Couldn't load DBUnit dataset: " + dataSetLocation, ex);
        }
    }

    @BeforeMethod(groups = "integration-hibernate")
    public void beforeTestMethod() throws Exception {
        prepareSettings();
        for (DatabaseOperation op : beforeTestOperations ) {
            op.execute(getConnection(), dataSet);
        }
    }

    @AfterMethod(groups = "integration-hibernate")
    public void afterTestMethod() throws Exception {
        for (DatabaseOperation op : afterTestOperations ) {
            op.execute(getConnection(), dataSet);
        }
    }

    // Subclasses can/have to override the following methods

    protected IDatabaseConnection getConnection() throws Exception {

        // Get a JDBC connection from Hibernate
        Connection con =
            ((SessionFactoryImpl)HibernateUtil.getSessionFactory()).getSettings()
                    .getConnectionProvider().getConnection();

        // Disable foreign key constraint checking
        // This really depends on the DBMS product... here for HSQL DB
//        con.prepareStatement("set referential_integrity FALSE")
//            .execute();

        IDatabaseConnection dbUnitCon =
            new DatabaseConnection( con);

        // TODO: Remove this once DBUnit works with the latest HSQL DB
//        DatabaseConfig config = dbUnitCon.getConfig();
//        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new FixDBUnit());

        return dbUnitCon;
    }

    protected abstract void prepareSettings();

}

/**
 * This fixes DBUnit with the latest HSQL DB.
 * http://www.carbonfive.com/community/archives/2005/07/dbunit_hsql_and.html
 * 
 * SBA 2009-10-27 - I think we can remove this class - have already commented out 
 * its use above. HSQLDB now seems to work without it.
 *
 * 
 */
class FixDBUnit extends DefaultDataTypeFactory {

   public DataType createDataType(int sqlType, String sqlTypeName)
     throws DataTypeException {
      if (sqlType == Types.BOOLEAN) {
         return DataType.BOOLEAN;
       }
      return super.createDataType(sqlType, sqlTypeName);
    }
}
