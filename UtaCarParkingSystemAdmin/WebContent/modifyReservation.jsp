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
<a href="User_Home.jsp"><div id="txt7">Home</div></a>

</div>
<div class="table-container">
<table cellspacing="0" cellpadding="0" id="tb1" >
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
<CENTER><h1 id="txt11">Modify Your Reservation</h1></CENTER>
<%

String areaName=request.getParameter("abc");
String startTime=request.getParameter("start");
String endTime=request.getParameter("end");

%>
<form name="f1" method="post" action="modifyReservationController?xyz=<%=areaName%>&uname=<%=userName%>">
<h1 id="txt12">Reserve From:&nbsp;&nbsp;&nbsp;<select name="startTime">
<option>06:00</option>
<option>07:00</option>
<option>08:00</option>
<option>09:00</option>
<option>10:00</option>
<option>11:00</option>
<option>12:00</option>
<option>13:00</option>
<option>14:00</option>
<option>15:00</option>
<option>16:00</option>
<option>17:00</option>
<option>18:00</option>
<option>19:00</option>
<option>20:00</option>
<option>21:00</option>
<option>22:00</option>
<option>23:00</option>

<option>00:00</option>
<option>01:00</option>
<option>02:00</option>
<option>03:00</option>
<option>04:00</option>
<option>05:00</option>
</select>
<br>
<h1 id="txt12">Reserve Until:&nbsp;&nbsp;&nbsp;&nbsp;<select name="endTime" >
<option>06:00</option>
<option>07:00</option>
<option>08:00</option>
<option>09:00</option>
<option>10:00</option>
<option>11:00</option>
<option>12:00</option>
<option>13:00</option>
<option>14:00</option>
<option>15:00</option>
<option>16:00</option>
<option>17:00</option>
<option>18:00</option>
<option>19:00</option>
<option>20:00</option>
<option>21:00</option>
<option>22:00</option>
<option>23:00</option>

<option>00:00</option>
<option>01:00</option>
<option>02:00</option>
<option>03:00</option>
<option>04:00</option>
<option>05:00</option>

</select>
<br><br>
<input type="submit" name="searchKey" value="Update" id="btn2"><br>
</form>
<%
String error=(String)request.getAttribute("error");
//String areaName=request.getParameter("abc");
System.out.println("cccc"+areaName);
System.out.println(error);
if(error=="End Time Cannot be Less or Equal to Start Time")
{%><h1 id="txt13">
<%
out.println(error); %></h1>
<%
}
else if(error==null || error=="")
{System.out.println("Reached 1");
%>

<%
}
else 
{
	
%><h1 id="txt13">
<%out.println(error); %></h1>
<%	
}

%>

</td>
</tr>
</table>
</div>
</body>
</html>