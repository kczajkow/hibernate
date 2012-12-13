package org.czajkowski;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ParamDAO {

	String param;
	
	public ParamDAO () {
	}
	
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
		
		try {
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9001/trupti_db");
			
			con.prepareStatement("a").executeQuery();
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
