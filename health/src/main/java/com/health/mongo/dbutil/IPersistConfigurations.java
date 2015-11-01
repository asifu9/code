package com.health.mongo.dbutil;

import java.util.List;
import java.util.Map;

public interface IPersistConfigurations {
	/**
	 * This method saves the configuration details in source
	 * @param configObj configuration details to save
	 */
	<T> void saveConfig(T configObj);

	/**
	 * This method gets the configuration details from source
	 * @param providerName content provider name
	 * @param entityClass content provider pojo class
	 * @return returns the conrent provider configuration details
	 */
	<T> T getConfig(String providerName, Class<T> entityClass);
	
	/**
	 * This method gets the configuration details from source for all the content providers
	 * @param collectionName
	 * @param entityClass
	 * @return
	 */
	<T> List<T> getAllConfig(String collectionName, Class<T> entityClass);

	/**
	 * This method updates the configuration details in source
	 * @param providerName content provider name
	 * @param updateData updated configuration details
	 * @param entityClass content provider pojo class
	 * @return number of rows updated
	 */
	int updateConfig(String providerName, Map<String, Object> updateData, Class<?> entityClass);
}
