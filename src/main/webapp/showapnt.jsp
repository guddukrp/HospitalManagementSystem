<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.hospital.CP" %>
<%@ page import="com.hospital.GetDoctorPatient" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patients Details</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

    <h2>Appointment Details</h2>
    <table>
        <thead>
            <tr>
                <th>Patient Id</th>
                <th>Patient Name</th>
                <th>Doctor Id</th>
                <th>Doctor Name</th>
                <th>Date</th>
            </tr>
        </thead>
        <tbody>
    
    <% List<GetDoctorPatient> list = GetDoctorPatient.getApntList();
    
    	for(GetDoctorPatient i:list){
    	
   
    
    %>
    
            <tr>
                <td><%=i.getPatient_id() %></td>
                <td><%=i.getPatient_name() %></td>
                <td><%= i.getDoctor_id() %></td>
                <td><%=i.getDoctor_name() %></td>
                <td><%=i.getDate() %></td>
            </tr>
  	<%      
		}
	%>
            
        </tbody>
    </table>

</body>
</html>