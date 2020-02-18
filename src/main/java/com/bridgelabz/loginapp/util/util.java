package com.bridgelabz.loginapp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class util {
	private static	Connection con;
	static {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306?user=root&password=Yamini@428";
	    con=DriverManager.getConnection(url);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
	public static Connection getCon() {
		return con;
	}
}
