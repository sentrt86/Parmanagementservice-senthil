package com.htc.par.data.dao;

import java.util.List;

import com.htc.par.model.Location;

public interface ILocationDao {
	
	List<Location> getALLLocations();
	int getnextLocationId();
	boolean addLocation(Location location);
	boolean updateLocation(Location location);
	boolean deleteLocation(int  locationId);
	
	

}
