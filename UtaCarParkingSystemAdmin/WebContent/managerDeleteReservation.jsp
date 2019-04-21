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
    <CENTER><h1 id="txt11">RESERVATIONS LIST</h1></CENTER>
    <form method="post">

<table border="2">
<tr>
<td>Area Name</td>
<td>Spot ID</td>
<td>User</td>
<td>Camera</td>
<td>Cart</td>
<td>History</td>
<td>Available</td>
<td>Floor</td>
</tr>
<%
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_system","root", "yankev52");
    Statement st=conn.createStatement();
    ResultSet rs;
    rs=st.executeQuery("Select * from reservations");
    while(rs.next()){
    %>
        <tr>
            <td><%=rs.getString("AreaName") %></td>
            <td><%=rs.getString("spotid") %></td>
            <td><%=rs.getString("user") %></td>
            <td><%=rs.getString("camera") %></td>
            <td><%=rs.getString("cart") %></td>
            <td><%=rs.getString("history") %></td>
            <td><%=rs.getString("available") %></td>
            <td><%=rs.getString("floor") %></td>
        </tr>
 <%
                
    }
%>
</table>
<%
rs.close();
conn.close();
}
catch(Exception e)
{
e.printStackTrace();
}
%>
</form>
</td>
</tr>
<tr>
    <td id="d3">
    <center><h1 id="txt11">DELETE RESERVATION</h1></center>
<table border="0" id="tbl1">
<form name="f1" method="post" action="deleteReservationController">
<tr>
<td id="txt14">Spot ID</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="spotID" ></td>
</tr>
<tr>
<td></td>

<td><br><input type="submit" name="submit" value="DELETE" id="btn2"></td>
</tr>
</form>

</td>
</tr>
</table>
</td>
</tr>
</table>

</div>
</div>
</body>
</html>


