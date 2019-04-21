<%@ page import="java.util.*,java.sql.*" %>

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
<%String areaName=(String)request.getParameter("abc"); 
out.println(areaName);
String start=request.getParameter("start");
String end=request.getParameter("end");
%>
<% 

try
{
	
  int space=0;
  System.out.println("I am here "+areaName);
  System.out.println("Username is "+userName);
  System.out.println("I am here "+start);
  System.out.println("I am here "+end);
  Class.forName("com.mysql.jdbc.Driver");
  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_system","root", "Akshat");
  String query="INSERT into areaReserve (userName, AreaName,Time_in,Time_out) values(?,?,?,?)";
  PreparedStatement ps=conn.prepareStatement(query);
  ps.setString(1,userName);
  ps.setString(2,areaName);
  ps.setString(3,start);
  ps.setString(4,end);
  int i=ps.executeUpdate();
  
  Statement st=conn.createStatement();
  ResultSet rs;
  rs=st.executeQuery("Select space from parking where AreaName='"+areaName+"'");
  if(rs.next())
  {
	  space=Integer.parseInt(rs.getString(1));
	  System.out.println("space "+space);
	  space=space-1;
  }
  if(i>0)
  {
	  System.out.println("Inserted successf");
	  PreparedStatement ps1=conn.prepareStatement("update parking set space=? where AreaName=?");
	  ps1.setInt(1,space);
	  ps1.setString(2,areaName);
	  ps1.executeUpdate();
	  response.sendRedirect("makeReservationSuccessful.jsp");
  }
  
  else
  {
	  
  }
  
}
catch(Exception e){}   
   

%>
</td>
</tr>
</table>
</div>
</body>