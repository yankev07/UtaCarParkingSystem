<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css"/>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
<div class ="bg-image" >
<br>
<br>

<center><h1 id="txt1">Welcome to UTA Campus Car Parking System</h1></center>
<br>
<br>
<div>
<div id="bg-text">
<center><h3 id="txt3">Registration</h3></center>
<center><a href="register.jsp"><h2 id="txt2">User Registration</h2></a></center>
<center><a href="employee_register.jsp"><h2 id="txt2">Employee Registration</h2></a></center>
</div>
<div id="bg-right">
<center><h3 id="txt3">Login</h3></center>
<form name="login" action="LoginController" method="post">
<h3 id="txt4">Enter UserName &nbsp;<input type="text" name="userName" hint="UserName"></h3>
<h3 id="txt4">Enter Password &nbsp;&nbsp;&nbsp;<input type="password" name="password" hint="Password"></h3>
<input type="submit" name="submit" value="Submit" id="btn1">
</form>
</div>
</div>
<br><br><br><br><br><br><br><br><br>
<br><br>
<br><br><br><br><br><br><br>
<br><br><br><br><br><br><br>
<br><br><br><br><br><br><br>
<br><br><br><br><br><br><br>
</div>
</body>
</html>
