package com.mype.easyword.db.dataaccess;

import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.dataset.IDataSet;

import javax.sql.DataSource;

/**
 * @author Vitaliy Gerya
 */
public class BaseDBTest extends DataSourceBasedDBTestCase {

    @Override
    protected DataSource getDataSource() {
        return null;  //TODO implement it
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return null;  //TODO implement it
    }
}
