package com.health.mongo.dbutil;


/**
 * This registry class provides helper methods for accessing the beans defined
 * in spring config files
 * 
 * @author martin.simon
 *
 */
public class SpringBeanRegistry {
	private volatile static SpringBeanRegistry springBeanRegistry;
	private IDBHelper dbHelper = null;
	private IPersistConfigurations persistConf = null;

	private SpringBeanRegistry() {
	}

	/**
	 * The factory method for getting an instance of the registry
	 * 
	 * @return
	 */
	public static SpringBeanRegistry getInstance() {
		if (springBeanRegistry == null) {
			synchronized (SpringBeanRegistry.class) {
				if (springBeanRegistry == null) {
					springBeanRegistry = new SpringBeanRegistry();
				}
			}
		}
		return springBeanRegistry;
	}

	/**
	 * This method returns the instance of the DBHelper class, configured in the
	 * spring configuration file.
	 * 
	 * @return
	 */
	public IDBHelper getDbHelper() {
		return dbHelper;
	}

	/**
	 * This method sets the instance of the DBHelper class, configured in the
	 * spring configuration file.
	 * 
	 * @param dbHelper
	 *            the dbHelper to set
	 */
	public void setDbHelper(IDBHelper dbHelper) {
		this.dbHelper = dbHelper;
	}

	/**
	 * @return the persistConf
	 */
	public IPersistConfigurations getPersistConf() {
		return persistConf;
	}

	/**
	 * @param persistConf
	 *            the persistConf to set
	 */
	public void setPersistConf(IPersistConfigurations persistConf) {
		this.persistConf = persistConf;
	}


}
