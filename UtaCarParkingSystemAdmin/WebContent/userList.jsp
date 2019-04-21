<%@ page import="java.util.*,java.sql.*" %>
<% 
String username="";
String fname="";
String lname="";
String id="";
String phone="";
String email="";
try
{
    
  
  System.out.println("I am here "+ fname);
  Class.forName("com.mysql.cj.jdbc.Driver");
  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_system","root", "yankev52");
    PreparedStatement stmt=conn.prepareStatement("select * from system_user"); 
    ResultSet rs=stmt.executeQuery();
    while(rs.next()){
    username=rs.getString("userName");
    fname=rs.getString("fname");
    lname=rs.getString("lname");
    id=rs.getString("id");
    phone=rs.getString("phone");
    email=rs.getString("email");
}

    System.out.println(username);
    System.out.println(fname);
    System.out.println(lname);
    System.out.println(id);
}
catch(Exception e){}   
   

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
<a href="updateAdminProfile.jsp"><div id="txt7">Update Profile</div></a>
<a href="Admin_Home.jsp"><div id="txt7">Home</div></a>

</div>
<div class="table-container">
<table cellspacing="0" cellpadding="0" id="tb1" >
<col width="120">

<tr>
<td id="d1"  valign="top ">
         <nav>
             <br>
        <a href="usersDirectory.jsp" id="txt9">Edit User Profile</a><br><br>
        <a href="yurts.html" id="txt9">Change User Roles</a><br><br>
        <a href="activities.html" id="txt9">Revoke User</a><br><br>
        <a href="" id="txt9">Activate a Revoked User</a><br><br>
     
        </nav>
         </td>
</tr>


</table>

</div>
</div>
</body>
</html>
