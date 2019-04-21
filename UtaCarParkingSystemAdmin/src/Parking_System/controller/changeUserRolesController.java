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

@WebServlet("/changeUserRolesController")
public class changeUserRolesController extends HttpServlet{
    
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession(); 
      
      UserData data=new UserData();
      
      data.setUserName(request.getParameter("userName"));
      data.setFname(request.getParameter("fname"));
      data.setLname(request.getParameter("lname"));
      data.setEmail(request.getParameter("email"));
      data.setRole(request.getParameter("role"));
      
      parkingDAO dataObject = new parkingDAO();
      ErrorHandling errorHandler = new ErrorHandling();
      
      boolean pass = true;
      
//      if(!errorHandler.checkUserName(data.getUserName())){
//    	  request.setAttribute("errorMessage8", "User Name cannot be empty");
//    	  pass = false;
//      }
      
      if(errorHandler.checkFname(data.getFname())) {
    	  request.setAttribute("errorMessage8", "First Name cannot be empty");
    	  pass = false;
      }
      
      if(errorHandler.checkLname(data.getLname())) {
    	  request.setAttribute("errorMessage8", "Last Name cannot be empty");
    	  pass = false;
      }
      
      if(errorHandler.checkEmail(data.getEmail())) {
    	  request.setAttribute("errorMessage9", "Email cannot be empty");
    	  pass = false;
      }
      
      if(errorHandler.checkRole(data.getRole())) {
    	  request.setAttribute("errorMessage9", "Role cannot be empty");
    	  pass = false;
      }
      
      if(pass && errorHandler.checkEmailMatch(data.getEmail())){
          
          try{
        	  dataObject.connect();
              if(dataObject.changeUserRole(data.getUserName(), data.getFname(), data.getLname(), data.getEmail(), data.getRole())){
                  response.sendRedirect("changeUserRolesSuccessful.jsp");
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
