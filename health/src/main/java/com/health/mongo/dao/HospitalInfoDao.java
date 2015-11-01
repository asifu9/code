package com.health.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.health.mongo.dbutil.DBConnection;
import com.health.mongo.entity.FifthProgramLevelInfo;
import com.health.mongo.entity.HospitalInfo;
import com.health.mongo.entity.SecondLevelInfo;

public class HospitalInfoDao {

	public HospitalInfo create(HospitalInfo m){
		
		DBConnection.INSTANCE.getMongoTemplate().save(m);
		return m;
		
	}
	public List<HospitalInfo> getAllHospitalInfo(){
		return DBConnection.INSTANCE.getMongoTemplate().findAll(HospitalInfo.class);
	}
	public List<HospitalInfo> getAllHospitalInfoByType(String type){


		System.out.println("here i am in type"+" : " + type );
		Criteria queryCriteria = Criteria.where("type").is(type);//.andOperator(Criteria.where("base").is(base));
		Query q=new Query();
		q.addCriteria(queryCriteria);
		System.out.println("q " +q);
		return DBConnection.INSTANCE.getMongoTemplate().find(q, HospitalInfo.class);
	}
}
