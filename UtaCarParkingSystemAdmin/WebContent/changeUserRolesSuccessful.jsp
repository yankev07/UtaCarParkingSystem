<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>  
<%@ page import="java.sql.*" %>  
<%
String search=request.getParameter("search");
if(search==null){search= " ";}

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
String userName=(String)session.getAttribute("userName");
%>
<div id="head1">
<div id="txt8">Welcome <%=login %></div>
<a href="index.jsp"><div id="txt7">Logout</div></a>
<a href="updateAdminProfile.jsp"><div id="txt7">Update Profile</div></a>
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
        <a href="changeUserRoles.jsp" id="txt9">Change User Roles</a><br><br>
        <a href="revokeUser.jsp" id="txt9">Revoke User</a><br><br>
        <a href="activateUser.jsp" id="txt9">Activate a Revoked User</a><br><br>
     
        </nav>
         </td>
<td id="d2"> 
<CENTER><h1 id="txt11">USER ROLE UPDATED SUCCESSFULLY</h1></CENTER>
</td>
</tr>
</table>

</div>
</div>
</body>
</html>


