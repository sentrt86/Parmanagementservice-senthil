package com.htc.par.data.dao;

import java.util.List;
import com.htc.par.model.Prescreener;

public interface IPrescreenerDao {
	List<Prescreener> getAllPrescreeners();
	int getnextPrescreenerId();
	boolean addPrescreener(Prescreener prescreener);
	boolean updatePrescreener(Prescreener prescreener);
	boolean deletePrescreener(int  prescreenerId);
	

}
