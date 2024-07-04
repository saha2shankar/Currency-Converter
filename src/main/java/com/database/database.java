package com.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
	public static Connection getDatabaseCon(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/currency_converter","root","");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}
