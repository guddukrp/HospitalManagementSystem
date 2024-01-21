package com.hospital;

import java.util.List;

public class Program1 {

	public static void main(String[] args) {

		
		GetDoctorPatient g = new GetDoctorPatient();
		List<GetDoctorPatient> apntList = g.getApntList();
		
		System.out.println(apntList);
	}

}
