package com.htc.par.to;

import java.io.Serializable;

public class PrescreenerTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1479022528557635406L;
	private int preScreenerId;
	private String preScreenerName;
	private String preScreenerEmailId;
	private String preScreenercontactNo;
	private Boolean preScreenerActive;
	public int getPreScreenerId() {
		return preScreenerId;
	}
	public void setPreScreenerId(int preScreenerId) {
		this.preScreenerId = preScreenerId;
	}
	public String getPreScreenerName() {
		return preScreenerName;
	}
	public void setPreScreenerName(String preScreenerName) {
		this.preScreenerName = preScreenerName;
	}
	public String getPreScreenerEmailId() {
		return preScreenerEmailId;
	}
	public void setPreScreenerEmailId(String preScreenerEmailId) {
		this.preScreenerEmailId = preScreenerEmailId;
	}
	public String getPreScreenercontactNo() {
		return preScreenercontactNo;
	}
	public void setPreScreenercontactNo(String preScreenercontactNo) {
		this.preScreenercontactNo = preScreenercontactNo;
	}
	public Boolean getPreScreenerActive() {
		return preScreenerActive;
	}
	public void setPreScreenerActive(Boolean preScreenerActive) {
		this.preScreenerActive = preScreenerActive;
	}
	
		
	
	
	
	

}
