package com.health.mongo.dbutil;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


public class PersistConfigurationMongoImpl extends AbstractBeanHelper implements IPersistConfigurations {
	public <T> void saveConfig(T configObj) {
		getDBHelper().insertDocument(configObj);
	}

	public <T> T getConfig(String providerName, Class<T> entityClass) {
		return getDBHelper().findFirstDocument(findbyIdQuery(providerName), entityClass);
	}

	public int updateConfig(String providerName, Map<String, Object> updateData, Class<?> entityClass) {
		return getDBHelper().updateDocument(findbyIdQuery(providerName), getUpdateCriteria(updateData), entityClass);
	}

	private Query findbyIdQuery(String providerName) {
		return Query.query(Criteria.where("ID").is(providerName));
	}

	public <T> List<T> getAllConfig(String collectionName, Class<T> entityClass) {
		return getDBHelper().findAllDocuments(entityClass, collectionName);
	}
}
