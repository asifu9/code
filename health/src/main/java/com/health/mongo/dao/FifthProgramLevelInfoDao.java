package com.health.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.health.mongo.dbutil.DBConnection;
import com.health.mongo.entity.FifthProgramLevelInfo;
import com.health.mongo.entity.SecondLevelInfo;

public class FifthProgramLevelInfoDao {

	public FifthProgramLevelInfo create(FifthProgramLevelInfo m){
		
		DBConnection.INSTANCE.getMongoTemplate().save(m);
		return m;
		
	}
	
	public List<FifthProgramLevelInfo> getAllByBaseAndGender(String base,String gender){


		System.out.println("here i am in type"+gender +  " : " + base );
		Criteria queryCriteria = Criteria.where("gender").is(gender).andOperator(Criteria.where("base").is(base));
		Query q=new Query();
		q.addCriteria(queryCriteria);
		System.out.println("q " +q);
		return DBConnection.INSTANCE.getMongoTemplate().find(q, FifthProgramLevelInfo.class);
	}
}
