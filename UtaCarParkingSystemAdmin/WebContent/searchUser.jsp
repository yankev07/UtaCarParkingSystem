<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
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
        <a href="" id="txt9">Number of Availabe Spots</a><br><br>
        <a href="" id="txt9">View Details of a Parking Spot</a><br><br>
        <a href="searchUser.jsp" id="txt9">View Details of a Parking User</a><br><br>
        <a href="" id="txt9">Delete a Reservation</a><br><br>
        <a href="" id="txt9">Modify a Reservation</a><br><br>
        <a href="" id="txt9">Make Parking Spot Unavailable</a><br><br>
        <a href="" id="txt9">Set User to No-Show</a><br><br>
         <a href="" id="txt9">Set User to Over-Due</a><br><br>
         <a href="" id="txt9">Add New Parking Area</a><br><br>
         <a href="" id="txt9">Modify a Parking Area</a><br><br>
        </nav>
         </td>
<td id="d2"> 
<center>
<form name="f1" method="post" action="searchParkingUser">
<h1 id="txt1">Search Parking Users<br></h1>

<input type="text" id="txt2"  name="search" placeholder="First Name"><br><br>

<input type="submit" name="searchKey" value="Search" id="btn2"><br><br>
<label for "emptyString" >
<%
String fname=(String)request.getAttribute("FNAME");
		
String name=(String)request.getAttribute("list1");
ArrayList<String> list = (ArrayList<String>) request.getAttribute("list");		
ArrayList<String> list1=(ArrayList<String>) request.getAttribute("list2");		
	//	System.out.println("over here"+fname);
//HashMap hm=(HashMap)request.getAttribute("list");
if(name=="No Such User Found")
{
	
	System.out.println("yoooooooo");
%>
<%=request.getAttribute("list1") %>
<%
}
else if(!(list==null))
{
	System.out.println("gETTING HERE");
	for(int i=0;i<list.size();i++) {%>
	<a href=<%= "\"userList.jsp?abc=" + list1.get(i) + "\"" %> >
	   <% out.println(list.get(i));%><br><br></a>


 
<%}
}
%>   



</a>




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


