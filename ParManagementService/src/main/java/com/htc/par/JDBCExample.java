package com.htc.par;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

    public static void main(String[] args) {

		// https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html#package.description
        // auto java.sql.Driver discovery -- no longer need to load a java.sql.Driver class via Class.forName

        // register JDBC driver, optional, since java 1.6
        /*try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        // auto close connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/parmanagement", "postgres", "admin")) {

            if (conn != null) {
            	Statement st =conn.createStatement();
            	ResultSet rs;
            	rs=st.executeQuery("Select * from public.\"PRESCREENER_LKUP\"");
            	System.out.println("rs.next()"+rs.next());
            	            	
            	
            	while(rs.next())
            	{
            	System.out.println(rs.getInt(1));
            	}
            	System.out.println(conn.prepareCall("select * from PRESCREENER_LKUP"));
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
