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

import Parking_System.Model.Parking;
import Parking_System.Utils.ErrorHandling;
import Parking_System.Data.parkingDAO;

@WebServlet("/spotUnavailableController")
public class spotUnavailableController extends HttpServlet{
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
      HttpSession session = request.getSession(); 
      
      Parking parking = new Parking();
      
      parking.setUnavailable(Integer.parseInt(request.getParameter("lname")));
      parking.setAreaName(request.getParameter("role"));
      
      parkingDAO dataObject = new parkingDAO();
      ErrorHandling errorHandler = new ErrorHandling();
      
      boolean pass = true;
      
      if(!errorHandler.checkParkingAreaName(parking.getAreaName())) {
    	  pass = false;
      }
      if(!errorHandler.checkZip(String.valueOf(parking.getUnavailable()))) {
    	  pass = false;
      }
    
    if(pass){
      
    	dataObject.connect();
    	
    	if(dataObject.makeSpotUnavailable(parking.getAreaName(), parking.getUnavailable())) {
    		response.sendRedirect("makeSpotUnavailableSuccess.jsp");
    	}
    	else {
    		response.sendRedirect("Manager_Home.jsp");
    	}
    }
    
    else{
      getServletContext().getRequestDispatcher("/Manager_Home.jsp").forward(request, response);
    }
    
  }
}
