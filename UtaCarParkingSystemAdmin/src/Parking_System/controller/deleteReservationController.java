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

import Parking_System.Model.Reservations;
import Parking_System.Utils.ErrorHandling;
import Parking_System.Data.parkingDAO;

@WebServlet("/deleteReservationController")
public class deleteReservationController extends HttpServlet{

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
    HttpSession session = request.getSession();
  
    Reservations reservation =new Reservations();
    
    reservation.setSpotId(request.getParameter("spotID"));
    
    parkingDAO dataObject = new parkingDAO();
    ErrorHandling errorHandler = new ErrorHandling();

    boolean pass = true;
    
    if(!errorHandler.checkSpotId(reservation.getSpotId())) {
    	request.setAttribute("errorMessage1", "spotID cannot be empty");
    	pass = false;
    }
    
     
   if(pass){
	   
	   dataObject.connect();
	   
	   if(dataObject.deleteReservation(reservation.getSpotId())) {
		   getServletContext().getRequestDispatcher("/managerDeleteReservationSuccess.jsp").forward(request, response);
	   }
	   else {
		   getServletContext().getRequestDispatcher("/Manager_Home.jsp").forward(request, response);
	   }
   }
   
   else{
	  
     getServletContext().getRequestDispatcher("/Manager_Home.jsp").forward(request, response);  
     System.out.println("Error");
   }  
  }
} 
