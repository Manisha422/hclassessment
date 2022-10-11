<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration form</title>
</head>
<body>
<h1><b><center>STUDENT REGISTRATION FORM</center> </b></h1>
<form action="Register" method="post">
<center>Student ID:<input type="text" name="sid" required><br><br></center>
<center>First name:<input type="text" name="fname" required><br><br></center>
<center>Last name:<input type="text" name="lname" required><br><br></center>
<center>Ph Number:<input type="tel" name="phno" required><br><br></center>
<center>Email:<input type="email" name="email" required><br><br></center>
<center>Language: <input type="checkbox" name="language" value="C"> C
		: <input type="checkbox" name="language" value="C++"> C++
	    : <input type="checkbox" name="language" value="Java"> Java<br><br></center>
<center><input type="submit" value="submit"></center>
	    


</form>



</body>
</html>