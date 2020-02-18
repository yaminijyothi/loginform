package com.bridgelabz.loginapp.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.loginapp.model.User;
import com.bridgelabz.loginapp.service.Service;
import com.bridgelabz.loginapp.service.ServiceImp;
@WebServlet("/view/Profile")
public class Profile extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out=resp.getWriter();
	// req.getRequestDispatcher("link.html").include(req, resp);
	Cookie c[]=req.getCookies();
	if(c!=null) {
		
		String name=c[0].getValue();
		out.print("welcome  "+name);
	}
	else {
		
		req.getRequestDispatcher("common.html").include(req, resp);
		out.println("please login first");
		
	}
}
}
