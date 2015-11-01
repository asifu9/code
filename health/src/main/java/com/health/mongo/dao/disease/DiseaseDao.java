package com.health.mongo.dao.disease;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.health.mongo.dbutil.DBConnection;
import com.health.mongo.entity.FirstLevelInfo;
import com.health.mongo.entity.SecondLevelInfo;
import com.health.mongo.entity.disease.DiseaseDetails;

public class DiseaseDao {

	public DiseaseDetails create(DiseaseDetails m){
		
		DBConnection.INSTANCE.getMongoTemplate().save(m);
		return m;
		
	}
	
	public List<DiseaseDetails> getAllInfo(){
		System.out.println("here i am");
		return DBConnection.INSTANCE.getMongoTemplate().findAll(DiseaseDetails.class);
	}
	
	public List<DiseaseDetails> getById(String id){
		
		System.out.println("here i am in type"+id +  " : " );
		Criteria queryCriteria = Criteria.where("id").is(id);//.andOperator(Criteria.where("base").is(base));
		Query q=new Query();
		q.addCriteria(queryCriteria);
		System.out.println("q " +q);
		return DBConnection.INSTANCE.getMongoTemplate().find(q, DiseaseDetails.class);
	}
}
