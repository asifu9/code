package com.health.mongo.dbutil;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.gridfs.GridFSDBFile;

/**
 * This interface establishes the API contract to be supported by content store
 * provider implementations.
 * 
 * @author martin.simon
 *
 */
public interface IDBHelper {
	
	/**
	 * Create a collection for the specified entityClass. The collection name
	 * will be taken from the @Document annotation if one is specified in the
	 * entity class, else it will take it from the class name with the first
	 * letter in lower case.
	 *
	 * @param <T> the generic type
	 * @param classDef            class that determines the collection to create
	 */
	<T> void createCollection(Class<T> classDef);

	/**
	 * Create a collection with the specified name.
	 *
	 * @param collectionName            name of the collection
	 */
	void createCollection(String collectionName);

	/**
	 * If present drop the collection for the specified entity class. The
	 * collection name will be taken from the @Document annotation if one is
	 * specified in the entity class, else it will take it from the class name
	 * with the first letter in lower case.
	 *
	 * @param <T> the generic type
	 * @param classDef            class that determines the collection to drop/delete.
	 */
	<T> void dropCollection(Class<T> classDef);

	/**
	 * Drop the collection with the specified name.
	 *
	 * @param collectionName            collectionName name of the collection to drop/delete.
	 */
	void dropCollection(String collectionName);

	/**
	 * Insert a new document in content store. The collection name will be taken
	 * from the @Document annotation if one is specified in the entity class,
	 * else it will take it from the class name with the first letter in lower
	 * case. The collection is created if not present.
	 * 
	 * @param document
	 *            the object to store in the collection.
	 */
	void insertDocument(Object document);

	/**
	 * Add a new document to the collection with the specified name. The
	 * collection is created if not present.
	 * 
	 * @param document
	 *            the object to store in the collection.
	 * @param collectionName
	 *            name of the collection to store the object in
	 */
	void insertDocument(Object document, String collectionName);

	/**
	 * Add a collection of documents to content store. The collection name will
	 * be taken from the @Document annotation if one is specified in the entity
	 * class, else it will take it from the class name with the first letter in
	 * lower case. The collection is created if not present. The document
	 * objects should all be an instance of the passed in entity class.
	 * 
	 * @param documentCollection
	 *            the list of objects to save.
	 * @param entityClass
	 *            class that determines the collection to use
	 */
	void insertDocuments(Collection<? extends Object> documentCollection, Class<?> entityClass);

	/**
	 * Add a collection of documents to the collection with the specified name.
	 * The collection is created if not present.
	 * 
	 * @param documentCollection
	 *            the list of objects to save.
	 * @param collectionName
	 *            name of the collection to store the object in
	 */
	void insertDocuments(Collection<? extends Object> documentCollection, String collectionName);

	/**
	 * Add a heterogeneous collection of documents to content store. For each
	 * document object, the collection name will be taken from the @Document
	 * annotation if one is specified in the entity class, else it will take it
	 * from the class name with the first letter in lower case. The collection
	 * is created if not present.
	 * 
	 * @param documentCollection
	 *            the list of objects to save.
	 */
	void insertAllDocuments(Collection<? extends Object> documentCollection);

	/**
	 * Get all the documents from the collection represented by the entity class.
	 *
	 * @param <T> the generic type
	 * @param entityClass            the parameterized type of the returned list
	 * @return the converted collection
	 */
	<T> List<T> findAllDocuments(Class<T> entityClass);

	/**
	 * Get all the documents from the collection with the specified name.
	 *
	 * @param <T> the generic type
	 * @param entityClass            the parameterized type of the returned list
	 * @param collectionName the collection name
	 * @return the converted collection
	 */
	<T> List<T> findAllDocuments(Class<T> entityClass, String collectionName);

	/**
	 * Get all documents matching the query criteria. The collection name will
	 * be taken from the @Document annotation if one is specified in the entity
	 * class, else it will take it from the class name with the first letter in
	 * lower case.
	 *
	 * @param <T> the generic type
	 * @param query            the query class that specifies the criteria used to find a
	 *            record and also an optional fields specification
	 * @param entityClass            the parameterized type of the returned list
	 * @return the converted collection
	 */
	<T> List<T> findDocuments(Query query, Class<T> entityClass);

	/**
	 * Get all documents matching the query criteria from the collection with
	 * specified name.
	 *
	 * @param <T> the generic type
	 * @param query            the query class that specifies the criteria used to find a
	 *            record and also an optional fields specification
	 * @param entityClass            the parameterized type of the returned list
	 * @param collectionName the collection name
	 * @return the converted collection
	 */
	<T> List<T> findDocuments(Query query, Class<T> entityClass, String collectionName);

	/**
	 * Get the document having the given ID. The collection name will be taken
	 * from the @Document annotation if one is specified in the entity class,
	 * else it will take it from the class name with the first letter in lower
	 * case.
	 *
	 * @param <T> the generic type
	 * @param id            the id of the document to return.
	 * @param entityClass            the type the document shall be converted into.
	 * @return the document with the given id mapped onto the given target
	 *         class.
	 */
	<T> T findDocumentById(Object id, Class<T> entityClass);

	/**
	 * Get the document having the given ID from the collection having the
	 * specified name.
	 *
	 * @param <T> the generic type
	 * @param id            the id of the document to return.
	 * @param entityClass            the type the document shall be converted into.
	 * @param collectionName            name of the collection to retrieve the objects from
	 * @return the document with the given id mapped onto the given target
	 *         class.
	 */
	<T> T findDocumentById(Object id, Class<T> entityClass, String collectionName);

	/**
	 * Get the first document matching the query criteria. The collection name
	 * will be taken from the @Document annotation if one is specified in the
	 * entity class, else it will take it from the class name with the first
	 * letter in lower case.
	 *
	 * @param <T> the generic type
	 * @param query            the query class that specifies the criteria used to find a
	 *            record and also an optional fields specification
	 * @param entityClass            the parameterized type of the returned list.
	 * @return the converted object
	 */
	<T> T findFirstDocument(Query query, Class<T> entityClass);

	/**
	 * Get the first document matching the query criteria from the collection
	 * with specified name.
	 *
	 * @param <T> the generic type
	 * @param query            the query class that specifies the criteria used to find a
	 *            record and also an optional fields specification
	 * @param entityClass            the parameterized type of the returned list.
	 * @param collectionName            name of the collection to retrieve the objects from
	 * @return the converted object
	 */
	<T> T findFirstDocument(Query query, Class<T> entityClass, String collectionName);

	/**
	 * Remove a document from content store. The collection name will be taken
	 * from the @Document annotation if one is specified in the entity class,
	 * else it will take it from the class name with the first letter in lower
	 * case.
	 * 
	 * @param document
	 *            the object to be removed
	 * @return the number of documents removed
	 */
	int removeDocument(Object document);

	/**
	 * Remove a document from the collection with the specified name.
	 *
	 * @param document            the object to be removed
	 * @param collectionName            name of the collection to remove the objects from
	 * @return the number of documents removed
	 */
	int removeDocument(Object document, String collectionName);

	/**
	 * Remove documents matching the given query from content store. The
	 * collection name will be taken from the @Document annotation if one is
	 * specified in the entity class, else it will take it from the class name
	 * with the first letter in lower case.
	 * 
	 * @param query
	 *            the query class that specifies the criteria used to find a
	 *            record and also an optional fields specification
	 * @param entityClass
	 *            the parameterized type of the object to be deleted.
	 * @return the number of documents removed
	 */
	int removeDocuments(Query query, Class<?> entityClass);

	/**
	 * Remove documents matching the given query from the collection with the
	 * specified name.
	 * 
	 * @param query
	 *            the query class that specifies the criteria used to find a
	 *            record and also an optional fields specification
	 * @param collectionName
	 *            name of the collection to remove the objects from
	 * @return the number of documents removed
	 */
	int removeDocuments(Query query, String collectionName);

	/**
	 * Remove documents matching the given query from the collection with the
	 * specified name.
	 * 
	 * @param query
	 *            the query class that specifies the criteria used to find a
	 *            record and also an optional fields specification
	 * @param entityClass
	 *            the parameterized type of the object to be deleted.
	 * @param collectionName
	 *            name of the collection to remove the objects from
	 * @return the number of documents removed
	 */
	int removeDocuments(Query query, Class<?> entityClass, String collectionName);

	/**
	 * Update documents matching the given query from content store.The
	 * collection name will be taken from the @Document annotation if one is
	 * specified in the entity class, else it will take it from the class name
	 * with the first letter in lower case.
	 * 
	 * @param query
	 *            the query document that specifies the criteria used to select
	 *            a record to be updated
	 * @param updateCriteria
	 *            the update document that contains the updated object or $
	 *            operators to manipulate the existing object.
	 * @param entityClass
	 *            class that determines the collection to use
	 * @return the number of documents updated
	 */
	int updateDocuments(Query query, Update updateCriteria, Class<?> entityClass);

	/**
	 * Update documents matching the given query from the collection with the
	 * same name.
	 * 
	 * @param query
	 *            the query document that specifies the criteria used to select
	 *            a record to be updated
	 * @param updateCriteria
	 *            the update document that contains the updated object or $
	 *            operators to manipulate the existing object.
	 * @param collectionName
	 *            name of the collection to update the object in
	 * @return the number of documents updated
	 */
	int updateDocuments(Query query, Update updateCriteria, String collectionName);

	/**
	 * Update documents matching the given query from the collection with the
	 * same name.
	 *
	 * @param query            the query document that specifies the criteria used to select
	 *            a record to be updated
	 * @param updateCriteria            the update document that contains the updated object or $
	 *            operators to manipulate the existing object.
	 * @param entityClass the entity class
	 * @param collectionName            name of the collection to update the object in
	 * @return the number of documents updated
	 */
	int updateDocuments(Query query, Update updateCriteria, Class<?> entityClass, String collectionName);

	/**
	 * Update the first document matching the given query from content store.
	 * The collection name will be taken from the @Document annotation if one is
	 * specified in the entity class, else it will take it from the class name
	 * with the first letter in lower case.
	 * 
	 * @param query
	 *            the query document that specifies the criteria used to select
	 *            a record to be updated
	 * @param updateCriteria
	 *            the update document that contains the updated object or $
	 *            operators to manipulate the existing object.
	 * @param entityClass
	 *            class that determines the collection to use
	 * @return the number of documents updated
	 */
	int updateDocument(Query query, Update updateCriteria, Class<?> entityClass);

	/**
	 * Update the first document matching the given query from the collection
	 * with the specified name.
	 * 
	 * @param query
	 *            the query document that specifies the criteria used to select
	 *            a record to be updated
	 * @param updateCriteria
	 *            the update document that contains the updated object or $
	 *            operators to manipulate the existing object.
	 * @param collectionName
	 *            name of the collection to update the object in
	 * @return the number of documents updated
	 */
	int updateDocument(Query query, Update updateCriteria, String collectionName);

	/**
	 * Update the first document matching the given query from from the
	 * collection with the specified name.
	 * 
	 * @param query
	 *            the query document that specifies the criteria used to select
	 *            a record to be updated
	 * @param updateCriteria
	 *            the update document that contains the updated object or $
	 *            operators to manipulate the existing object.
	 * @param entityClass
	 *            class that determines the collection to use
	 * @param collectionName
	 *            name of the collection to update the object in
	 * @return the number of documents updated
	 */
	int updateDocument(Query query, Update updateCriteria, Class<?> entityClass, String collectionName);

	/**
	 * Inserts a new document if one with the same id is not present in content
	 * store, else the document is updated. The collection name will be taken
	 * from the @Document annotation if one is specified in the entity class,
	 * else it will take it from the class name with the first letter in lower
	 * case.
	 * 
	 * @param document
	 *            the document to be inserted or updated
	 */
	void insertOrUpdateDocument(Object document);

	/**
	 * Inserts a new document if one with the same id is not present in the
	 * specified collection, else the document is updated.
	 *
	 * @param document            the document to be inserted or updated
	 * @param collectionName the collection name
	 */
	void insertOrUpdateDocument(Object document, String collectionName);

	/**
	 * Inserts a new document if one matching the query is not found, else it
	 * updates the existing documents.
	 *
	 * @param query            the query document that specifies the criteria used to select
	 *            a record to be updated
	 * @param update            the update document that contains the updated object or $
	 *            operators to manipulate the existing object.
	 * @param entityClass            the entity class specifying the collection name
	 */
	public void insertOrUpdate(Query query, Update update, Class<?> entityClass);

	/**
	 * Inserts a new document if one matching the query is not found, else it
	 * updates the existing documents.
	 *
	 * @param query            the query document that specifies the criteria used to select
	 *            a record to be updated
	 * @param update            the update document that contains the updated object or $
	 *            operators to manipulate the existing object.
	 * @param collectionName            the collection name
	 */
	public void insertOrUpdate(Query query, Update update, String collectionName);

	/**
	 * Inserts a new document if one matching the query is not found, else it
	 * updates the existing documents.
	 *
	 * @param query            the query document that specifies the criteria used to select
	 *            a record to be updated
	 * @param update            the update document that contains the updated object or $
	 *            operators to manipulate the existing object.
	 * @param entityClass            the class of the pojo representing the data
	 * @param collectionName            the collection name
	 */
	public void insertOrUpdate(Query query, Update update, Class<?> entityClass, String collectionName);

	/**
	 * Get the name of collection where instances of the given entity classes
	 * are persisted.
	 * 
	 * @param entityClass
	 *            the class that determines the collection to use
	 * @return name of the collection representing the entity class
	 */
	String getCollectionName(Class<?> entityClass);

	/**
	 * Checks if a collection representing the class exists.
	 *
	 * @param <T> the generic type
	 * @param entityClass            the class that represents the collection
	 * @return true, if is collection exists
	 */
	<T> boolean isCollectionExists(Class<T> entityClass);

	/**
	 * Checks if a collection with the given name exists.
	 *
	 * @param collectionName the collection name
	 * @return true, if is collection exists
	 */
	boolean isCollectionExists(String collectionName);

	/**
	 * Get the count of documents matching the given search criteria.
	 *
	 * @param query the criteria for search
	 * @param entityClass the class for determining the collection
	 * @return the count of rows
	 */
	long getCount(Query query, Class<?> entityClass);

	/**
	 * Get the count of documents matching the given search criteria.
	 *
	 * @param query the criteria for search
	 * @param collectionName the collection to search
	 * @return the count of rows
	 */
	long getCount(Query query, String collectionName);

	/**
	 * This method is used to add an index to a particular column.
	 *
	 * @param collectionName the collection name
	 * @param fieldName the field name on which index has to be created
	 * @param unique whether the index is unique
	 * @param isAscending whether the sort order is ascending or not
	 */
	void addIndex(String collectionName, String fieldName, boolean unique, boolean isAscending);

	/**
	 * Stores the given content into a file with the given name.
	 * 
	 * @param content
	 *            the file to be written to content store
	 * @param fileName
	 *            the name of the file
	 * @param collectionName
	 *            the collection name
	 */
	void addFile(InputStream content, String fileName, String collectionName);

	/**
	 * Stores the given content into a file with the given name and content
	 * type.
	 * 
	 * @param content
	 *            the file to be written to content store
	 * @param fileName
	 *            the name of the file
	 * @param contentType
	 *            the type of the file
	 * @param collectionName
	 *            the collection name
	 */
	void addFile(InputStream content, String fileName, String contentType, String collectionName);

	/**
	 * Stores the given content into a file with the given name and metadata.
	 *
	 * @param content            the file to be written to content store
	 * @param fileName            the name of the file
	 * @param metadata            the metadata of the file
	 * @param collectionName            the collection name
	 */
	void addFile(InputStream content, String fileName, Object metadata, String collectionName);

	/**
	 * Stores the given content into a file with the given name, content type
	 * and metadata.
	 * 
	 * @param content
	 *            the file to be written to content store
	 * @param fileName
	 *            the name of the file
	 * @param contentType
	 *            the type of the file
	 * @param metadata
	 *            the metadata of the file
	 * @param collectionName
	 *            the collection name
	 */
	void addFile(InputStream content, String fileName, String contentType, Object metadata, String collectionName);

	/**
	 * Returns a single file matching the given query or null in case no file
	 * matches.
	 * 
	 * @param query
	 *            the criteria for searching the files
	 * @param collectionName
	 *            the collection name
	 * @return the file if present else null
	 */
	GridFSDBFile findFile(Query query, String collectionName);

	/**
	 * Returns all files matching the given query. Note, that currently Sort
	 * criterias defined at the Query will not be regarded as MongoDB does not
	 * support ordering for GridFS file access.
	 * 
	 * @param query
	 *            the criteria for searching the files
	 * @param collectionName
	 *            the collection name
	 * @return the list of files satisfying the given query criteria
	 */
	List<GridFSDBFile> findFiles(Query query, String collectionName);

	/**
	 * Delete the files matching the given query criteria.
	 *
	 * @param query            the criteria for filtering the files to be deleted
	 * @param collectionName            the collection name
	 */
	void deleteFiles(Query query, String collectionName);
	
	/**
	 * Method to do an batch insert for given collection name.
	 *
	 * @param data the list of data
	 * @param collectionName the collection name
	 */
	void insertAll(Collection<?> data,String collectionName);
	
	
	/**
	 * Method to delete the record from collection
	 *
	 * @param rec the record object
	 */
	void removeRecord(Object rec);
}