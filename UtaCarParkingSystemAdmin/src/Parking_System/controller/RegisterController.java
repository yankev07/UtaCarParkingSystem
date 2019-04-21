package Parking_System.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Parking_System.Model.UserData;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet{
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  HttpSession session = request.getSession();
	  
      
	  UserData data=new UserData();
	  String userName=request.getParameter("userName");
	  String password=request.getParameter("password");
	  String fname=request.getParameter("fname");
	  String lname=request.getParameter("lname");
	  String parkingType=request.getParameter("parking");
	  String driverLicense=request.getParameter("license");
	  String role=request.getParameter("role");
	  String UTAID=request.getParameter("id");
	  System.out.println("length"+UTAID.length());
	  String Phone=request.getParameter("phone");
	 
	  String email=request.getParameter("email");
	  String address=request.getParameter("address");
	  String city=request.getParameter("city");
	  String state=request.getParameter("state");
	  String Zip=request.getParameter("zip");
	  System.out.println("here"+userName);
	  String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}";
	  Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
	  int pass=0;
	  while(pass==0)
	  {
	  if(userName.isEmpty() || userName.equals(null))
	  {
		  
		  request.setAttribute("errorMessage1", "UserName cannot be empty");
		  //getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		  System.out.println("here1");
		 
	 }
	  
	   
	   if (!password.matches(pattern))
	  {
		  System.out.println("here2");
		  request.setAttribute("errorMessage2", "Password should have At least One Capital Letter,One Small letter,One number and One Special Character, Limit of 15 ");
		  //getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		  
		 
	  }
	  
	  if(fname.isEmpty() ||fname.equals(null))
	  {
		  System.out.println("here3");
		  request.setAttribute("errorMessage3", "First Name cannot be empty");
		// getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		  
		  
	  }
	  
	    if(lname.isEmpty()||lname.equals(null))
	  {
		  System.out.println("here4");
		  request.setAttribute("errorMessage4", "Last Name cannot be empty");
		  //getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		  System.out.println("Last Name cannot be empty");
		  
	  }
	   
	   if(driverLicense.isEmpty()|| driverLicense.equals(null))
	  {
		  System.out.println("here5");
		  request.setAttribute("errorMessage5", "Driver License cannot be empty");
		  //getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		 
	  }
	  
	   if(UTAID.isEmpty()|| UTAID==null)
	  {
		  System.out.println("here6");
		  request.setAttribute("errorMessage7", "UTA ID cannot be empty");
		  //getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		 
	  }
	  
	    if(Phone.isEmpty()|| Phone.equals(null))
	  {
		  System.out.println("here7");
		  request.setAttribute("errorMessage8", "Phone cannot be empty");
		  //getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		 
	  }
	    
	    	   
	   if(email.isEmpty()|| email.equals(null))
		  {
		  System.out.println("here8");
			  request.setAttribute("errorMessage9", "Email cannot be empty");
			//  getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			 
		  }
	
	  if(address.isEmpty()|| address.equals(null))
		  {
		  System.out.println("here9");
			  request.setAttribute("errorMessage10", "address cannot be empty");
			  //getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			 
		  } 
	   
	   if(city.isEmpty()|| city.equals(null))
		  {
		  System.out.println("here10");
			  request.setAttribute("errorMessage11", "City cannot be empty");
			  //getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			 
		  } 
	   
	
	   
	  if(Zip.isEmpty()|| Zip.equals(null))
		  {
		  System.out.println("here12");
			  request.setAttribute("errorMessage13", "Zip cannot be empty");
			  //getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			 
		  } 
	  if(userName.length()<3 || userName.length()>11)
	   {
		  System.out.println("here13");
		   request.setAttribute("errorMessage1", "UserName  should be between 3 and 11");
		   //getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		  
	   }
	  
	  if(!(Zip.length()==5))
	  {
		  request.setAttribute("errorMessage13", "Zip Code must be 5 Digits only");
	  }
	   
	    if(!matcher.find())	  
	  {
		  System.out.println("here14");
		  request.setAttribute("errorMessage9", "Email format is not proper");
		   
		
	  }
	    pass=1;
	  }
	   
	 if(!userName.isEmpty() && !password.isEmpty() && !fname.isEmpty() && !lname.isEmpty() &&!driverLicense.isEmpty() && !UTAID.isEmpty() && !Phone.isEmpty() && !email.isEmpty())
	 {
		  System.out.println("ok here");
	  data.setUserName(userName);
	  data.setPassword(password);
	  data.setFname(fname);
	  data.setLname(lname);
	  data.setParkingType(parkingType);
	  data.setDriverLicense(driverLicense);
	  data.setRole(role);
	  
	  int utaid=Integer.parseInt(UTAID);
	  
	  data.setUTAID(utaid);
	 
	  data.setPhone(Phone);
	  data.setEmail(email);
	  data.setAddress(address);
	  data.setCity(city);
	  data.setState(state);
	  int zip=Integer.parseInt(Zip);
	  data.setZipCode(zip);
	  
	
	  
	  
	
		
		 
	  
	  try
	  {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_system","root", "yankev52");
		  String query="INSERT INTO system_user (userName,password,fname,lname,parking,license,role,id,phone,email,address,city,state,zip) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		  PreparedStatement ps=conn.prepareStatement(query);
		  ps.setString(1, data.getUserName());
		  ps.setString(2, data.getPassword());
		  ps.setString(3, data.getFname());
		  ps.setString(4, data.getLname());
		  ps.setString(5, data.getParkingType());
		  ps.setString(6, data.getDriverLicense());
		  ps.setString(7, data.getRole());
		  ps.setString(8, UTAID);
		  ps.setString(9, Phone);
		  ps.setString(10, data.getEmail());
		  ps.setString(11,data.getAddress());
		  ps.setString(12, data.getCity());
		  ps.setString(13, data.getState());
		  ps.setString(14, Zip);
		  int i=ps.executeUpdate();
		    if (i>0){
		    	 System.out.println("Inserted successfully");
		    	 getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);
		    }
		    else{
		    	getServletContext().getRequestDispatcher("/failure.jsp").forward(request, response);
		    	
		    }
		    
		  
	  }
	  
	  
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	  }	
	 
	 else
	 {
		 getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
		  
		 System.out.println("Error");
	 }
		
	}
}	   


	

