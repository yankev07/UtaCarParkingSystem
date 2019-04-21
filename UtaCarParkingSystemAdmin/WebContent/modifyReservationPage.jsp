<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>  
<%@ page import="java.sql.*" %>  
<%
String search=request.getParameter("search");
if(search==null){search= " ";}
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
String spotID=(String)session.getAttribute("searchSpotID");
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
<%
String areaName="";
String user="";
String camera="";
String cart="";
String history="";
String available="";
String floor="";
int id=0;
try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_system","root", "yankev52");
    Statement st=conn.createStatement();
    ResultSet rs;
    rs=st.executeQuery("Select AreaName,spotid,user,camera,cart,history,available,floor from reservations where spotid='"+spotID+"'");
    if(rs.next())
    {
    	areaName=rs.getString(1);
    	user=rs.getString(3);
    	camera=rs.getString(4);
    	cart=rs.getString(5);
    	history=rs.getString(6);
    	available=rs.getString(7);
    	floor=rs.getString(8);
                
    }
}

catch(Exception e){}
%>
<center><h1 id="txt11">EDIT USER RESERVATION</h1></center>
<table border="0" id="tbl1">
<form name="f1" method="post" action="modifyReservationPageController.jsp">
<tr>
<td id="txt14">Area Name</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="AreaName" value=<%= areaName %>></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage8} </td>
</tr>
<tr>
<td id="txt14">Spot ID</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="spotid" value=<%= spotID %>></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage8} </td>
</tr>
<tr>
<td id="txt14">User</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="user" value=<%= user %>></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage8} </td>
</tr>
<tr>
<td id="txt14">Camera</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="camera" value=<%= camera %>></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage8} </td>
</tr>
<tr>
<td id="txt14">Cart</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="cart" value=<%= cart %> ></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage8} </td>
</tr>
<tr>
<td id="txt14">History</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="history" value=<%= history %>></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage9} </td>
</tr>
<tr>
<td id="txt14">Available</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="available" value=<%=available %>></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage10} </td>
</tr>
<tr>
<td id="txt14">Floor</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="floor" value=<%= floor %>></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage13} </td>
</tr>
<tr>
<td></td>

<td><br><input type="submit" name="submit" value="EDIT" id="btn2"></td>
</tr>
</form>

</td>
</tr>
</table>

</div>
</body>
</html>


