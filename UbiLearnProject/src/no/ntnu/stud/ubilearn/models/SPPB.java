package no.ntnu.stud.ubilearn.models;

import java.util.ArrayList;
import java.util.Date;

public abstract class SPPB {
	protected String objectId;
	protected int id;
	protected String name;
	protected Patient patient;
	protected int patientId;
	protected Date createdAt;
	protected boolean failed = false;

	
	public SPPB(String objectId, String name, Patient patient, Date createdAt) {
		super();
		this.objectId = objectId;
		this.name = name;
		this.patient = patient;
		this.patientId = patient.getId();
		this.createdAt = createdAt;
	}

	public SPPB(String objectId, String name, String patientId, Date createdAt) {
		super();
		this.objectId = objectId;
		this.name = name;
//		this.patientId = patientId;
		this.createdAt = createdAt;
	}
	public SPPB(int id, String name, int patientId, Date createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.patientId = patientId;
		this.createdAt = createdAt;
	}
	public SPPB(int id, String name, int patientId, Date createdAt, boolean failed) {
		super();
		this.id = id;
		this.name = name;
		this.patientId = patientId;
		this.createdAt = createdAt;
		this.failed = failed;
	}
	public SPPB(String name, int patientId, Date createdAt) {
		super();
		this.name = name;
		this.patientId = patientId;
		this.createdAt = createdAt;
	}

	public abstract int getScore();

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Patient getPatient() {
		return patient;
	}
	public int getPatientId(){
		return patientId;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;		
	}
	/**
	 * Sets whether the patient failed to complete this test or not
	 * @param failed true if the patient failed the test
	 */
	public void failed(boolean failed){
		this.failed = failed;
	}
	/**
	 * Returns whether the patient failed to complete this test or not
	 * @return true if the patient failed, false if he finished succesfully
	 */
	public boolean failed() {
		return failed;
	}
	
}
