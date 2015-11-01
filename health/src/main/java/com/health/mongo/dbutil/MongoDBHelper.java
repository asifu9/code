package com.health.mongo.dbutil;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.WriteResult;
import com.mongodb.gridfs.GridFSDBFile;

/**
 * This class provides the implementation for using mongodb as the content
 * store.
 * 
 * @author martin.simon
 *
 */
@Profile(value="MONGO")
public class MongoDBHelper implements IDBHelper {
	
	/** The mongo template. */
	private MongoOperations mongoTemplate;
	
	/** The converter. */
	private MongoConverter converter;
	
	/** The db factory. */
	private MongoDbFactory dbFactory;
	
	/** The mongo db helper. */
	private static IDBHelper mongoDBHelper;

	/**
	 * Instantiates a new mongo db helper.
	 *
	 * @param mongoTemplate the mongo template
	 * @param dbFactory the db factory
	 * @param converter the converter
	 */
	private MongoDBHelper(MongoOperations mongoTemplate, MongoDbFactory dbFactory, MongoConverter converter) {
		this.mongoTemplate = mongoTemplate;
		this.converter = converter;
		this.dbFactory = dbFactory;
	}

	/**
	 * The factory method to be used for instantiating the mongo db content
	 * provider.
	 *
	 * @param mongoTemplate the mongo template
	 * @param dbFactory the db factory
	 * @param converter the converter
	 * @return single instance of MongoDBHelper
	 */
	public static IDBHelper getInstance(MongoOperations mongoTemplate, MongoDbFactory dbFactory, MongoConverter converter) {
		if (mongoDBHelper == null) {
			synchronized (MongoDBHelper.class) {
				if (mongoDBHelper == null) {
					mongoDBHelper = new MongoDBHelper(mongoTemplate, dbFactory, converter);
				}
			}
		}
		return mongoDBHelper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#createCollection(java.lang
	 * .Class)
	 */
	public <T> void createCollection(Class<T> classDef) {
		mongoTemplate.createCollection(classDef);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#createCollection(java.lang
	 * .String)
	 */
	public void createCollection(String collectionName) {
		mongoTemplate.createCollection(collectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#dropCollection(java.lang
	 * .Class)
	 */
	public <T> void dropCollection(Class<T> classDef) {
		mongoTemplate.dropCollection(classDef);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#dropCollection(java.lang
	 * .String)
	 */
	public void dropCollection(String collectionName) {
		mongoTemplate.dropCollection(collectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#insertDocument(java.lang
	 * .Object)
	 */
	public void insertDocument(Object document) {
		mongoTemplate.insert(document);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#insertDocument(java.lang
	 * .Object, java.lang.String)
	 */
	public void insertDocument(Object document, String collectionName) {
		mongoTemplate.insert(document, collectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#insertDocuments(java.util
	 * .Collection, java.lang.Class)
	 */
	public void insertDocuments(Collection<? extends Object> documentCollection, Class<?> entityClass) {
		mongoTemplate.insert(documentCollection, entityClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#insertDocuments(java.util
	 * .Collection, java.lang.String)
	 */
	public void insertDocuments(Collection<? extends Object> documentCollection, String collectionName) {
		mongoTemplate.insert(documentCollection, collectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#insertAllDocuments(java.
	 * util.Collection)
	 */
	public void insertAllDocuments(Collection<? extends Object> documentCollection) {
		mongoTemplate.insertAll(documentCollection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#findAllDocuments(java.lang
	 * .Class)
	 */
	public <T> List<T> findAllDocuments(Class<T> entityClass) {
		return mongoTemplate.findAll(entityClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#findAllDocuments(java.lang
	 * .Class, java.lang.String)
	 */
	public <T> List<T> findAllDocuments(Class<T> entityClass, String collectionName) {
		return mongoTemplate.findAll(entityClass, collectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#findDocuments(org.
	 * springframework.data.mongodb.core.query.Query, java.lang.Class)
	 */
	public <T> List<T> findDocuments(Query query, Class<T> entityClass) {
		return mongoTemplate.find(query, entityClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#findDocuments(org.
	 * springframework.data.mongodb.core.query.Query, java.lang.Class,
	 * java.lang.String)
	 */
	public <T> List<T> findDocuments(Query query, Class<T> entityClass, String collectionName) {
		return mongoTemplate.find(query, entityClass, collectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#findDocumentById(java.lang
	 * .Object, java.lang.Class)
	 */
	public <T> T findDocumentById(Object id, Class<T> entityClass) {
		return mongoTemplate.findById(id, entityClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#findDocumentById(java.lang
	 * .Object, java.lang.Class, java.lang.String)
	 */
	public <T> T findDocumentById(Object id, Class<T> entityClass, String collectionName) {
		return mongoTemplate.findById(id, entityClass, collectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#findFirstDocument(org.
	 * springframework.data.mongodb.core.query.Query, java.lang.Class)
	 */
	public <T> T findFirstDocument(Query query, Class<T> entityClass) {
		return mongoTemplate.findOne(query, entityClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#findFirstDocument(org.
	 * springframework.data.mongodb.core.query.Query, java.lang.Class,
	 * java.lang.String)
	 */
	public <T> T findFirstDocument(Query query, Class<T> entityClass, String collectionName) {
		return mongoTemplate.findOne(query, entityClass, collectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#removeDocument(java.lang
	 * .Object)
	 */
	public int removeDocument(Object document) {
		WriteResult result = mongoTemplate.remove(document);
		return result.getN();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#removeDocument(java.lang
	 * .Object, java.lang.String)
	 */
	public int removeDocument(Object document, String collectionName) {
		WriteResult result = mongoTemplate.remove(document, collectionName);
		return result.getN();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#removeDocuments(org.
	 * springframework.data.mongodb.core.query.Query, java.lang.Class)
	 */
	public int removeDocuments(Query query, Class<?> entityClass) {
		WriteResult result = mongoTemplate.remove(query, entityClass);
		return result.getN();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#removeDocuments(org.
	 * springframework.data.mongodb.core.query.Query, java.lang.String)
	 */
	public int removeDocuments(Query query, String collectionName) {
		WriteResult result = mongoTemplate.remove(query, collectionName);
		return result.getN();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#removeDocuments(org.
	 * springframework.data.mongodb.core.query.Query, java.lang.Class,
	 * java.lang.String)
	 */
	public int removeDocuments(Query query, Class<?> entityClass, String collectionName) {
		WriteResult result = mongoTemplate.remove(query, entityClass, collectionName);
		return result.getN();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#updateDocuments(org.
	 * springframework.data.mongodb.core.query.Query,
	 * org.springframework.data.mongodb.core.query.Update, java.lang.Class)
	 */
	public int updateDocuments(Query query, Update updateCriteria, Class<?> entityClass) {
		WriteResult result = mongoTemplate.updateMulti(query, updateCriteria, entityClass);
		return result.getN();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#updateDocuments(org.
	 * springframework.data.mongodb.core.query.Query,
	 * org.springframework.data.mongodb.core.query.Update, java.lang.String)
	 */
	public int updateDocuments(Query query, Update updateCriteria, String collectionName) {
		WriteResult result = mongoTemplate.updateMulti(query, updateCriteria, collectionName);
		return result.getN();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#updateDocuments(org.
	 * springframework.data.mongodb.core.query.Query,
	 * org.springframework.data.mongodb.core.query.Update, java.lang.Class,
	 * java.lang.String)
	 */
	public int updateDocuments(Query query, Update updateCriteria, Class<?> entityClass, String collectionName) {
		WriteResult result = mongoTemplate.updateMulti(query, updateCriteria, entityClass, collectionName);
		return result.getN();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#updateDocument(org.
	 * springframework.data.mongodb.core.query.Query,
	 * org.springframework.data.mongodb.core.query.Update, java.lang.Class)
	 */
	public int updateDocument(Query query, Update updateCriteria, Class<?> entityClass) {
		WriteResult result = mongoTemplate.updateFirst(query, updateCriteria, entityClass);
		return result.getN();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#updateDocument(org.
	 * springframework.data.mongodb.core.query.Query,
	 * org.springframework.data.mongodb.core.query.Update, java.lang.String)
	 */
	public int updateDocument(Query query, Update updateCriteria, String collectionName) {
		WriteResult result = mongoTemplate.updateFirst(query, updateCriteria, collectionName);
		return result.getN();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#updateDocument(org.
	 * springframework.data.mongodb.core.query.Query,
	 * org.springframework.data.mongodb.core.query.Update, java.lang.Class,
	 * java.lang.String)
	 */
	public int updateDocument(Query query, Update updateCriteria, Class<?> entityClass, String collectionName) {
		WriteResult result = mongoTemplate.updateFirst(query, updateCriteria, entityClass, collectionName);
		return result.getN();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#insertOrUpdateDocument(java
	 * .lang.Object)
	 */
	public void insertOrUpdateDocument(Object document) {
		mongoTemplate.save(document);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#insertOrUpdateDocument(java
	 * .lang.Object, java.lang.String)
	 */
	public void insertOrUpdateDocument(Object document, String collectionName) {
		mongoTemplate.save(document, collectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#insertOrUpdate(org.springframework.data.mongodb.core.query.Query, org.springframework.data.mongodb.core.query.Update, java.lang.Class)
	 */
	public void insertOrUpdate(Query query, Update update, Class<?> entityClass) {
		mongoTemplate.upsert(query, update, entityClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#insertOrUpdate(org.springframework.data.mongodb.core.query.Query, org.springframework.data.mongodb.core.query.Update, java.lang.String)
	 */
	public void insertOrUpdate(Query query, Update update, String collectionName) {
		mongoTemplate.upsert(query, update, collectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#insertOrUpdate(org.springframework.data.mongodb.core.query.Query, org.springframework.data.mongodb.core.query.Update, java.lang.Class, java.lang.String)
	 */
	public void insertOrUpdate(Query query, Update update, Class<?> entityClass, String collectionName) {
		mongoTemplate.upsert(query, update, entityClass, collectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#getCollectionName(java.lang
	 * .Class)
	 */
	public String getCollectionName(Class<?> entityClass) {
		return mongoTemplate.getCollectionName(entityClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#isCollectionExists(java.
	 * lang.Class)
	 */
	public <T> boolean isCollectionExists(Class<T> entityClass) {
		return mongoTemplate.collectionExists(entityClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#isCollectionExists(java.
	 * lang.String)
	 */
	public boolean isCollectionExists(String collectionName) {
		return mongoTemplate.collectionExists(collectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#getCount(org.springframework.data.mongodb.core.query.Query, java.lang.Class)
	 */
	public long getCount(Query query, Class<?> entityClass) {
		return mongoTemplate.count(query, entityClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#getCount(org.springframework.data.mongodb.core.query.Query, java.lang.String)
	 */
	public long getCount(Query query, String collectionName) {
		return mongoTemplate.count(query, collectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#addIndex(java.lang.String, java.lang.String, boolean, boolean)
	 */
	public void addIndex(String collectionName, String fieldName, boolean unique, boolean isAscending) {
		// Creating the index
		Index index = null;
		if (isAscending) {
			index = new Index(fieldName, Direction.ASC);
		} else {
			index = new Index(fieldName, Direction.DESC);
		}
		if (unique) {
			index.unique();
		}
		// Setting whether the index is unique
		mongoTemplate.indexOps(collectionName).ensureIndex(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#addFile(java.io.InputStream,
	 * java.lang.String)
	 */
	public void addFile(InputStream content, String fileName, String collectionName) {
		GridFsTemplate gridFSTemplate = new GridFsTemplate(dbFactory, converter, collectionName);
		gridFSTemplate.store(content, fileName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#addFile(java.io.InputStream,
	 * java.lang.String, java.lang.String)
	 */
	public void addFile(InputStream content, String fileName, String contentType, String collectionName) {
		GridFsTemplate gridFSTemplate = new GridFsTemplate(dbFactory, converter, collectionName);
		gridFSTemplate.store(content, fileName, contentType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#addFile(java.io.InputStream,
	 * java.lang.String, java.lang.Object)
	 */
	public void addFile(InputStream content, String fileName, Object metadata, String collectionName) {
		GridFsTemplate gridFSTemplate = new GridFsTemplate(dbFactory, converter, collectionName);
		gridFSTemplate.store(content, fileName, metadata);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#addFile(java.io.InputStream,
	 * java.lang.String, java.lang.String, java.lang.Object)
	 */
	public void addFile(InputStream content, String fileName, String contentType, Object metadata, String collectionName) {
		GridFsTemplate gridFSTemplate = new GridFsTemplate(dbFactory, converter, collectionName);
		gridFSTemplate.store(content, fileName, contentType, metadata);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#findFile(org.springframework
	 * .data.mongodb.core.query.Query)
	 */
	public GridFSDBFile findFile(Query query, String collectionName) {
		GridFsTemplate gridFSTemplate = new GridFsTemplate(dbFactory, converter, collectionName);
		return gridFSTemplate.findOne(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#findFiles(org.springframework
	 * .data.mongodb.core.query.Query)
	 */
	public List<GridFSDBFile> findFiles(Query query, String collectionName) {
		GridFsTemplate gridFSTemplate = new GridFsTemplate(dbFactory, converter, collectionName);
		return gridFSTemplate.find(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.msi.grcintelligence.mongo.util.IDBHelper#deleteFiles(org.springframework
	 * .data.mongodb.core.query.Query)
	 */
	public void deleteFiles(Query query, String collectionName) {
		GridFsTemplate gridFSTemplate = new GridFsTemplate(dbFactory, converter, collectionName);
		gridFSTemplate.delete(query);
	}

	/* (non-Javadoc)
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#insertAll(java.util.Collection, java.lang.String)
	 */
	public void insertAll(Collection<?> data, String collectionName) {
		mongoTemplate.insert(data, collectionName);
	}

	/* (non-Javadoc)
	 * @see com.msi.grcintelligence.mongo.util.IDBHelper#removeRecord(java.lang.Object)
	 */
	public void removeRecord(Object rec) {
		mongoTemplate.remove(rec);
	}
}
