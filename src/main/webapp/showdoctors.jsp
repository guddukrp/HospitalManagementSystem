<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.hospital.CP" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doctors Details</title>
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

    <h2>Patients Details</h2>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Specialization</th>
                
            </tr>
        </thead>
        <tbody>
    
    <% Connection con = CP.createC();
    Statement stmt = con.createStatement();
    String query = "select * from `doctors`";
    ResultSet res = stmt.executeQuery(query);
    
    while(res.next()){
    	
   
    
    %>
    
            <tr>
                <td><%=res.getInt("id") %></td>
                <td><%=res.getString("name") %></td>
                <td><%=res.getString("specialization") %></td>
                
            </tr>
  	<%      
		}
	%>
            
        </tbody>
    </table>

</body>
</html>
