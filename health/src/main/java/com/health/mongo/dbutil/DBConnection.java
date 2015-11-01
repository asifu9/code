package com.health.mongo.dbutil;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

public enum DBConnection {
	
	INSTANCE;
	private  ClassPathXmlApplicationContext applicationcontext = null;
	private MongoTemplate mongoTemplate=null;
	 DBConnection() {
		// TODO Auto-generated constructor stub
		applicationcontext = new ClassPathXmlApplicationContext("/spring/spring-config.xml");
		mongoTemplate = (MongoTemplate) applicationcontext.getBean("mongoTemplate");
	}
	
	public MongoTemplate getMongoTemplate(){
		return mongoTemplate;
	}
}
