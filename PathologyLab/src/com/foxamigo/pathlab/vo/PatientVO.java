package com.foxamigo.pathlab.vo;


public class PatientVO {
	private long patientId;
	private String patientAddlId;
	private String patientFname;
	private String patientMname;
	private String patientLname;
	private int patientAge;
	private String patientEmail;
	private String patientPhone;
	private String patientRefDoctor;
	private int testType;
	private int testSubType;
	private long doctorId;
	
	
	public String getPatientAddlId() {
		return patientAddlId;
	}
	public void setPatientAddlId(String patientAddlId) {
		this.patientAddlId = patientAddlId;
	}
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getPatientFname() {
		return patientFname;
	}
	public void setPatientFname(String patientFname) {
		this.patientFname = patientFname;
	}
	public String getPatientMname() {
		return patientMname;
	}
	public void setPatientMname(String patientMname) {
		this.patientMname = patientMname;
	}
	public String getPatientLname() {
		return patientLname;
	}
	public void setPatientLname(String patientLname) {
		this.patientLname = patientLname;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	public String getPatientRefDoctor() {
		return patientRefDoctor;
	}
	public void setPatientRefDoctor(String patientRefDoctor) {
		this.patientRefDoctor = patientRefDoctor;
	}
	public int getTestType() {
		return testType;
	}
	public void setTestType(int testType) {
		this.testType = testType;
	}
	public int getTestSubType() {
		return testSubType;
	}
	public void setTestSubType(int testSubType) {
		this.testSubType = testSubType;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public long getDoctorId() {
		return doctorId;
	}
	
}
