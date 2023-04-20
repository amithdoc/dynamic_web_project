package com.shopNest.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log")
public class LoginServlet  extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		boolean val=Validator.isValid(uname,pass);
		if(val==true && uname.equals("admin")) {
			resp.sendRedirect("admin.jsp");
		}
		else if(val==true) {
			/// ayush sir resp.sendRedirect("home.jsp");
			req.setAttribute("myname",uname);
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
		else {
			///resp.sendRedirect("login.jsp");
			if(val==false){
			String amith="Incorrect Password/Username Retry!";
			req.setAttribute("loginissues",amith);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			else {
				resp.sendRedirect("login.jsp");}
		}
		
	}

}
