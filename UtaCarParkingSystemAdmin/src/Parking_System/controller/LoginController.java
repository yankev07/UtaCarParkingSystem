package Parking_System.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Parking_System.Model.UserData;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserData data =new UserData();
		String username=request.getParameter("userName");
		System.out.println(username);
		String password=request.getParameter("password");
		System.out.println(password);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_system","root", "yankev52");
			Statement st=conn.createStatement();
			ResultSet rs;
			rs=st.executeQuery("Select userName,password,role,fname from system_user where userName='"+username+"' and password='"+password+"'");
			if(rs.next())
			{
				String uname=rs.getString(1);
		    	String pwd=rs.getString(2);
		    	String role=rs.getString(3);
		    	String name=rs.getString(4);
		    	System.out.println(role);
		    	session.setAttribute("login", name);
		    	session.setAttribute("userName",uname );
		    	if(role.equals("User"))
		    	{
				getServletContext().getRequestDispatcher("/User_Home.jsp").forward(request, response);
			    }
		    	
		    	else if(role.equals("Admin"))
		    	{
		    		
		    		getServletContext().getRequestDispatcher("/Admin_Home.jsp").forward(request, response);
		    	}
		    	
		    	else
		    	{
		    		getServletContext().getRequestDispatcher("/Admin_Home.jsp").forward(request, response);
		    		//getServletContext().getRequestDispatcher("/Manager_Home.jsp").forward(request, response);
		    	}
			}
			
			
			
			else
			{
				getServletContext().getRequestDispatcher("/unsuccess_login.jsp").forward(request, response);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
