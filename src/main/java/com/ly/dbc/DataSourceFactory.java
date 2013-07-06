package com.ly.dbc;

import ivy.core.tool.Str;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.FactoryBean;

/**
 * 
 * @author holaivy@gmail.com
 * 
 */
public class DataSourceFactory implements FactoryBean<DataSource> {

	@Override
	public DataSource getObject() throws Exception {
		Logger logger = Logger.getLogger(DataSourceFactory.class);
		Context ctx = null;
		DataSource datasource = null;
		try {
			String dsname = Str.isEmpty(jndiDataSourceName) ? "DataSource"
					: jndiDataSourceName;
			ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			Object lookup = null;
			if (envContext != null)
				lookup = envContext.lookup(dsname);
			// lookup = ctx.lookup(dsname);
			if (lookup != null) {
				datasource = (DataSource) lookup;
				logger.debug("JNDI DataSource FOUND: " + datasource.toString());
			} else
				logger.debug("JNDI DataSource is empty!");
		} catch (NamingException e) {
			logger.debug(e.toString() + e.getMessage());
		}
		if (datasource == null) {
			if (logger.isDebugEnabled())
				logger.debug("Using Local DataSource,now:"
						+ localDataSource.toString());
			datasource = localDataSource;
		}
		return datasource;
	}

	@Override
	public Class<?> getObjectType() {
		return DataSource.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	private DataSource localDataSource;
	private String jndiDataSourceName;

	public String getJndiDataSourceName() {
		return jndiDataSourceName;
	}

	public void setJndiDataSourceName(String jndiDataSourceName) {
		this.jndiDataSourceName = jndiDataSourceName;
	}

	public DataSource getLocalDataSource() {
		return localDataSource;
	}

	public void setLocalDataSource(DataSource localDataSource) {
		this.localDataSource = localDataSource;
	}

}
