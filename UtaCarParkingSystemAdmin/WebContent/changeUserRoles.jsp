<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>  
<%@ page import="java.sql.*" %>  
<%
String search=request.getParameter("search");
if(search==null){search= " ";}
String password=request.getParameter("password");
if(password==null){password= " ";}
String Phone=request.getParameter("phone");
if(Phone==null){Phone= " ";}  
String email=request.getParameter("email");
if(email==null){email= " ";}
String address=request.getParameter("address");
if(address==null){address= " ";}
String Zip=request.getParameter("zip");
if(Zip==null){Zip= " ";}
String role=request.getParameter("role");

%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css"/>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>

</head>
<body>
<% String login=(String)session.getAttribute( "login" );
String userName="";
String fname="";
String lname="";
%>
<div id="head1">
<div id="txt8">Welcome <%=login %></div>
<a href="index.jsp"><div id="txt7">Logout</div></a>
<a href="#"><div id="txt7">Update Profile</div></a>
<a href="Admin_Home.jsp"><div id="txt7">Home</div></a>

</div>
<div class="table-container">
<table cellspacing="0" cellpadding="0" >
<col width="120">

<tr>
<td id="d1"  valign="top ">
         <nav>
             <br>
        <a href="editUserProfile.jsp" id="txt9">Edit User Profile</a><br><br>
        <a href="#" id="txt9">Change User Roles</a><br><br>
        <a href="revokeUser.jsp" id="txt9">Revoke User</a><br><br>
        <a href="activateUser.jsp" id="txt9">Activate a Revoked User</a><br><br>
     
        </nav>
         </td>
<td id="d2"> 

<center><h1 id="txt11">CHANGE USER ROLES</h1></center>
<table border="0" id="tbl1">
<form name="f1" method="post" action="changeUserRolesController">
<tr>
<td id="txt14">Username</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="userName" value=<%= userName %>></td>
</tr>
<tr>
<td id="txt14">First Name</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="fname" value=<%= fname %>></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage3} </td>
</tr>
<tr>
<td id="txt14">Last Name</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="lname" value=<%= lname %>></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage4} </td>
</tr>
<tr>
<td id="txt14">Email</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="email" value=<%= email %>></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage9} </td>
</tr>
<tr>
<td id="txt14">Role</td>
<td>&nbsp;&nbsp;&nbsp;
<select name="role" value=<%= role%>>
<option>Manager&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<option>Admin&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<option>User&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
</select>

</td>
</tr>
<tr>
<td></td>

<td><br><input type="submit" name="submit" value="CHANGE ROLE" id="btn2"></td>
</tr>
</form>

</td>
</tr>
</table>

</div>
</div>
</body>
</html>


