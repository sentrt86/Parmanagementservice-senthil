package com.htc.par.data.daoimpl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.htc.par.data.dao.ILocationDao;
import com.htc.par.data.mapper.LocationMapper;
import com.htc.par.model.Location;


@Repository
public class LocationDaoImpl implements ILocationDao {
	@Autowired JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getALLLocations() {
		List<Location> locations = new ArrayList<Location>();
		locations = jdbcTemplate.query(ParSqlQueries.getAllLocationsSql, new Object[] {}, new LocationMapper());
		System.out.println("locations rows"+locations.size());
		return locations;
	}

	@Override
	public int getnextLocationId() {
		System.out.println(ParSqlQueries.getNextLocationId);
		return jdbcTemplate.queryForObject(ParSqlQueries.getNextLocationId,new Object[] {},Integer.class);
	}

	@Override
	public boolean addLocation(Location location) {
		boolean locationAdded = false;
		System.out.println("Add method of location");
		System.out.println(location);
		Object[] parms = new Object[] {location.getLocationId(),location.getLocationName(),location.getLocationActive()};
		int[] parmsType = new int[] {Types.INTEGER,Types.VARCHAR,Types.BOOLEAN};
		int AddCount = jdbcTemplate.update(ParSqlQueries.addLocationSql,parms,parmsType);
		if (AddCount > 0)
		{
			locationAdded = true;
		}
		System.out.println("location added :"+locationAdded);
		return locationAdded;
	}

	@Override
	public boolean updateLocation(Location location) {
		boolean locationUdpated = false;
		System.out.println("update method of location");
		System.out.println(location);
		Object[] parms = new Object[] {location.getLocationName(),location.getLocationActive(),location.getLocationId()};
		int[] parmsType = new int[] {Types.VARCHAR,Types.BOOLEAN,Types.INTEGER};
		int AddCount = jdbcTemplate.update(ParSqlQueries.updateLocationSql,parms,parmsType);
		
		if (AddCount > 0)
		{
			locationUdpated = true;
		}
		return locationUdpated;
	}

	@Override
	public boolean deleteLocation(int locationId) {
		System.out.println("delete method in DAOIMPL"+locationId);
		boolean locationDeleted = false;
		System.out.println("delete method of location");
		System.out.println(locationId);
		Object[] parms = new Object[] {locationId};
		int[] parmsType = new int[] {Types.INTEGER};
		int deleteCount = jdbcTemplate.update(ParSqlQueries.deleteLocationSql,parms,parmsType);
		System.out.println("Deletecount"+deleteCount);
		if (deleteCount > 0)
		{
			locationDeleted = true;
		}
		System.out.println("locationDeleted"+locationDeleted);
		return locationDeleted;	}

}
