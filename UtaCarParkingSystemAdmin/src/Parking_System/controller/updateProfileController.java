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
import Parking_System.Utils.ErrorHandling;
import Parking_System.Data.parkingDAO;

@WebServlet("/updateProfileController")
public class updateProfileController extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  HttpSession session = request.getSession(); 
	  
	  UserData data = new UserData();
	  
	  data.setUserName((String)session.getAttribute("userName"));
	  data.setPassword(request.getParameter("password"));
	  data.setPhone(request.getParameter("phone"));
	  data.setEmail(request.getParameter("email"));
	  data.setAddress(request.getParameter("address"));
	  data.setZipCode(Integer.parseInt(request.getParameter("zip")));
	  
	  parkingDAO dataObject = new parkingDAO();
	  ErrorHandling errorHandler = new ErrorHandling();
	  
	  boolean pass = true;
	  
	  if(!errorHandler.checkPassword(data.getPassword())) {
		  request.setAttribute("errorMessage2", "Password cannot be empty ");
		  pass = false;
	  }
	  if(!errorHandler.checkPasswordMatch(data.getPassword())) {
		  request.setAttribute("errorMessage2", "Password should have At least One Capital,One Small letter,One number and One Special Character, Limit of 15 ");
		  pass = false;
	  }
	  if(!errorHandler.checkPhone(data.getPhone())) {
		  request.setAttribute("errorMessage8", "Phone cannot be empty");
		  pass = false;
	  }
	  if(!errorHandler.checkEmail(data.getEmail())) {
		  request.setAttribute("errorMessage9", "Email cannot be empty");
		  pass = false;
	  }
	  if(!errorHandler.checkEmailMatch(data.getEmail())) {
		  request.setAttribute("errorMessage9", "Email format error");
		  pass = false;
	  }
	  if(!errorHandler.checkAddress(data.getAddress())) {
		  request.setAttribute("errorMessage10", "address cannot be empty");
		  pass = false;
	  }
	  if(!errorHandler.checkZip(String.valueOf(data.getZipCode()))) {
		  request.setAttribute("errorMessage13", "Zip cannot be empty");
		  pass = false;
	  }
	  if(!errorHandler.checkZipLength(String.valueOf(data.getZipCode()))) {
		  request.setAttribute("errorMessage13", "Zip Code must be 5 Digits only");
		  pass = false;
	  }
	  
	  
	  if(pass){
		  
		  dataObject.connect();
		  
		  if(dataObject.updateAdminProfile(data.getUserName(), data.getPassword(), data.getPhone(), data.getEmail(), data.getAddress(), data.getZipCode())) {
			  response.sendRedirect("updateProfileSuccess.jsp");
		  }
		  else {
			  getServletContext().getRequestDispatcher("/updateProfile.jsp").forward(request, response);
		  }
	  }
	  
	  else{
		  getServletContext().getRequestDispatcher("/updateProfile.jsp").forward(request, response);
	  }
	  
	}
}