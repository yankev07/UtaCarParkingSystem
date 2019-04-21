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

@WebServlet("/editUserProfileController")
public class editUserProfileController extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  HttpSession session = request.getSession(); 
	  
	  UserData data = new UserData();
	  
	  data.setUserName((String)session.getAttribute("userName"));
	  data.setEmail(request.getParameter("email"));
	  
	  String searchUsername = request.getParameter("userName");
	  session.setAttribute("editUserUsername",searchUsername);
	  
	  parkingDAO dataObject = new parkingDAO();
	  ErrorHandling errorHandler = new ErrorHandling();
	  
	  if(/*errorHandler.checkUserName(data.getUserName()) &&*/ errorHandler.checkEmail(data.getEmail()) && errorHandler.checkEmailMatch(data.getEmail())){
		  
		  try{
			  dataObject.connect();
			  response.sendRedirect("editUserProfilePage.jsp");
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
