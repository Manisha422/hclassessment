package com.assessment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String lang="";
		String studentId=request.getParameter("sid");
		String firstName=request.getParameter("fname");
		String lastName=request.getParameter("lname");
		String phoneNo=request.getParameter("phno");
		String email=request.getParameter("email");
		
		
		
		out.println(" Information is:</br>");
		out.println("First Name:"+firstName+"</br>");
		out.println("Last Name:"+lastName+"</br>");
		out.println("Phone Number:"+phoneNo+"</br>");
		out.println("Email:"+email+"</br>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/register11","root","root");
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?,?)");
			
			
			
			ps.setString(1, studentId);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, phoneNo);
			ps.setString(5, email);
			int i=ps.executeUpdate();
			if(i>0){
				out.print("Data Inserted Successfully");
			}
			
			
			String[] val=request.getParameterValues("language");
		    String query2="insert into language values (?,?)";
		    PreparedStatement pt1=con.prepareStatement(query2);
		    for(int j=0;j<val.length;j++)
		    {
		    	pt1.setString(1,studentId);
		    	pt1.setString(2,val[j] );
		    	pt1.execute();
		    }

			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
