package com.htc.par.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Location;
import com.htc.par.service.LocationServiceimpl;
import com.htc.par.to.LocationTO;

@RestController
@RequestMapping("/parmanagement/location")
public class LocationController {
	
	@Autowired
	LocationServiceimpl locationServiceimpl;
	
	/*
	 * Request handler to get all the prescreeners
	 * 
	 * @ResoruceNotFoundException
	 */
	
	@RequestMapping(value="/getLocations",method=RequestMethod.GET)
	public ResponseEntity<List<Location>> getAllLocations() throws ResourceNotFoundException{
		System.out.println("second controller method invoked");
		return new ResponseEntity<List<Location>>(locationServiceimpl.getAllLocations(),HttpStatus.OK);		
	}
	
	
	
	@RequestMapping(value="/getNextLocationId",method=RequestMethod.GET)
	public ResponseEntity<Integer> getNextPrescreenerId() throws ResourceAccessException{
		System.out.println("Get next PrescreenerID method:");
		return new ResponseEntity<Integer>(locationServiceimpl.getNextLocationId(),HttpStatus.OK);
	}
	
	/*
	 * Request handler to delete a Prescreener by id
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/deleteLocation/{locationId}",method=RequestMethod.POST)
	public ResponseEntity<String> deleteLocation(@PathVariable("locationId") int locationId) throws ResourceNotFoundException{
		System.out.println("delete method in second controller"+locationId);
		return new  ResponseEntity<String>(locationServiceimpl.deleteLocation(locationId),HttpStatus.OK);
	}
	
	/*
	 * Request handler to update a Prescreener by Prescreener UI values
	 * 
	 * @ResourceNotFoundException
	 * @ResourceNotUpdatedException
	 */
	
	@RequestMapping(value="/updateLocation",method=RequestMethod.POST)
	public ResponseEntity<String> updatePrescreener(@RequestBody @Valid LocationTO locationTO) throws ResourceNotFoundException,ResourceNotUpdatedException{
		System.out.println("Second controller Update method");
		return new  ResponseEntity<String>(locationServiceimpl.updateLocation(locationTO),HttpStatus.OK);
	}
	
	/*
	 * Request handler to Add a preScreener
	 * 
	 * @ResourceNotFoundException
	 */
	
	@RequestMapping(value="/addLocation",method=RequestMethod.POST)
	public ResponseEntity<String> createArea(@RequestBody @Valid LocationTO locationTO) throws ResourceNotCreatedException{
		System.out.println(locationTO);	
		return new  ResponseEntity<String>(locationServiceimpl.addLocation(locationTO),HttpStatus.OK);
	}


}
