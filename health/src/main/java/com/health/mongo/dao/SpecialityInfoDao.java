package com.health.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.health.mongo.dbutil.DBConnection;
import com.health.mongo.entity.FifthProgramLevelInfo;
import com.health.mongo.entity.HospitalInfo;
import com.health.mongo.entity.SecondLevelInfo;
import com.health.mongo.entity.SpecialityInfo;

public class SpecialityInfoDao {

	public SpecialityInfo create(SpecialityInfo m){
		
		DBConnection.INSTANCE.getMongoTemplate().save(m);
		return m;
		
	}
	public List<SpecialityInfo> getAllHospitalInfo(){
		return DBConnection.INSTANCE.getMongoTemplate().findAll(SpecialityInfo.class);
	}
	public SpecialityInfo getSpecialityName(String id){


		System.out.println("here i am in type"+" : " + id );
		Criteria queryCriteria = Criteria.where("id").is(id);//.andOperator(Criteria.where("base").is(base));
		Query q=new Query();
		q.addCriteria(queryCriteria);
		System.out.println("q " +q);
		return DBConnection.INSTANCE.getMongoTemplate().findOne(q, SpecialityInfo.class);
	}
}
