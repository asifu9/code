package com.health.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.health.mongo.dbutil.DBConnection;
import com.health.mongo.entity.DocProfession;
import com.health.mongo.entity.DoctorInfo;
import com.health.mongo.entity.FifthProgramLevelInfo;
import com.health.mongo.entity.HospitalInfo;
import com.health.mongo.entity.SecondLevelInfo;
import com.health.mongo.entity.SpecialityInfo;

public class DoctorInfoDao {

	public DoctorInfo create(DoctorInfo m){
		
		DBConnection.INSTANCE.getMongoTemplate().save(m);
		return m;
		
	}
	public List<DoctorInfo> getAll(){
		return DBConnection.INSTANCE.getMongoTemplate().findAll(DoctorInfo.class);
	}
	public List<DoctorInfo> getDoctorBySpeciality(String specialtiy){


		System.out.println("here i am in type"+" : " + specialtiy );
		Criteria queryCriteria = Criteria.where("speciality").is(specialtiy);//.andOperator(Criteria.where("base").is(base));
		Query q=new Query();
		q.addCriteria(queryCriteria);
		System.out.println("q " +q);
		return DBConnection.INSTANCE.getMongoTemplate().find(q, DoctorInfo.class);
	}
}
