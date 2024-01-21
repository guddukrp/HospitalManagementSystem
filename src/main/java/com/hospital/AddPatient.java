package com.hospital;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AddPatient extends HttpServlet {
	
	Connection con =null;
	PreparedStatement pstmt = null;
	
	
	String query="insert into `patients`(`name`,`phone`,`age`,`gender`) values(?,?,?,?)";
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		try {
			
			
			 con = CP.createC();
			  pstmt = con.prepareStatement(query);	
			  pstmt.setString(1, name);
			  pstmt.setString(2, phone);
			  pstmt.setInt(3, age);
			  pstmt.setString(4, gender);
			  
			  int i = pstmt.executeUpdate();
			  
			  if(i!=0) {
				  out.println("<center>Patient Inserted<center>");
			  }else {
				  
				  RequestDispatcher rd = request.getRequestDispatcher("addform.html");
				  rd.forward(request, response);
			  }
			 
		}catch(SQLIntegrityConstraintViolationException e) {
			out.println("<center>Patient with this Phone no. already registered!<center>");
			e.printStackTrace();
		}
		
		catch ( SQLException e) {
			
			e.printStackTrace();
		}
		
		 
		 
		 
	}

	

}
