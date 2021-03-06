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


@WebServlet("/addParkingAreaController")
public class addParkingAreaController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Parking parking = new Parking();
		
		parking.setAreaName(request.getParameter("addName"));
		parking.setSpace(Integer.parseInt(request.getParameter("space")));
		
		parkingDAO dataObject = new parkingDAO();
		ErrorHandling errorHandler = new ErrorHandling();
		
		boolean pass = true;
		
		if(!errorHandler.checkParkingAreaName(parking.getAreaName())) {
			pass = false;
		}
		if(!errorHandler.checkZip(String.valueOf(parking.getSpace()))) {
			pass = false;
		}
		
		if(pass) {
			dataObject.connect();
			if(dataObject.addParkingArea(parking.getAreaName(), parking.getSpace())) {
				System.out.println("Area Added successfully");
		    	getServletContext().getRequestDispatcher("/addParkingSuccess.jsp").forward(request, response);
			}
			else {
				System.out.println("unsuccessful");
				getServletContext().getRequestDispatcher("/Manager_Home.jsp").forward(request, response);
			}
		}
		else {
			System.out.println("unsuccessful");
			getServletContext().getRequestDispatcher("/Manager_Home.jsp").forward(request, response);
		}
		 
	}

}
