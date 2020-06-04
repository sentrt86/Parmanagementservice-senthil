package com.htc.par.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.htc.par.constants.ParConstants;
import com.htc.par.data.daoimpl.PrescreenerDAOImpl;
import com.htc.par.exceptions.ResourceAccessException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Prescreener;
import com.htc.par.to.PrescreenerTO;

@Service
public class PrescreenerServiceImpl implements IPrescreenerService {
	
	@Autowired
	PrescreenerDAOImpl prescreenerDAOIMPL;

	
	// Get all the Prescreeners
	@Override
	public List<Prescreener> getAllPrescreeners() throws ResourceNotFoundException {
		List<Prescreener> prescreenerlist = new ArrayList<Prescreener> ();		
		try {
			prescreenerlist = prescreenerDAOIMPL.getAllPrescreeners();		
		}catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(ParConstants.dataNotFound);

		}catch(DataAccessException ex){
			throw new ResourceAccessException(ParConstants.databaseAccessIssue);			
		}

		return prescreenerlist;
	}

	//delete the given prescreener ID
	@Override
	public String deletePrescreener(int prescreenerId) throws ResourceNotFoundException {
		try { 
			System.out.println("delete method in second service"+prescreenerId);
			boolean prescreenerDeleted = prescreenerDAOIMPL.deletePrescreener(prescreenerId); 
			if(prescreenerDeleted) { 
				System.out.println(String.format(ParConstants.deleteSuccessfull + "for Prescreener Id:" + Integer.toString(prescreenerId)));
				return String.format(ParConstants.deleteSuccessfull + "for Prescreener Id:" + Integer.toString(prescreenerId)); 
				}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.deleteUnSuccessfull + "for Prescreener Id : " +Integer.toString(prescreenerId))); 
		} 
		return String.format(ParConstants.deleteUnSuccessfull + "for Prescreener Id : "+Integer.toString(prescreenerId)); 
	}

	@Override
	public String addPrescreener(PrescreenerTO preScreenerTO) throws ResourceNotCreatedException {
		try { 
			boolean prescreenerAdded = prescreenerDAOIMPL.addPrescreener(new Prescreener(preScreenerTO.getPreScreenerId(),preScreenerTO.getPreScreenerName(),preScreenerTO.getPreScreenerEmailId(),preScreenerTO.getPreScreenercontactNo(),preScreenerTO.getPreScreenerActive())); 
			if(prescreenerAdded) { 
				System.out.println(String.format(ParConstants.createSuccessfull + "for Prescreener Id :" + Integer.toString(preScreenerTO.getPreScreenerId()) +" and Prescreener Name: "+ preScreenerTO.getPreScreenerName()) );
				return String.format(ParConstants.createSuccessfull + "for Prescreener Id :" + Integer.toString(preScreenerTO.getPreScreenerId()) +" and Prescreener Name: "+ preScreenerTO.getPreScreenerName() );
			
				}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.createUnSuccessfull + "for Prescreener Id :" + Integer.toString(preScreenerTO.getPreScreenerId()) +" and Prescreener Name: " + preScreenerTO.getPreScreenerName()));
		} 
		return String.format(ParConstants.createUnSuccessfull + "for Prescreener Id :" + Integer.toString(preScreenerTO.getPreScreenerId()) +" and Prescreener Name: "+ preScreenerTO.getPreScreenerName() ); 
	
	}

	@Override
	public String updatePrescreener(PrescreenerTO preScreenerTO)
			throws ResourceNotCreatedException, ResourceNotUpdatedException {
		try { 
			System.out.println("Second service update method");
			boolean prescreenerUpdated = prescreenerDAOIMPL.updatePrescreener(new Prescreener(preScreenerTO.getPreScreenerId(),preScreenerTO.getPreScreenerName(),preScreenerTO.getPreScreenerEmailId(),preScreenerTO.getPreScreenercontactNo(),preScreenerTO.getPreScreenerActive()));
			System.out.println("after call of  DAO impl");
			if(prescreenerUpdated) {
				System.out.println(String.format(ParConstants.updateSuccessfull + "for Prescreener Id :" + Integer.toString(preScreenerTO.getPreScreenerId())) +" and Prescreener Name: "+ preScreenerTO.getPreScreenerName());
				return String.format(ParConstants.updateSuccessfull + "for Prescreener Id :" + Integer.toString(preScreenerTO.getPreScreenerId()) +" and Prescreener Name: "+ preScreenerTO.getPreScreenerName()); 
				}
		}catch(DataAccessException ex) { 
			throw new ResourceNotDeletedException(String.format(ParConstants.updateUnSuccessfull + "for Prescreener Id :" + Integer.toString(preScreenerTO.getPreScreenerId()) +" and Prescreener Name: " + preScreenerTO.getPreScreenerName()));
		} 
		return String.format(ParConstants.updateUnSuccessfull + "for Prescreener Id :" + Integer.toString(preScreenerTO.getPreScreenerId()) +" and Prescreener Name: "+ preScreenerTO.getPreScreenerName() ); 
	}

	@Override
	public int getNextPrescreenerId() throws ResourceNotFoundException {
		try {
			return prescreenerDAOIMPL.getnextPrescreenerId(); 		
		}catch(DataAccessException ex){ 
			throw new ResourceAccessException(ParConstants.databaseAccessIssue); }

	}
	

}
