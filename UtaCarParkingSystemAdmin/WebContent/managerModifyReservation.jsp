<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>  
<%@ page import="java.sql.*" %>  

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css"/>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>

</head>
<body>
<% String login=(String)session.getAttribute( "login" );
String spotID = "";
String email = "";
%>
<div id="head1">
<div id="txt8">Welcome <%=login %></div>
<a href="index.jsp"><div id="txt7">Logout</div></a>
<a href="updateProfile.jsp"><div id="txt7">Update Profile</div></a>
<a href="Manager_Home.jsp"><div id="txt7">Home</div></a>

</div>
<div class="table-container">
<table cellspacing="0" cellpadding="0" >
<col width="120">

<tr>
<td id="d1"  valign="top ">
         <nav>
             <br>
        <a href="numberOfAvailableSpots.jsp" id="txt9">Number of Availabe Spots</a><br><br>
        <a href="viewDetailsOfParkingUser.jsp" id="txt9">View Details of a Parking User</a><br><br>
        <a href="managerDeleteReservation.jsp" id="txt9">Delete a Reservation</a><br><br>
        <a href="managerModifyReservation.jsp" id="txt9">Modify a Reservation</a><br><br>
        <a href="makeSpotUnavailable.jsp" id="txt9">Make Parking Spot Unavailable</a><br><br>
        <a href="setNoShow.jsp" id="txt9">Set User to No-Show</a><br><br>
        <a href="setOverdue.jsp" id="txt9">Set User to Over-Due</a><br><br>
        <a href="addParkingArea.jsp" id="txt9">Add New Parking Area</a><br><br>
        <a href="modifyParkingArea.jsp" id="txt9">Modify a Parking Area</a><br><br>
        </nav>
</td>
<td id="d2"> 
<center><h1 id="txt11">BROWSE RESERVATIONS</h1></center>
<table border="0" id="tbl1">
<form name="f1" method="post" action="managerModifyReservationController">
<tr>
<td id="txt14">Spot ID</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="spotID" value=<%= spotID %>></td>
</tr>
<tr>
<td></td>
<td><br><input type="submit" name="submit" value="FIND" id="btn2"></td>
</tr>
</form>

</td>
</tr>
</table>

</div>
</div>
</body>
</html>


