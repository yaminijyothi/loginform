//purpose : login form using servlets
//file    : Login.java
package com.bridgelabz.loginapp.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.loginapp.model.User;
import com.bridgelabz.loginapp.service.Service;
import com.bridgelabz.loginapp.service.ServiceImp;
@WebServlet("/view/Login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		User u=new User();
		String userName=req.getParameter("n");
		String password=req.getParameter("p");
		u.setUsername(userName);
		u.setPassword(password);
		Service service=new ServiceImp();
		String result=service.login(userName, password);
		if(result!=null) {
			req.getRequestDispatcher("Common.html").include(req, resp);
			out.println("welcome ");
			out.println("user login successfully");
			
			
			Cookie ck=new Cookie("userName",userName);
			resp.addCookie(ck);
		}
		else {
			req.getRequestDispatcher("Common.html").include(req, resp);
			out.println("sorry username or password incorrect");;
			
		}
		out.close();
		
	}

}
