//purpose : registration using servlets
//file    : Registration
package com.bridgelabz.loginapp.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.loginapp.model.User;
import com.bridgelabz.loginapp.service.Service;
import com.bridgelabz.loginapp.service.ServiceImp;
@WebServlet("/view/register")
public class Register extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out=resp.getWriter();
	User u=new User();
	String userName=req.getParameter("u");
	String password=req.getParameter("p");
	String cPassword=req.getParameter("cp");
	String email=req.getParameter("e");
	String mobile=req.getParameter("m");
	String gender=req.getParameter("g");
	try {
	Service service=new ServiceImp();
	int result=service.register(userName, email, password, cPassword, mobile, gender);
	if(result!=0) {
		req.getRequestDispatcher("Common.html").include(req,resp);
		out.println("Registerd successfully");
		out.print("welome  "+userName);
	    
	}
else {
	
	req.getRequestDispatcher("Register.html").include(req,resp);
	out.print("user is not registerd");	
}
}catch(Exception e) {
	e.printStackTrace();
}
}
}
