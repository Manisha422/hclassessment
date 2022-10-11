package com.LogSign;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/Log")
public class Log extends HttpServlet {


public void doPost(HttpServletRequest request,HttpServletResponse
response) throws IOException
{
response.setContentType("text/html");
PrintWriter out=response.getWriter();

String u=request.getParameter("Username");
String p=request.getParameter("Password");


try
{
Class.forName("com.mysql.cj.jdbc.Driver");
java.sql.Connection con=
DriverManager.getConnection("jdbc:mysql://localhost:3306/logsign","root","root");
PreparedStatement ps=((java.sql.Connection)con).prepareStatement("select * from new_table where Username=(?) and Password=(?)");


ps.setString(1, u);
ps.setString(2, p);


ResultSet rs=ps.executeQuery();
if(rs.next())
out.print("You are logged in successfully");
else
out.print("you are not the user please register");
}

catch (Exception e2)
{
e2.printStackTrace();
}

out.close();

}

}