package com.health.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.health.mongo.dbutil.DBConnection;
import com.health.mongo.entity.SecondLevelInfo;
import com.health.mongo.entity.ThirdLevelInfo;

public class ThirdLevelInfoDao {

	public ThirdLevelInfo create(ThirdLevelInfo m){
		
		DBConnection.INSTANCE.getMongoTemplate().save(m);
		return m;
		
	}
	
	public List<ThirdLevelInfo> getAllInfo(){
		System.out.println("here i am");
		return DBConnection.INSTANCE.getMongoTemplate().findAll(ThirdLevelInfo.class);
	}
	
	public List<ThirdLevelInfo> getAllByGender(String gender){
		
		System.out.println("here i am in type"+gender +  " : " );
		Criteria queryCriteria = Criteria.where("gender").is(gender);
		Query q=new Query();
		q.addCriteria(queryCriteria);
		System.out.println("q " +q);
		return DBConnection.INSTANCE.getMongoTemplate().find(q, ThirdLevelInfo.class);
	}

}
