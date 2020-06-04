package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.htc.par.data.dao.IPrescreenerDao;
import com.htc.par.data.mapper.PrescreenerMapper;
import com.htc.par.model.Prescreener;

@Repository
public class PrescreenerDAOImpl implements IPrescreenerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Get all Prescreeners
	@SuppressWarnings("unchecked")
	@Override
	public List<Prescreener> getAllPrescreeners() {
		List<Prescreener> prescreeners = new ArrayList<Prescreener>();
		prescreeners = jdbcTemplate.query(ParSqlQueries.getAllPrescreenerSql, new Object[] {}, new PrescreenerMapper());
		System.out.println("prescreeners rows"+prescreeners.size());
		return prescreeners;
	}

	@Override
	public boolean addPrescreener(Prescreener prescreener) {
		boolean prescreenerAdded = false;
		System.out.println("Add method of prescreener");
		System.out.println(prescreener);
		Object[] parms = new Object[] {prescreener.getPreScreenerId(),prescreener.getPreScreenerName(),prescreener.getPreScreenerEmailId(),prescreener.getPreScreenercontactNo(),prescreener.getPreScreenerActive()};
		int[] parmsType = new int[] {Types.INTEGER,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.BOOLEAN};
		int AddCount = jdbcTemplate.update(ParSqlQueries.addPrescreenerSql,parms,parmsType);
		if (AddCount > 0)
		{
			prescreenerAdded = true;
		}
		System.out.println("presscreener added :"+prescreenerAdded);
		return prescreenerAdded;
	}

	@Override
	public boolean updatePrescreener(Prescreener prescreener) {
		boolean prescreenerUpdated = false;
		System.out.println("update method of prescreener");
		System.out.println(prescreener);
		Object[] parms = new Object[] {prescreener.getPreScreenerName(),prescreener.getPreScreenerEmailId(),prescreener.getPreScreenercontactNo(),prescreener.getPreScreenerActive(),prescreener.getPreScreenerId()};
		int[] parmsType = new int[] {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.BOOLEAN,Types.INTEGER};
		int AddCount = jdbcTemplate.update(ParSqlQueries.updatePrescreenerSql,parms,parmsType);
		if (AddCount > 0)
		{
			prescreenerUpdated = true;
		}
		return prescreenerUpdated;
	}

	@Override
	public boolean deletePrescreener(int prescreenerId) {
		System.out.println("delete method in DAOIMPL"+prescreenerId);
		boolean prescreenerDeleted = false;
		System.out.println("delete method of prescreener");
		System.out.println(prescreenerId);
		Object[] parms = new Object[] {prescreenerId};
		int[] parmsType = new int[] {Types.INTEGER};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deletePrescreenerSql,parms,parmsType);
		if (deleteCount > 0)
		{
			prescreenerDeleted = true;
		}
		return prescreenerDeleted;
	}

	@Override
	public int getnextPrescreenerId() {
		return jdbcTemplate.queryForObject(ParSqlQueries.getNextPrescreenerId,new Object[] {},Integer.class);
	}

}
