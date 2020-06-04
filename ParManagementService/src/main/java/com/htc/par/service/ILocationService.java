package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Location;
import com.htc.par.to.LocationTO;

@Service
public interface ILocationService {

	public List<Location>  getAllLocations() throws ResourceNotFoundException;
	public int getNextLocationId() throws ResourceNotFoundException;
	public String deleteLocation(int locationId) throws ResourceNotFoundException;
	public String addLocation(LocationTO locationTO) throws ResourceNotCreatedException;
	public String updateLocation(LocationTO locationTO) throws ResourceNotCreatedException, ResourceNotUpdatedException;
	
	
}
