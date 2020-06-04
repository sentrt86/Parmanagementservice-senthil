package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.Location;

@SuppressWarnings("rawtypes")
public class LocationMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		final Location location = new Location();
		
		location.setLocationId(rs.getInt("PAR_LOC_ID"));
		location.setLocationName(rs.getString("PAR_LOC_NAME"));
		location.setLocationActive(rs.getBoolean("PAR_LOC_ACTIVE"));
		return location;
	}

}
