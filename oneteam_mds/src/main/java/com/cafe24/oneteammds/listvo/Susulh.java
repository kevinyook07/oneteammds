package com.cafe24.oneteammds.listvo;

public class Susulh {

	private String sbCode;
	private String hospitalId;
	private String patientId;
	private String sName;
	private String sCode;
	private String aKind;
	private String pDoctor;
	private String sdTime;
	private String adminId;
	private String sbDate;
	
	private String pName;

	public String getSbCode() {
		return sbCode;
	}

	public void setSbCode(String sbCode) {
		this.sbCode = sbCode;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}

	public String getaKind() {
		return aKind;
	}

	public void setaKind(String aKind) {
		this.aKind = aKind;
	}

	public String getpDoctor() {
		return pDoctor;
	}

	public void setpDoctor(String pDoctor) {
		this.pDoctor = pDoctor;
	}

	public String getSdTime() {
		return sdTime;
	}

	public void setSdTime(String sdTime) {
		this.sdTime = sdTime;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getSbDate() {
		return sbDate;
	}

	public void setSbDate(String sbDate) {
		this.sbDate = sbDate;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	@Override
	public String toString() {
		return "Susulh [sbCode=" + sbCode + ", hospitalId=" + hospitalId + ", patientId=" + patientId + ", sName="
				+ sName + ", sCode=" + sCode + ", aKind=" + aKind + ", pDoctor=" + pDoctor + ", sdTime=" + sdTime
				+ ", adminId=" + adminId + ", sbDate=" + sbDate + ", pName=" + pName + "]";
	}
	
}
