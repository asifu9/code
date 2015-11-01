package com.health.mongo.entity;

import java.util.Date;

public class DocProfession {

	private String id;
	private String docId;
	private String hospitalId;
	private Date from;
	private Date till;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTill() {
		return till;
	}
	public void setTill(Date till) {
		this.till = till;
	}
	
}
