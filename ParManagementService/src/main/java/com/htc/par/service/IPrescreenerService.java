package com.htc.par.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.model.Prescreener;
import com.htc.par.to.PrescreenerTO;

@Service
public interface IPrescreenerService {
	
	public List<Prescreener>  getAllPrescreeners() throws ResourceNotFoundException;
	public int getNextPrescreenerId() throws ResourceNotFoundException;
	public String deletePrescreener(int prescreenerId) throws ResourceNotFoundException;
	public String addPrescreener(PrescreenerTO preScreenerTO) throws ResourceNotCreatedException;
	public String updatePrescreener(PrescreenerTO preScreenerTO) throws ResourceNotCreatedException, ResourceNotUpdatedException;
	

}
