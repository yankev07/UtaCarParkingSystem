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

@WebServlet("/editUserProfilePageController")
public class editUserProfilePageController extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  HttpSession session = request.getSession(); 
	  
	  UserData data=new UserData();
	  
	  data.setUserName((String)session.getAttribute("userName"));
	  //data.setPassword(request.getParameter("password"));
	  data.setPhone(request.getParameter("phone"));
	  data.setEmail(request.getParameter("email"));
	  data.setAddress(request.getParameter("address"));
	  data.setZipCode(Integer.parseInt(request.getParameter("zip")));
	  
	  parkingDAO dataObject = new parkingDAO();
	  ErrorHandling errorHandler = new ErrorHandling();
	  

	  
	  if(/*errorHandler.checkUserName(data.getUserName()) &&*/ errorHandler.checkPhone(data.getPhone()) && errorHandler.checkPhoneLength(data.getPhone()) && errorHandler.checkEmail(data.getEmail()) && errorHandler.checkEmailMatch(data.getEmail()) && errorHandler.checkAddress(data.getAddress()) && errorHandler.checkZip(String.valueOf(data.getZipCode())) && errorHandler.checkZipLength(String.valueOf(data.getZipCode()))){
		  System.out.println("editUserProfilePageController");
		  try{
			  
			  dataObject.connect();
			  if(dataObject.editUserProfile(data.getUserName(), data.getPhone(), data.getEmail(), data.getAddress(), data.getZipCode())) {
				  System.out.println("editUserProfilePageController");
				  response.sendRedirect("editUserProfilePageSuccess.jsp");
			  }
			  else {
				  response.sendRedirect("Admin_Home.jsp");
			  }
			  
		  }
		  
		  catch(Exception e) {
			  System.out.println(e);
			  
		  }
	  }
	  
	  else{
		  getServletContext().getRequestDispatcher("/Admin_Home.jsp").forward(request, response);
	  }
	  
	}
}
