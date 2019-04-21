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
String userName=(String)session.getAttribute("editUserUsername");
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
String fname="";
String lname="";
String parking="";
String license="";
String role="";
String phone="";
String email="";
String address="";
String city="";
String state="";
int zip=0;
int id=0;
int noShows=0;
int overdue=0;
try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_system","root", "yankev52");
    Statement st=conn.createStatement();
    ResultSet rs;
    rs=st.executeQuery("Select userName,fname,lname,parking,license,role,id,phone,email,address,city,state,zip,noShows,overdue from system_user where userName='"+userName+"'");
    if(rs.next())
    {
        fname=rs.getString(2);
        lname=rs.getString(3);
        parking=rs.getString(4);
        license=rs.getString(5);
        role=rs.getString(6);
        phone=rs.getString(8);
        email=rs.getString(9);
        address=rs.getString(10);
        city=rs.getString(11);
        state=rs.getString(12);
        id=rs.getInt(7);
        zip=rs.getInt(13);
        noShows=rs.getInt(14);
        overdue=rs.getInt(15);
                
    }
}

catch(Exception e){}
%>
<center><h1 id="txt11">VIEW USER DETAILS</h1></center>
<table border="0" id="tbl1">
<form name="f1" method="post" action="editUserProfilePageSuccess.jsp">
<tr>
<td id="txt14">Username</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="userName" value=<%= userName %> disabled></td>
</tr>
<tr>
<td id="txt14">First Name</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="fname" value=<%= fname %> disabled></td>
</tr>
<tr>
<td id="txt14">Last Name</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="fname" value=<%= lname %> disabled></td>
</tr>
<tr>
<td id="txt14">Parking Type</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="fname" value=<%= parking %> disabled></td>
</tr>
<tr>
<td id="txt14">License</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="fname" value=<%= license %> disabled></td>
</tr>
<tr>
<td id="txt14">Role</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="fname" value=<%= role %> disabled></td>
</tr>
<tr>
<td id="txt14">UTA ID</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="id" value=<%= id %> disabled></td>
</tr>
<tr>
<td id="txt14">Phone</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="phone" value=<%= phone %> disabled></td>
</tr>
<tr>
<td id="txt14">Email</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="email" value=<%= email %> disabled></td>
</tr>
<tr>
<td id="txt14">Address</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="address" value=<%=address %> disabled></td>
</tr>
<tr>
<td id="txt14">City</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="fname" value=<%= city %> disabled></td>
</tr>
<tr>
<td id="txt14">State</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="fname" value=<%= state %> disabled></td>
</tr>
<tr>
<td id="txt14">Zip Code</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="zip" value=<%= zip %> disabled></td>
</tr>
<tr>
<td id="txt14">No Shows</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="fname" value=<%= noShows %> disabled></td>
</tr>
<tr>
<td id="txt14">Overdues</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="fname" value=<%= overdue %> disabled></td>
</tr>
<tr>
<td></td>
</tr>
</form>

</td>
</tr>
</table>

</div>
</body>
</html>


