package com.test;

import java.awt.image.DataBufferInt;
import java.util.Date;
import java.util.UUID;

import javax.net.ssl.HostnameVerifier;

import com.health.mongo.dao.DocEduacationInfoDao;
import com.health.mongo.dao.DocProfessionInfoDao;
import com.health.mongo.dao.DoctorInfoDao;
import com.health.mongo.dao.FirstLevelInfoDao;
import com.health.mongo.dao.HospitalInfoDao;
import com.health.mongo.dao.SpecialityInfoDao;
import com.health.mongo.dbutil.DBConnection;
import com.health.mongo.entity.DocEduaction;
import com.health.mongo.entity.DocProfession;
import com.health.mongo.entity.DoctorInfo;
import com.health.mongo.entity.FifthProgramLevelInfo;
import com.health.mongo.entity.FirstLevelInfo;
import com.health.mongo.entity.FourthLevelInfo;
import com.health.mongo.entity.HospitalInfo;
import com.health.mongo.entity.SecondLevelInfo;
import com.health.mongo.entity.SpecialityInfo;
import com.health.mongo.entity.ThirdLevelInfo;

public class Test {

	public static void main(String[] args) {
		//createLevel2(); //2
		//createLevel3(); //3
		//createLevel4();//4
		//createLevel5();
		//createHospitalInfo();
		//creatSpeciality();
		//createDoc();=
		//createEductionInfo();
		createProfessionalInfo();
		//System.out.println(new FirstLevelInfoDao().getFirstLevelByType("Men").getGender());
	}
	public static void createProfessionalInfo(){
		
		/*DocProfession r=new DocProfession();
		r.setDocId("7bbd9009-7b8b-45b6-817c-0e4c022ba04d");
		r.setFrom(new Date());
		r.setHospitalId("3fa1e8e8-820b-4a8f-8436-a25a77d9837a");
		r.setId(UUID.randomUUID().toString());
		r.setTill(new Date());
		new DocProfessionInfoDao().create(r);*/
		

		DocProfession p=new DocProfession();
		p.setDocId("aabdaad4-926c-4c3e-ad1f-2a2a16a140a5");
		p.setFrom(new Date());
		p.setHospitalId("3fa1e8e8-820b-4a8f-8436-a25a77d9837a");
		p.setId(UUID.randomUUID().toString());
		p.setTill(new Date());
		new DocProfessionInfoDao().create(p);
	}
	
	public static void createEductionInfo(){
		/*DocEduaction f=new DocEduaction();
		f.setId(UUID.randomUUID().toString());
		f.setDocId("7bbd9009-7b8b-45b6-817c-0e4c022ba04d");
		f.setFrom(new Date());
		f.setName("MD");
		f.setSpecialization("Eye");
		f.setTo(new Date());
		new DocEduacationInfoDao().create(f);*/
		DocEduaction g=new DocEduaction();
		g.setId(UUID.randomUUID().toString());
		g.setDocId("7bbd9009-7b8b-45b6-817c-0e4c022ba04d");
		g.setFrom(new Date());
		g.setName("MBBS");
		g.setSpecialization("General");
		g.setTo(new Date());
		new DocEduacationInfoDao().create(g);
		DocEduaction e=new DocEduaction();
		e.setId(UUID.randomUUID().toString());
		e.setDocId("aabdaad4-926c-4c3e-ad1f-2a2a16a140a5");
		e.setFrom(new Date());
		e.setName("MDS");
		e.setSpecialization("Dental");
		e.setTo(new Date());
		new DocEduacationInfoDao().create(e);
	}
	public static void createDoc(){
		DoctorInfo info=new DoctorInfo();
		info.setCity("Bangalore");
		info.setId(UUID.randomUUID().toString());
		info.setImage("");
		info.setName("Suresh");
		info.setPhone("909034332");
		info.setSpeciality("Dental");
		new DoctorInfoDao().create(info);
	}
	public static void creatSpeciality(){
		SpecialityInfo info=new SpecialityInfo();
		info.setId(UUID.randomUUID().toString());
		info.setName("Dental");
		new SpecialityInfoDao().create(info);
		SpecialityInfo info1=new SpecialityInfo();
		info1.setId(UUID.randomUUID().toString());
		info1.setName("Eye");
		new SpecialityInfoDao().create(info1);
		
	}
	public static void createHospitalInfo(){
		HospitalInfo info=new HospitalInfo();
		info.setAddress("malya address");
		info.setCity("Bangalore");
		info.setId(UUID.randomUUID().toString());
		info.setImage("");
		info.setName("Malya Hospital");
		info.setType("Normal");
		new HospitalInfoDao().create(info);
	}
	public static void createLevel5(){
		
		FifthProgramLevelInfo f1=new FifthProgramLevelInfo();
		f1.setDiet("Diet 1");
		f1.setExcise("Excise 1");
		f1.setId(UUID.randomUUID().toString());
		f1.setLifeStyle("Life Style 1");
		f1.setProgramName("Program 1");
		DBConnection.INSTANCE.getMongoTemplate().save(f1);
		
		FifthProgramLevelInfo f2=new FifthProgramLevelInfo();
		f2.setDiet("Diet 2");
		f2.setExcise("Excise 2");
		f2.setId(UUID.randomUUID().toString());
		f2.setLifeStyle("Life Style 2");
		f2.setProgramName("Program 2");
		DBConnection.INSTANCE.getMongoTemplate().save(f2);
		
		FifthProgramLevelInfo f3=new FifthProgramLevelInfo();
		f3.setDiet("Diet 3");
		f3.setExcise("Excise 3");
		f3.setId(UUID.randomUUID().toString());
		f3.setLifeStyle("Life Style 3");
		f3.setProgramName("Program 3");
		DBConnection.INSTANCE.getMongoTemplate().save(f3);
		
	}
	public static void createLevel4(){
		FourthLevelInfo info=new FourthLevelInfo();
		info.setId(UUID.randomUUID().toString());
		info.setType("Weight Gain");
		DBConnection.INSTANCE.getMongoTemplate().save(info);
		
		FourthLevelInfo info2=new FourthLevelInfo();
		info2.setId(UUID.randomUUID().toString());
		info2.setType("Weight Loss");
		DBConnection.INSTANCE.getMongoTemplate().save(info2);
		
		
	}
	
	public static void createLevel3(){
		ThirdLevelInfo info=new ThirdLevelInfo();
		info.setId(UUID.randomUUID().toString());
		info.setType("Nutrition");
		DBConnection.INSTANCE.getMongoTemplate().save(info);
		
		ThirdLevelInfo info2=new ThirdLevelInfo();
		info2.setId(UUID.randomUUID().toString());
		info2.setType("Excise");
		DBConnection.INSTANCE.getMongoTemplate().save(info2);
		
		ThirdLevelInfo info3=new ThirdLevelInfo();
		info3.setId(UUID.randomUUID().toString());
		info3.setType("Life Style");
		DBConnection.INSTANCE.getMongoTemplate().save(info3);
		
	}
	public static void createLevel2(){
		SecondLevelInfo sl=new SecondLevelInfo();
		sl.setId(UUID.randomUUID().toString());
		sl.setType("Type 1");
		DBConnection.INSTANCE.getMongoTemplate().save(sl);
		
		SecondLevelInfo sl2=new SecondLevelInfo();
		sl2.setId(UUID.randomUUID().toString());
		sl2.setType("Type 2");
		DBConnection.INSTANCE.getMongoTemplate().save(sl2);
		
		SecondLevelInfo sl3=new SecondLevelInfo();
		sl3.setId(UUID.randomUUID().toString());
		sl3.setType("Type 3");
		DBConnection.INSTANCE.getMongoTemplate().save(sl3);
	}
	public static void createLevel1(){
		FirstLevelInfo info=new FirstLevelInfo();
		info.setGender("Men");
		info.setId(UUID.randomUUID().toString());
		DBConnection.INSTANCE.getMongoTemplate().save(info);
		
		FirstLevelInfo info2=new FirstLevelInfo();
		info2.setGender("Women");
		info2.setId(UUID.randomUUID().toString());
		DBConnection.INSTANCE.getMongoTemplate().save(info2);
		
	}
}
