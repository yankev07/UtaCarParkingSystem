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

@WebServlet("/parkingUserDetailsController")
public class parkingUserDetailsController extends HttpServlet{
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
    HttpSession session = request.getSession(); 
    
    UserData data = new UserData();
    
    data.setUserName(request.getParameter("userName"));
    
    session.setAttribute("editUserUsername",data.getUserName());
    
    boolean pass = true;
    
    parkingDAO dataObject = new parkingDAO();
    ErrorHandling errorHandler = new ErrorHandling();
    
//    if(!errorHandler.checkUserName(data.getUserName())) {
//    	request.setAttribute("errorMessage10", "Username cannot be empty");
//    	pass = false;
//    }
    if(!errorHandler.checkUserNameLength(data.getUserName())) {
    	request.setAttribute("errorMessage10", "Username format error");
    	pass = false;
    }
    
    
    if(pass){
    	dataObject.connect();
    	response.sendRedirect("parkingUserDetailsPage.jsp");
    }
    
    else{
      getServletContext().getRequestDispatcher("/Manager_Home.jsp").forward(request, response);
    }
    
  }
}