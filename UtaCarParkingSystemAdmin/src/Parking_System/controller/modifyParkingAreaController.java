package Parking_System.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Parking_System.Model.Parking;
import Parking_System.Utils.ErrorHandling;
import Parking_System.Data.parkingDAO;

@WebServlet("/modifyParkingAreaController")
public class modifyParkingAreaController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Parking parking = new Parking();
		parking.setAreaName(request.getParameter("addName"));
		parking.setSpace(Integer.parseInt(request.getParameter("space")));
		parking.setFloors(Integer.parseInt(request.getParameter("floors")));
		parking.setOccupied(Integer.parseInt(request.getParameter("occupied")));
		parking.setUnavailable(Integer.parseInt(request.getParameter("unavailable")));
		parking.setReserved(Integer.parseInt(request.getParameter("reserved")));
		
		parkingDAO dataObject = new parkingDAO();
		ErrorHandling errorHandler = new ErrorHandling();
		
		boolean pass = true;
		
		if(!errorHandler.checkParkingAreaName(parking.getAreaName())) {
			pass = false;
		}
		if(!errorHandler.checkZip(String.valueOf(parking.getSpace()))) {
			pass = false;
		}
		if(!errorHandler.checkZip(String.valueOf(parking.getFloors()))) {
			pass = false;
		}
		if(!errorHandler.checkZip(String.valueOf(parking.getOccupied()))) {
			pass = false;
		}
		if(!errorHandler.checkZip(String.valueOf(parking.getUnavailable()))) {
			pass = false;
		}
		if(!errorHandler.checkZip(String.valueOf(parking.getReserved()))) {
			pass = false;
		}
		
		
		if(pass) {
			dataObject.connect();
			if(dataObject.modifyparkingArea(parking.getAreaName(), parking.getSpace(), parking.getFloors(), parking.getOccupied(), parking.getUnavailable(), parking.getReserved())) {
				System.out.println("Modified successfully");
		    	getServletContext().getRequestDispatcher("/modifyParkingSuccess.jsp").forward(request, response);
			}
			else {
				request.setAttribute("error","No Such Area Found" );
				 getServletContext().getRequestDispatcher("/modifyParkingArea.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("error","Unsuccessful" );
			getServletContext().getRequestDispatcher("/modifyParkingArea.jsp").forward(request, response);
		}
	}
}
