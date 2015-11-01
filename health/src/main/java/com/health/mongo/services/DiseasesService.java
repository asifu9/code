package com.health.mongo.services;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.health.mongo.dao.disease.CausesAndRiskFactorsDao;
import com.health.mongo.dao.disease.DiagnosisAndTestsDao;
import com.health.mongo.dao.disease.DiseaseDao;
import com.health.mongo.dao.disease.PreventionDao;
import com.health.mongo.dao.disease.SymptomsDetailsDao;
import com.health.mongo.dao.disease.TreatmentDao;
import com.health.mongo.entity.disease.CausesAndRiskFactors;
import com.health.mongo.entity.disease.DiagnosisAndTests;
import com.health.mongo.entity.disease.DiseaseDetails;
import com.health.mongo.entity.disease.Prevention;
import com.health.mongo.entity.disease.SymptomsDetails;
import com.health.mongo.entity.disease.Treatment;


@Path("/disease")
public class DiseasesService {

	@POST
	@Path("/disease")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createDisease(DiseaseDetails disease) {
		try {
			System.out.println("hhhh");
			DiseaseDao d=new DiseaseDao();
			disease.setId(UUID.randomUUID().toString());
			d.create(disease);
			System.out.println("created successfully");
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("\"status\":\"ERROR\"").build();
		}
		return Response.status(Status.OK).entity(disease).build();
	}
	
	@POST
	@Path("/treatment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTreatment(Treatment treatement) {
		try {
			System.out.println("hhhh");
			new TreatmentDao().create(treatement);
			System.out.println("created successfully");
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("\"status\":\"ERROR\"").build();
		}
		return Response.status(Status.OK).entity(treatement).build();
	}
	
	@POST
	@Path("/causeAndRisk")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCauseAndRisk(CausesAndRiskFactors cAndr) {
		try {
			System.out.println("hhhh");
			new CausesAndRiskFactorsDao().create(cAndr);
			System.out.println("created successfully");
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("\"status\":\"ERROR\"").build();
		}
		return Response.status(Status.OK).entity(cAndr).build();
	}
	
	@POST
	@Path("/DiagnosisAndTest")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createDandTest(DiagnosisAndTests dAndt) {
		try {
			System.out.println("hhhh");
			new DiagnosisAndTestsDao().create(dAndt);
			System.out.println("created successfully");
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("\"status\":\"ERROR\"").build();
		}
		return Response.status(Status.OK).entity(dAndt).build();
	}
	
	@POST
	@Path("/Prevention")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPrevention(Prevention prevent) {
		try {
			System.out.println("hhhh");
			new PreventionDao().create(prevent);
			System.out.println("created successfully");
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("\"status\":\"ERROR\"").build();
		}
		return Response.status(Status.OK).entity(prevent).build();
	}
	
	@POST
	@Path("/Symptoms")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createSymptoms(SymptomsDetails symps) {
		try {
			System.out.println("hhhh");
			new SymptomsDetailsDao().create(symps);
			System.out.println("created successfully");
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("\"status\":\"ERROR\"").build();
		}
		return Response.status(Status.OK).entity(symps).build();
	}
}