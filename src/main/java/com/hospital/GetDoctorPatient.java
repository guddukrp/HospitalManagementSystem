package com.hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetDoctorPatient {
	
	int patient_id;
	String patient_name;
	int doctor_id;
	String doctor_name;
	String date;
	public GetDoctorPatient() {
	}
	
	

	public GetDoctorPatient(int patient_id, String patient_name, int doctor_id, String doctor_name, String date) {
		super();
		this.patient_id = patient_id;
		this.patient_name = patient_name;
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		this.date = date;
	}
	

	public int getPatient_id() {
		return patient_id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public String getDate() {
		return date;
	}



	@Override
	public String toString() {
		return "GetDoctorPatient [patient_id=" + patient_id + ", patient_name=" + patient_name + ", doctor_id="
				+ doctor_id + ", doctor_name=" + doctor_name + ", date=" + date + "]";
	}




	
	public static List<GetDoctorPatient> getApntList()  {
		
		String query1= "Select `patient_id`, `doctor_id`,`appointment_date` from `appointments`" ;
		List<GetDoctorPatient> list= new ArrayList<GetDoctorPatient>();
		try {
			Connection con = CP.createC();
			PreparedStatement pstmt = con.prepareStatement(query1);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int pid=res.getInt("patient_id");
				int did=res.getInt("doctor_id");
				String date = res.getString("appointment_date");
				
				String pname = getPatient(pid);
				String dname = getDoctor(did);
				
				list.add(new GetDoctorPatient(pid,pname,did,dname,date));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	static String getPatient(int id) {
		
		String getQuery="Select `name` from `patients` where `id` =?";
		
		try {
			Connection con = CP.createC();
			PreparedStatement pstmt = con.prepareStatement(getQuery);
			pstmt.setInt(1, id);
			
			ResultSet res = pstmt.executeQuery();
			if(res.next()) {
				return res.getString("name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	static String getDoctor(int id) {
		String getQuery="Select `name` from `doctors` where `id` =?";
		
		try {
			Connection con = CP.createC();
			PreparedStatement pstmt = con.prepareStatement(getQuery);
			pstmt.setInt(1, id);
			
			ResultSet res = pstmt.executeQuery();
			if(res.next()) {
				return res.getString("name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
