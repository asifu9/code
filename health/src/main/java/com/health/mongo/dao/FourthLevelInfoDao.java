package com.health.mongo.dao;

import java.util.List;

import com.health.mongo.dbutil.DBConnection;
import com.health.mongo.entity.FourthLevelInfo;

public class FourthLevelInfoDao {

	public FourthLevelInfo create(FourthLevelInfo m){
		
		DBConnection.INSTANCE.getMongoTemplate().save(m);
		return m;
		
	}
	
	public List<FourthLevelInfo> getAllInfo(){
		System.out.println("here i am");
		return DBConnection.INSTANCE.getMongoTemplate().findAll(FourthLevelInfo.class);
	}
	}
