package com.hospital;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BookAppointment")
public class BookAppointment extends HttpServlet {
	Connection con =null;
	PreparedStatement pstmt = null;
	
	
	String query="insert into `appointments`(`patient_id`,`doctor_id`,`appointment_date`) values(?,?,?)";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		

		int p_id = Integer.parseInt(request.getParameter("patientid"));
		int d_id = Integer.parseInt(request.getParameter("doctorid"));
		String date = request.getParameter("ap_date");
		try {
			
			
			 con = CP.createC();
			  pstmt = con.prepareStatement(query);	
			  pstmt.setInt(1, p_id);
			  pstmt.setInt(2, d_id);
			  pstmt.setString(3, date);
			  
			  int i = pstmt.executeUpdate();
			  
			  if(i!=0) {
				  out.println("<center style='line-height: 100vh;'>Appointment Fixed<center>");
				  RequestDispatcher rd = request.getRequestDispatcher("showapnt.jsp");
				  rd.forward(request, response);
				  
			  }else {
				  
				  RequestDispatcher rd = request.getRequestDispatcher("bookapnt.html");
				  rd.forward(request, response);
			  }
			 
		}catch(SQLIntegrityConstraintViolationException e) {
			out.println("<center style='line-height: 100vh;'>Patient Id or Doctor Id is not matching. first check then book Apointment<center>");
			e.printStackTrace();
		}
		
		catch ( SQLException e) {
			
			e.printStackTrace();
		}
		
	}


}
