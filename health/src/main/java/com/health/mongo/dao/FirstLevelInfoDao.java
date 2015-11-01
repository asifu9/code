package com.health.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.health.mongo.dbutil.DBConnection;
import com.health.mongo.entity.FirstLevelInfo;

public class FirstLevelInfoDao {

	public FirstLevelInfo create(FirstLevelInfo m){
		
		DBConnection.INSTANCE.getMongoTemplate().save(m);
		return m;
		
	}
	
	public List<FirstLevelInfo> getAllFirstLevelInfo(){
		System.out.println("here i am");
		return DBConnection.INSTANCE.getMongoTemplate().findAll(FirstLevelInfo.class);
	}
	
	public FirstLevelInfo getFirstLevelByType(String type){
		System.out.println("here i am in type"+type);
		Criteria queryCriteria = Criteria.where("gender").is(type);
		Query q=new Query();
		q.addCriteria(queryCriteria);
		System.out.println("q " +q);
		return DBConnection.INSTANCE.getMongoTemplate().findOne(q, FirstLevelInfo.class);
	}
}
