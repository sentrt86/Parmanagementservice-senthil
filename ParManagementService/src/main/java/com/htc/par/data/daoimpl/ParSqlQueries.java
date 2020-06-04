package com.htc.par.data.daoimpl;

import org.springframework.stereotype.Component;

@Component
public class ParSqlQueries {
	
	
	//  Area Queries
	public static String getAllAreasQuery = "SELECT AREA_ID,AREA_NM,AREA_ACTIVE FROM AREA_LKUP";
	public static String getAreaByIdQuery = "SELECT AREA_ID,AREA_NM,AREA_ACTIVE FROM AREA_LKUP WHERE AREA_ID = ?";
	public static String deleteArea       = "DELETE FROM AREA_LKUP WHERE AREA_ID = ?";
	public static String updateArea       = "UPDATE AREA_LKUP SET AREA_NM = ? , AREA_ACTIVE = ? WHERE AREA_ID = ?";
	public static String createArea       = "INSERT INTO AREA_LKUP (AREA_ID,AREA_NM,AREA_ACTIVE) VALUES(?,?,?)";
    public static String getactiveArea    = "SELECT AREA_ID,AREA_NM,AREA_ACTIVE FROM AREA_LKUP WHERE AREA_ACTIVE = true";
    public static String getNextAreaId    = "SELECT NEXTVAL('AREA_SEQ')";
    
	//  Skill Queries
	public static String getAllSkillQuery  = "SELECT SKILL_ID,SKILL_NM,SKILL_ACTIVE FROM SKILL_LKUP";
	public static String getSkillByIdQuery = "SELECT SKILL_ID,SKILL_NM,SKILL_ACTIVE FROM SKILL_LKUP WHERE SKILL_ID = ?";
	public static String deleteSkill       = "DELETE FROM SKILL_LKUP WHERE SKILL_ID = ?";
	public static String updateSkill       = "UPDATE SKILL_LKUP SET SKILL_NM = ? , SKILL_ACTIVE = ? WHERE SKILL_ID = ?";
	public static String createSkill       = "INSERT INTO SKILL_LKUP (SKILL_ID,SKILL_NM,SKILL_ACTIVE) VALUES(?,?,?)";
    public static String getactiveSkill    = "SELECT SKILL_ID,SKILL_NM,SKILL_ACTIVE FROM SKILL_LKUP WHERE SKILL_ACTIVE = true";
    public static String getNextSkillId    = "SELECT NEXTVAL('SKILL_SEQ')";
    
    // Prescreener Queries
    public static String getAllPrescreenerSql = "SELECT PRE_SCR_ID,PRE_SCR_NM,PRE_SCR_EMAIL,PRE_SCR_PHN_NUM,PRE_SCR_ACTIVE FROM PRE_SCREENER";
    public static String addPrescreenerSql = "INSERT INTO PRE_SCREENER (PRE_SCR_ID,PRE_SCR_NM,PRE_SCR_EMAIL,PRE_SCR_PHN_NUM,PRE_SCR_ACTIVE) VALUES(?,?,?,?,?)";
    public static String updatePrescreenerSql ="UPDATE PRE_SCREENER SET PRE_SCR_NM=?, PRE_SCR_EMAIL=?,PRE_SCR_PHN_NUM=?,PRE_SCR_ACTIVE=? WHERE PRE_SCR_ID=?";
    public static String deletePrescreenerSql = "DELETE FROM PRE_SCREENER WHERE PRE_SCR_ID = ?";
    public static String getNextPrescreenerId    = "SELECT NEXTVAL('PRE_SCR_SEQ')";
    
    
 // Location Queries
    public static String getAllLocationsSql = "SELECT PAR_LOC_ID,PAR_LOC_NAME,PAR_LOC_ACTIVE FROM PAR_LOC";
    public static String addLocationSql = "INSERT INTO PAR_LOC (PAR_LOC_ID,PAR_LOC_NAME,PAR_LOC_ACTIVE) VALUES(?,?,?)";
    public static String updateLocationSql ="UPDATE PAR_LOC SET PAR_LOC_NAME=?, PAR_LOC_ACTIVE=? WHERE PAR_LOC_ID=?";
    public static String deleteLocationSql = "DELETE FROM PAR_LOC WHERE PAR_LOC_ID = ?";
    public static String getNextLocationId    = "SELECT NEXTVAL('LOC_SEQ')";
}
