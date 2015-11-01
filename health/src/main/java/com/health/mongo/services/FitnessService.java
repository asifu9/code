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

import com.health.mongo.dao.FifthProgramLevelInfoDao;
import com.health.mongo.dao.FirstLevelInfoDao;
import com.health.mongo.dao.FourthLevelInfoDao;
import com.health.mongo.dao.SecondLevelInfoDao;
import com.health.mongo.dao.ThirdLevelInfoDao;
import com.health.mongo.entity.FifthProgramLevelInfo;
import com.health.mongo.entity.FirstLevelInfo;
import com.health.mongo.entity.FourthLevelInfo;
import com.health.mongo.entity.SecondLevelInfo;
import com.health.mongo.entity.ThirdLevelInfo;


@Path("/fitness")
public class FitnessService {

	@GET
	@Path("/firstlevel")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTriggerDistributionJob() {
		List<FirstLevelInfo> list=new ArrayList<FirstLevelInfo>();
		try {
			FirstLevelInfoDao info=new FirstLevelInfoDao();
			list=info.getAllFirstLevelInfo();
			System.out.println("list is  "+list.size());
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("\"status\":\"ERROR\"").build();
		}
		return Response.status(Status.OK).entity(list).build();
	}
	
	@GET
	@Path("/level1/{param1}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFitnessLevel1(@PathParam("param1") String type) {
		FirstLevelInfo level1=new FirstLevelInfo();
		try {
			level1= new FirstLevelInfoDao().getFirstLevelByType(type);
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return Response.status(Status.OK).entity(level1).build();
	}
	
	@GET
	@Path("/secondLevel/{base}/{gender}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLevel2Info(@PathParam("base") String base,@PathParam("gender") String gender) {
		List<SecondLevelInfo> list=new ArrayList<SecondLevelInfo>();
		try {
			SecondLevelInfoDao info=new SecondLevelInfoDao();
			list = info.getAllByBaseAndGender(gender, base);
			System.out.println("list is  "+list.size());
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("\"status\":\"ERROR\"").build();
		}
		return Response.status(Status.OK).entity(list).build();
	}
	
	@GET
	@Path("/fourthLevel")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLevelFourth() {
		List<FourthLevelInfo> list=new ArrayList<FourthLevelInfo>();
		try {
			FourthLevelInfoDao info=new FourthLevelInfoDao();
			list = info.getAllInfo();
			System.out.println("list is  "+list.size());
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("\"status\":\"ERROR\"").build();
		}
		return Response.status(Status.OK).entity(list).build();
	}
	
	@GET
	@Path("/fifthLevel/{base}/{gender}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFifthLevelData(@PathParam("base") String base,@PathParam("gender") String gender) {
		List<FifthProgramLevelInfo> list=new ArrayList<FifthProgramLevelInfo>();
		try {
			FifthProgramLevelInfoDao info=new FifthProgramLevelInfoDao();
			list = info.getAllByBaseAndGender(base,gender);
			System.out.println("list is  "+list.size());
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("\"status\":\"ERROR\"").build();
		}
		return Response.status(Status.OK).entity(list).build();
	}
	
	@GET
	@Path("/thirdLevel/{gender}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLevel2Info(@PathParam("gender") String gender) {
		List<ThirdLevelInfo> list=new ArrayList<ThirdLevelInfo>();
		try {
			ThirdLevelInfoDao info=new ThirdLevelInfoDao();
			list = info.getAllByGender(gender);
			System.out.println("list is  "+list.size());
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("\"status\":\"ERROR\"").build();
		}
		return Response.status(Status.OK).entity(list).build();
	}
	

}
