package com.bridgelabz.loginapp.service;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.bridgelabz.loginapp.util.util;

public class ServiceImp implements Service {
	Connection con=util.getCon();
	@Override
	public String login(String userName, String password) {
		String query="select * from details.register where username=? and password=?";
		String status=null;
		try {
			PreparedStatement pt=con.prepareStatement(query);
			pt.setString(1,userName);
			pt.setString(2,password);
			System.out.println("username"+userName);
			ResultSet i = pt.executeQuery();
			while(i.next()) {
				status=i.getString(1);
		} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int register(String userName, String email, String password, String cPassword, String mobile,
			String gender) {
		String query="insert into details.register values(?,?,?,?,?,?)";
		PreparedStatement pt;
		int result = 0;
		try {
			pt = con.prepareStatement(query);
			pt.setString(1,userName);
			pt.setString(2,email);
			pt.setString(3,password);
			pt.setString(4,cPassword);
			pt.setString(5,mobile);
			pt.setString(6,gender);
			result=pt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}