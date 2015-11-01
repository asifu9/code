package com.health.mongo.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.health.mongo.dao.DoctorInfoDao;
import com.health.mongo.dao.FifthProgramLevelInfoDao;
import com.health.mongo.dao.FirstLevelInfoDao;
import com.health.mongo.dao.FourthLevelInfoDao;
import com.health.mongo.dao.HospitalInfoDao;
import com.health.mongo.dao.SecondLevelInfoDao;
import com.health.mongo.dao.ThirdLevelInfoDao;
import com.health.mongo.entity.DoctorInfo;
import com.health.mongo.entity.FifthProgramLevelInfo;
import com.health.mongo.entity.FirstLevelInfo;
import com.health.mongo.entity.FourthLevelInfo;
import com.health.mongo.entity.HospitalInfo;
import com.health.mongo.entity.SecondLevelInfo;
import com.health.mongo.entity.ThirdLevelInfo;


@Path("/hospital")
public class HospitalService {

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDocInfo() {
		List<HospitalInfo> list=new ArrayList<HospitalInfo>();
		try {
			list=new HospitalInfoDao().getAllHospitalInfo();
			System.out.println("list is  "+list.size());
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("\"status\":\"ERROR\"").build();
		}
		return Response.status(Status.OK).entity(list).build();
	}
	
}
