package com.health.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.health.mongo.dbutil.DBConnection;
import com.health.mongo.entity.FirstLevelInfo;
import com.health.mongo.entity.SecondLevelInfo;

public class SecondLevelInfoDao {

	public SecondLevelInfo create(SecondLevelInfo m){
		
		DBConnection.INSTANCE.getMongoTemplate().save(m);
		return m;
		
	}
	
	public List<SecondLevelInfo> getAllInfo(){
		System.out.println("here i am");
		return DBConnection.INSTANCE.getMongoTemplate().findAll(SecondLevelInfo.class);
	}
	
	public List<SecondLevelInfo> getAllByBaseAndGender(String gender,String base){
		
		System.out.println("here i am in type"+gender +  " : " + base );
		Criteria queryCriteria = Criteria.where("gender").is(gender).andOperator(Criteria.where("base").is(base));
		Query q=new Query();
		q.addCriteria(queryCriteria);
		System.out.println("q " +q);
		return DBConnection.INSTANCE.getMongoTemplate().find(q, SecondLevelInfo.class);
	}
}
