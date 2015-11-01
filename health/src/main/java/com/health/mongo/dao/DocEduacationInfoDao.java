package com.health.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.health.mongo.dbutil.DBConnection;
import com.health.mongo.entity.DocEduaction;
import com.health.mongo.entity.FifthProgramLevelInfo;
import com.health.mongo.entity.HospitalInfo;
import com.health.mongo.entity.SecondLevelInfo;
import com.health.mongo.entity.SpecialityInfo;

public class DocEduacationInfoDao {

	public DocEduaction create(DocEduaction m){
		
		DBConnection.INSTANCE.getMongoTemplate().save(m);
		return m;
		
	}
	public List<DocEduaction> getAll(){
		return DBConnection.INSTANCE.getMongoTemplate().findAll(DocEduaction.class);
	}
	public List<DocEduaction> getAllByDocId(String docId){


		System.out.println("here i am in type"+" : " + docId );
		Criteria queryCriteria = Criteria.where("docId").is(docId);//.andOperator(Criteria.where("base").is(base));
		Query q=new Query();
		q.addCriteria(queryCriteria);
		System.out.println("q " +q);
		return DBConnection.INSTANCE.getMongoTemplate().find(q, DocEduaction.class);
	}
}
