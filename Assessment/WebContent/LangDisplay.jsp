<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Language</title>
</head>
<body>
<form action="">
<h3>View Details</h3>
<label for="languageDetails">Select Language:</label>
<select name="language" >
 
  <option value="C">C</option>
  <option value="C++">C++</option>
  <option value="Java">Java</option>
  <option value="Any">Any</option>
</select><br>
<input type="submit" value="Submit">
</form>

<%
String language = request.getParameter("language");
if(language != null){
%>
<table>
<tr>
<td>Student Id</td>
<td>First Name</td>
<td>Last Name</td>
<td>Phone Number</td>
<td>Email Id</td>
<td>Languages</td>
<tr>
<%
try{
Class.forName("com.mysql.cj.jdbc.Driver");
java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/register11","root","root");
ResultSet rs=null;
if(language.equals("Any"))
{
	PreparedStatement ps = con.prepareStatement("select r.student_id,r.first_name,r.last_name,r.phone_number,r.email,l.languages from student r,language l where r.student_id = l.student_id  ");
	rs = ps.executeQuery();}	
else{
PreparedStatement ps = con.prepareStatement("select r.student_id,r.first_name,r.last_name,r.phone_number,r.email,l.languages from student r,language l where r.student_id = l.student_id and l.languages = ?");
ps.setString(1, language);
 rs = ps.executeQuery();}
%>
<%while(rs.next()){ %>
<tr>
<td><%=rs.getString("student_id")%></td>
<td><%=rs.getString("first_name")%></td>
<td><%=rs.getString("last_name")%></td>
<td><%=rs.getString("phone_number")%></td>
<td><%=rs.getString("email")%></td>
<td><%=rs.getString("languages")%></td>
</tr>
<%} %>
<%
}
catch(ClassNotFoundException e){
e.printStackTrace();
}

} %>
</table>
</body>
</html>
