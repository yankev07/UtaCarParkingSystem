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

@WebServlet("/modifyReservationPageController")
public class modifyReservationPageController extends HttpServlet{
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
    HttpSession session = request.getSession(); 
    
    Reservations reservation = new Reservations();
    
    reservation.setAreaName(request.getParameter("AreaName"));
    reservation.setSpotId(request.getParameter("spotid"));
    reservation.setUser(request.getParameter("user"));
    reservation.setCamera(request.getParameter("camera"));
    reservation.setCart(request.getParameter("cart"));
    reservation.setHistory(request.getParameter("history"));
    reservation.setAvailable(request.getParameter("available"));
    reservation.setFloor(Integer.parseInt(request.getParameter("floor")));
    
    boolean pass = true;
    
    parkingDAO dataObject = new parkingDAO();
    ErrorHandling errorHandler = new ErrorHandling();
    
    if(!errorHandler.checkParkingAreaName(reservation.getAreaName())) {
    	request.setAttribute("errorMessage8", "areaName cannot be empty");
    	pass = false;
    }
    if(!errorHandler.checkSpotId(reservation.getSpotId())) {
    	request.setAttribute("errorMessage9", "SpotID cannot be empty");
    	pass = false;
    }
//    if(!errorHandler.checkUserName(reservation.getUser())) {
//    	request.setAttribute("errorMessage10", "user cannot be empty");
//    	pass = false;
//    }
    if(!errorHandler.checkUserNameLength(reservation.getUser())) {
    	request.setAttribute("errorMessage10", "user format error");
    	pass = false;
    }
    if(!errorHandler.checkYesNo(reservation.getCamera())) {
    	request.setAttribute("errorMessage13", "camera yes/no only");
    	pass = false;
    }
    if(!errorHandler.checkYesNo(reservation.getCart())) {
    	request.setAttribute("errorMessage13", "cart yes/no only");
    	pass = false;
    }
    if(!errorHandler.checkYesNo(reservation.getHistory())) {
    	request.setAttribute("errorMessage13", "history yes/no only");
    	pass = false;
    }
    if(!errorHandler.checkYesNo(reservation.getAvailable())) {
    	request.setAttribute("errorMessage13", "available yes/no only");
    	pass = false;
    }
   
    
    if(pass){
    	
    	dataObject.connect();
    	
    	if(dataObject.modifyReservation(reservation.getAreaName(), reservation.getSpotId(), reservation.getUser(), reservation.getCamera(), reservation.getCart(), reservation.getHistory(), reservation.getAvailable(), reservation.getFloor())) {
    		response.sendRedirect("modifyReservationPageSuccess.jsp");
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
