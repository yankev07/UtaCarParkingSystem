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
try {
	boolean abc=true;
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_system","root", "Akshat");
	Statement st=conn.createStatement();
	ResultSet rs;
	rs=st.executeQuery("Select AreaName,Time_in,Time_out from areaReserve where userName='"+userName+"'");
	while(rs.next())
	{
		abc=false;
      String AreaName=rs.getString(1);
      String start=rs.getString(2);
      String end=rs.getString(3);
      %>
      <h1 id="txt14">Area Reserved : <%=AreaName %></h1>
      <h1 id="txt14">Reservation From : <%=start %></h1>
      <h1 id="txt14">Reservation Until: <%=end %></h1>
      <br>
      <a href="deleteReservation.jsp?abc=<%=AreaName %>&start=<%=start %>&end=<%=end %>" id="btn3">DELETE RESERVATION</a>
      <a href="modifyReservation.jsp?abc=<%=AreaName %>&start=<%=start %>&end=<%=end %>" id="btn3">MODIFY RESERVATION</a>
 <%     
	}
	if(abc)
	{ %>
		<center><h1 id="txt11">YOU HAVE NO RESERVATIONS AT THIS TIME</h1></center>
	<%}
	
}
catch(Exception e){}
%>

</td>
</tr>
</table>
</div>
</body>
</html>