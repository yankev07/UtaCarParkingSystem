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

<%
try {
	int space=0;
	String AreaName=request.getParameter("abc");
	String start=request.getParameter("start");
	String end=request.getParameter("end");
	boolean abc=true;
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_system","root", "Akshat");
	PreparedStatement ps=conn.prepareStatement("Delete from areaReserve where userName='"+userName+"' and AreaName='"+AreaName+"' and Time_in='"+start+"' and Time_out='"+end+"'");
	int i=ps.executeUpdate();
	 Statement st=conn.createStatement();
	  ResultSet rs;
	  rs=st.executeQuery("Select space from parking where AreaName='"+AreaName+"'");
	  if(rs.next())
	  {
		  space=Integer.parseInt(rs.getString(1));
		  System.out.println("space "+space);
		  space=space+1;
	  }
	
	if(i>0)
	{ 
		 PreparedStatement ps1=conn.prepareStatement("update parking set space=? where AreaName=?");
		  ps1.setInt(1,space);
		  ps1.setString(2,AreaName);
		  ps1.executeUpdate();
	
	%>
		<center><h1 id="txt11">RESERVATION DELETED SUCESSFULLY</h1></center>
<% 	}
}

catch(Exception e)
{}
%>
</td>
</tr>
</table>
</div>
</body>
</html>
