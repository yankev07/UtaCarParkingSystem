<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>    
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
<% String login=(String)session.getAttribute( "login" );%>
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
        </nav>
         </td>
<td id="d2"> 
<center>
<center>
<form name="f1" method="post" action="searchController">
<h1 id="txt1">Search Parking Area Name<br></h1>

<input type="text" id="txt2"  name="search" placeholder="Enter Parking Area Name"><br><br>

<input type="submit" name="searchKey" value="Search" id="btn2"><br><br>
<label for "emptyString"  id="txt12">
<% 
String name=(String)request.getAttribute("list");
		System.out.println("here"+name);
if(name=="No Such Area Found")
{
%>
<h1 id="btn3"><%out.println("No Such Area Found"); %></h1>
<%
}
else if(name=="" || name==null)
{
%>

<%
}
else
{
	ArrayList<String> list=(ArrayList<String>)request.getAttribute("list1");
	ArrayList<String> list2=(ArrayList<String>)request.getAttribute("list2");
%>
<%
for(int i=0;i<list.size();i++)
{

out.println(list.get(i));%><a href=<%= "\"makeReservation.jsp?abc=" + list2.get(i) + "\"" %>><input type="button" value="Reserve a Spot" id="btn3"></a><br><br>
<% }
}%>
 </td>

</form>

</center>
</td>
</tr>


</table>

</div>
</div>
</body>
</html>


