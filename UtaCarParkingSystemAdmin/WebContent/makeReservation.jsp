<%@ page import="java.util.*,java.sql.*" %>
<%

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
        <a href="User_Home.jsp" id="txt9">Search Reservation</a><br><br>
        <a href="User_Home.jsp" id="txt9">Make a Reservation</a><br><br>
        <a href="viewReservation.jsp" id="txt9">View Reservations</a><br><br>
        <a href="viewReservation.jsp" id="txt9">Modify Reservation</a><br><br>
        <a href="viewReservation.jsp" id="txt9">Cancel a Reservation</a><br><br>
        <a href="viewViolation.jsp" id="txt9">View No Shows and Violations</a><br><br>
        <a href="viewStatus.jsp" id="txt9">View Status</a><br><br>
        </nav>
         </td>
<td id="d2"> 
<%

String name=request.getParameter("abc");
String start=(String)request.getAttribute("start");
String end=(String)request.getAttribute("end");
System.out.println("time here is"+start);
%>
<h1><center><%=name%> Parking Area Reservation</center></h1>
<br>
<form name="f1" method="post" action="makeReservationController">
<%session.setAttribute("areaName", name);

System.out.println("name over here s"+name);
%>
<h1 id="txt12">Reserve From:&nbsp;&nbsp;&nbsp;<select name="start" value=${start }>
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
<h1 id="txt12">Reserve Until:&nbsp;&nbsp;&nbsp;&nbsp;<select name="end" value=<%=end %>>
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
<input type="submit" name="searchKey" value="Search" id="btn2"><br>
</form>
<%
String error=(String)request.getAttribute("error");
String areaName=(String)request.getAttribute("abc");
System.out.println("cccc"+areaName);
System.out.println(error);
if(error=="End Time Cannot be Less than or Equal to Start Time")
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
else if(error=="Cannot Reserve for more than 3 hours")
{
	
%><h1 id="txt13">
<%out.println(error); %></h1>
<%	
}
else
{System.out.println("Reached");
%>
<br>

<a href=<%= "\"makeReservationConfirm.jsp?abc=" + areaName + "&start="+start+"&end="+end+"\"" %> id="btn3">Confirm Your Reservation</a>	
<%}

%>

</td>
</tr>
</table>
</div>
</body>
</html>