package com.ly.dbc;

import ivy.core.tool.Str;
import ivy.system.SysInfo;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * 
 * @author xubch@neusoft.com
 * 
 */
public class DataSourceFactory implements FactoryBean<DataSource> {

	private String contextName = "java:/comp/env";

	@Override
	public DataSource getObject() throws Exception {
		Logger logger = LoggerFactory.getLogger(DataSourceFactory.class);
		Context ctx = null;
		DataSource datasource = null;
		if (jndiDataSource == null) {

			try {
				String dsname = Str.isEmpty(jndiDataSourceName) ? "DataSource"
						: jndiDataSourceName;
				ctx = new InitialContext();
				Object lookup = null;
				try {
					Context envContext = (Context) ctx.lookup(contextName);
					if (envContext != null)
						lookup = envContext.lookup(dsname);
					if (lookup != null) {
						if (lookup instanceof DataSource) {
							datasource = (DataSource) lookup;
							logger.debug("JNDI DataSource found in {} :{}- {}",
									contextName, jndiDataSourceName,
									datasource.toString());
						} else {
							logger.debug(
									"Object found in {} named {} ,but it's not a DataSource",
									contextName, jndiDataSourceName);
						}
					}
				} catch (Exception e) {
					logger.warn(e.toString());
				}
				if (lookup == null) {
					if (SysInfo.instance.isDev() && logger.isDebugEnabled()) {
						logger.debug(
								"DataSourceFactory is finding named {} resource from context",
								dsname);
					}
					lookup = ctx.lookup(dsname);
					if (lookup instanceof DataSource) {
						datasource = (DataSource) lookup;
						logger.debug("JNDI DataSource found: {}-{}",
								jndiDataSourceName, datasource.toString());
					} else {
						logger.debug("JNDI DataSource is empty [{}]!",
								jndiDataSourceName);
					}
				}

			} catch (NamingException e) {
				logger.warn(e.toString() + e.getMessage());
			}
			if (datasource == null) {
				if (logger.isDebugEnabled()) {
					logger.debug("Using Local DataSource: {}",
							localDataSource.toString());
				}
				datasource = localDataSource;
			}
		} else {
			logger.debug("Spring find the JNDI DataSouce:{}",
					jndiDataSource.toString());
			datasource = jndiDataSource;
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
	private DataSource jndiDataSource;

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

	public DataSource getJndiDataSource() {
		return jndiDataSource;
	}

	public void setJndiDataSource(DataSource jndiDataSource) {
		this.jndiDataSource = jndiDataSource;
	}

}
