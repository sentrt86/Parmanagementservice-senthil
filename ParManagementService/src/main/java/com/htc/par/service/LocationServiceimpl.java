package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.LocationDaoImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Location;
import com.htc.par.to.LocationTO;

@Service
public class LocationServiceimpl implements ILocationService {
	@Autowired LocationDaoImpl locationDaoImpl;

	@Override
	public List<Location> getAllLocations() throws ResourceNotFoundException {
		List<Location> locations = new ArrayList<Location> ();		
		try {
			locations = locationDaoImpl.getALLLocations();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return locations;
	}

	@Override
	public int getNextLocationId() throws ResourceNotFoundException {
		try {
			return locationDaoImpl.getnextLocationId(); 		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);
		}

		
	}

	@Override
	public String deleteLocation(int locationId) throws ResourceNotFoundException {
		try { 
			System.out.println("delete method in second service"+locationId);
			boolean locationDeleted = locationDaoImpl.deleteLocation(locationId); 
			if(locationDeleted) { 
				System.out.println("Tst deleted  displays in second service");
				System.out.println(String.format(ParConstants.deleteSuccessfull + "for Location Id: " + Integer.toString(locationId)));
				return String.format(ParConstants.deleteSuccessfull + "for Location Id:" + Integer.toString(locationId)); 
				}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.deleteUnSuccessfull + "for Location Id: " + Integer.toString(locationId))); 
		} 
		return String.format(ParConstants.deleteUnSuccessfull + "for Location Id : "+Integer.toString(locationId)); 	
	}
	
	@Override
	public String addLocation(LocationTO locationTO) throws ResourceNotCreatedException {
		try { 
			boolean locationAdded = locationDaoImpl.addLocation(new Location(locationTO.getLocationId(),locationTO.getLocationName(),locationTO.getLocationActive())); 
			if(locationAdded) { 
				System.out.println(String.format(ParConstants.createSuccessfull + "for Location Id :" + Integer.toString(locationTO.getLocationId()) +" and Location Name: "+ locationTO.getLocationName()));
				return String.format(ParConstants.createSuccessfull + "for Location Id :" + Integer.toString(locationTO.getLocationId()) +" and Location Name: "+ locationTO.getLocationName() );
			
				}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.createUnSuccessfull + "for Location Id :" + Integer.toString(locationTO.getLocationId()) +" and Location Name: "+ locationTO.getLocationName()));
		} 
		return String.format(ParConstants.createUnSuccessfull + "for Location Id :" + Integer.toString(locationTO.getLocationId()) +" and Location Name: "+ locationTO.getLocationName() ); 
	
	}

	@Override
	public String updateLocation(LocationTO locationTO)
			throws ResourceNotCreatedException, ResourceNotUpdatedException {
		try { 
			System.out.println("Second service update method");
			boolean locationUpdated = locationDaoImpl.updateLocation(new Location(locationTO.getLocationId(),locationTO.getLocationName(),locationTO.getLocationActive())); 
			System.out.println("after call of  DAO impl");
			if(locationUpdated) {
				System.out.println(String.format(ParConstants.updateSuccessfull + "for Location Id :" + Integer.toString(locationTO.getLocationId()) +" and Location Name: "+ locationTO.getLocationName()));
				return String.format(ParConstants.updateSuccessfull + "for Location Id :" + Integer.toString(locationTO.getLocationId()) +" and Location Name: "+ locationTO.getLocationName()); 
				}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.updateUnSuccessfull + "for Location Id :" + Integer.toString(locationTO.getLocationId()) +" and Location Name: "+ locationTO.getLocationName()));
		} 
		return String.format(ParConstants.updateUnSuccessfull + "for Location Id :" + Integer.toString(locationTO.getLocationId()) +" and Location Name: "+ locationTO.getLocationName() ); 
	}
	}


