package com.htc.par.model;

import java.io.Serializable;

public class Location implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -625494452662231089L;
	private int locationId;
	private String locationName;
	private Boolean locationActive;
	
	public Location() {
		super();
	}

	public Location(int locationId, String locationName, Boolean locationActive) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationActive = locationActive;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Boolean getLocationActive() {
		return locationActive;
	}

	public void setLocationActive(Boolean locationActive) {
		this.locationActive = locationActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationActive == null) ? 0 : locationActive.hashCode());
		result = prime * result + locationId;
		result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (locationActive == null) {
			if (other.locationActive != null)
				return false;
		} else if (!locationActive.equals(other.locationActive))
			return false;
		if (locationId != other.locationId)
			return false;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", locationActive="
				+ locationActive + "]";
	}
	
	
	
	

}
