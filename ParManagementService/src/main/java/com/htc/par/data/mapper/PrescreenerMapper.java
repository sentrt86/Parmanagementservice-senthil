package com.htc.par.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htc.par.model.Prescreener;

@SuppressWarnings("rawtypes")
public class PrescreenerMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		final Prescreener prescreener = new Prescreener();
		
		prescreener.setPreScreenerId(rs.getInt("PRE_SCR_ID"));
		prescreener.setPreScreenerName(rs.getString("PRE_SCR_NM"));
		prescreener.setPreScreenerEmailId(rs.getString("PRE_SCR_EMAIL"));
		prescreener.setPreScreenercontactNo(rs.getString("PRE_SCR_PHN_NUM"));
		prescreener.setPreScreenerActive(rs.getBoolean("PRE_SCR_ACTIVE"));
				
		
		return prescreener;
	}

}
