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

import Parking_System.Model.RevokedUsers;
import Parking_System.Utils.ErrorHandling;
import Parking_System.Data.parkingDAO;

@WebServlet("/revokeUserController")
public class revokeUserController extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  HttpSession session = request.getSession();
	  
	  RevokedUsers revokedUser =new RevokedUsers();
	  
	  revokedUser.setUserName(request.getParameter("userName"));
	  revokedUser.setEmail(request.getParameter("email"));
	  revokedUser.setReason(request.getParameter("reason"));
	  
	  parkingDAO dataObject = new parkingDAO();
	  ErrorHandling errorHandler = new ErrorHandling();
	  
	  boolean pass = true;
	  
//	  if(!errorHandler.checkUserName(revokedUser.getUserName())) {
//		  request.setAttribute("errorMessage1", "UserName cannot be empty");
//		  pass = false;
//	  }
	  
	  if(!errorHandler.checkEmail(revokedUser.getEmail()) || !errorHandler.checkEmailMatch(revokedUser.getEmail())) {
		  request.setAttribute("errorMessage2", "Email empty or invalid");
		  pass = false;
	  }
	  
	  if(!errorHandler.checkReason(revokedUser.getReason())) {
		  request.setAttribute("errorMessage3", "reason cannot be empty");
		  pass = false;
	  }
	   
	 if(pass){
		 
		 dataObject.connect();
		 
		 if(dataObject.revokeUser(revokedUser.getUserName(), revokedUser.getEmail(), revokedUser.getReason())) {
			 getServletContext().getRequestDispatcher("/revokeUserSuccessful.jsp").forward(request, response);
		 }
		 else {
			 getServletContext().getRequestDispatcher("/Admin_Home.jsp").forward(request, response);
		 }
		    
	  }
	  
	 else{
		 getServletContext().getRequestDispatcher("/Admin_Home.jsp").forward(request, response); 
		 System.out.println("Error");
	 }
		
	}
}	  
