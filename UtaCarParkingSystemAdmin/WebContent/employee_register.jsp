<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%
       String userName=request.getParameter("userName");
       if(userName==null){userName= " ";}
       String password=request.getParameter("password");
       if(password==null){password= " ";}
       String fname=request.getParameter("fname");
       if(fname==null){fname= " ";}
	  String lname=request.getParameter("lname");
	  if(lname==null){lname= " ";}
	  String parkingType=request.getParameter("parking");
	  if(fname==null){fname= " ";}
	  String UTAID=request.getParameter("id");
	  if(UTAID==null){UTAID= " ";}
	  String Phone=request.getParameter("phone");
	  if(Phone==null){Phone= " ";}  
	  String email=request.getParameter("email");
	  if(email==null){email= " ";}
	  String address=request.getParameter("address");
	  if(address==null){address= " ";}
	  String city=request.getParameter("city");
	  if(city==null){city= " ";}
	  String state=request.getParameter("state");
	  System.out.println(state);
	  if(state==null){state= " ";}
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
<div class ="bg-image" >
<br>
<br>

<center><h1 id="txt1">Welcome to UTA Campus Car Parking System</h1></center>
<br>
<br>
<h2 id="txt5">E M P L O Y E E &nbsp;&nbsp;&nbsp;R E G I S T R A T I O N</h2>
<table border="0" id="tbl1">
<form name="userRegister" action="EmployeeRegisterController" method="post">
<tr>
<td id="txt9">Username</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="userName" value=<%= userName %> ></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage1} </td>
</tr>

<tr>
<td id="txt9">Password</td>
<td>&nbsp;&nbsp;&nbsp;<input type="password" name="password" value=<%= password %> ></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage2} </td>
</tr>
<tr>
<td id="txt9">First Name</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="fname" value=<%= fname %> ></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage3} </td>
</tr>
<tr>
<td id="txt9">Last Name</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="lname" value=<%= lname %> ></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage4} </td>
</tr>

<tr>
<td id="txt9">Role</td>
<td>&nbsp;&nbsp;&nbsp;
<select name="role" value=<%= role%>>
<option>Manager&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<option>Admin&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
</select>

</td>
</tr>
<tr>
<td id="txt9">UTA ID</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="id" value=<%= UTAID %> ></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage7} </td>
</tr>
<tr>
<td id="txt9">Phone</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="phone" value=<%= Phone %> ></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage8} </td>
</tr>
<tr>
<td id="txt9">Email</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="email" value=<%= email %>></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage9} </td>
</tr>
<tr>
<td id="txt9">Address</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="address" value='${data.address }'></td>
</tr>
<tr>
<td id="txt9">City</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="city" value='${data.city }'></td>
</tr>
<tr>
<td id="txt9">State</td>
<td>&nbsp;&nbsp;&nbsp;
<select name="state" >
<option>AL</option>
<option>AK</option>
<option>AZ</option>
<option>AR</option>
<option>CA</option>
<option>CO</option>
<option>CT</option>
<option>DE</option>
<option>FL</option>
<option>GA</option>
<option>HI</option>
<option>ID</option>
<option>IL</option>
<option>IN</option>
<option>IA</option>
<option>KS</option>
<option>KL</option>
<option>KY</option>
<option>LA</option>
<option>MD</option>
<option>ME</option>
<option>MA</option>
<option>MI</option>
<option>MN</option>
<option>MS</option>
<option>MO</option>
<option>MT</option>
<option>NE</option>
<option>NV</option>
<option>NH</option>
<option>NJ</option>
<option>NY</option>
<option>NM</option>
<option>NC</option>
<option>OH</option>
<option>OR</option>
<option>OK</option>
<option>PA</option>
<option>RI</option>
<option>SC</option>
<option>SD</option>
<option>TN</option>
<option>TX</option>
<option>UT</option>
<option>VT</option>
<option>VA</option>
<option>WA</option>
<option>WV</option>
<option>WI</option>
<option>WY</option>

</td>
</tr>
<tr>
<td id="txt9">Zip Code</td>
<td>&nbsp;&nbsp;&nbsp;<input type="text" name="zip" value=<%= Zip %>></td>
<td>&nbsp;&nbsp;&nbsp;<label for "emptyString" style="color:red" > ${errorMessage13} </td>
</tr>
<tr>
<td id="txt9"><input type="submit" name="submit" value="Register" id="btn1"></td>
</tr>

</table>

</form>
<br><br><br><br>
</body>
</html>