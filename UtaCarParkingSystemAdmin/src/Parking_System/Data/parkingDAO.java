package Parking_System.Data;

import java.sql.Connection;		
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.sql.PreparedStatement;

import Parking_System.Model.UserData;

public class parkingDAO{

	 static Connection conn=null;

	 public static boolean connect(){

	 	String db="parking_system";
    	String user="root";
    	String pass="yankev52";
     	return getConnection(db,user,pass);
	 }

	 private static boolean getConnection(String db,String user,String password){

	 	System.out.println("jdbc:mysql://localhost/"+db+"?user="+user+"&password="+password);

	 	try{
	 		Class.forName("com.mysql.cj.jdbc.Driver");
	 		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db, user, password);
	 		System.out.println(conn);
	 	}
	 	catch(Exception e){
	 		System.out.println("..."+e);
	 	}

	 	if(conn != null){
	 		return true;
	 	}
	 	else{
	 		return false;
	 	}
	 }

	 public static boolean addParkingArea(String name,int space){

	 	try{

	 		String query="INSERT INTO parking values (?,?,0,0,0,0)";
	 		System.out.println(conn);
	 		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(query);
	 		ps.setString(1, name);
	 		ps.setInt(2, space);
	 		int i=ps.executeUpdate();

	 		if(i > 0){
	 			 System.out.println("Area Added successfully");
	 			 return true;
	 		}
	 		else{
	 			System.out.println("unsuccessful");
	 			return false;
	 		}
	 	}

	 	catch(Exception e){
	 		return false;
	 	}
	 }

	 public static boolean registerUser(String userName,String password,String fname,String lname,String parkingType,String license,String role,String UTAID,String Phone,String email, String address,String city,String state,String Zip){

	 	try{

	 		UserData data=new UserData();
	 		String query="INSERT INTO system_user (userName,password,fname,lname,parking,license,role,id,phone,email,address,city,state,zip,noShows,overdue) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,0)";
	 		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(query);
	 		ps.setString(1, userName);
	 		ps.setString(2, password);
	 		ps.setString(3, fname);
	 		ps.setString(4, lname);
	 		ps.setString(5, parkingType);
	 		ps.setString(6, license);
	 		ps.setString(7, role);
	 		ps.setString(8, UTAID);
	 		ps.setString(9, Phone);
	 		ps.setString(10, email);
	 		ps.setString(11,address);
	 		ps.setString(12, city);
	 		ps.setString(13, state);
	 		ps.setInt(14, Integer.parseInt(Zip));
	 		int i=ps.executeUpdate();

	 		if(i > 0){
	 			return true;
	 		}
	 		else{
	 			return false;
	 		}
	 	}

	 	catch(Exception e){
	 		return false;
	 	}
	 }

	 public static boolean modifyparkingArea(String name, int space, int floors, int occupied, int unavailable, int reserved){

	 	try{

	 		String query="Update parking set space=?,floors=?,occupied=?,unavailable=?,reserved=? where AreaName=?";
	 		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(query);
	 		ps.setInt(1, space);
	 		ps.setInt(2, floors);
	 		ps.setInt(3, occupied);
	 		ps.setInt(4, unavailable);
	 		ps.setInt(5, reserved);
	 		ps.setString(6, name);
	 		int i=ps.executeUpdate();
	 		if(i > 0){
	 			return true;
	 		}

	 		else{
	 			return false;
	 		}
	 	}

	 	catch(Exception e){
	 		return false;
	 	}
	 }

	 public static boolean modifyReservation(String areaName, String spotId, String user, String camera, String cart, String history, String available, int floor){

	 	try{

	 		String query="update reservations set AreaName=?,user=?,camera=?,cart=?,history=?,available=?,floor=? where spotid=?";
	 		PreparedStatement ps=conn.prepareStatement(query);
        	ps.setString(1, areaName);
        	ps.setString(2, user);
        	ps.setString(3, camera);
        	ps.setString(4, cart);
        	ps.setString(5, history);
        	ps.setString(6, available);
        	ps.setInt(7, floor);
        	ps.setString(8, spotId);
        	int i=ps.executeUpdate();

        	if(i > 0){
        		return true;
        	}
        	else{
        		return false;
        	}
	 	}

	 	catch(Exception e){
	 		return false;
	 	}

	 }

	 public static boolean updateAdminProfile(String userName,String password,String phone,String email,String address,int zip){

	 	try{

	 		String query="update system_user set password=?,phone=?,email=?,address=?,zip=? where userName=?";
	 		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(query);
	 		ps.setString(1, password);
	 		ps.setString(2, phone);
	 		ps.setString(3, email);
	 		ps.setString(4, address);
	 		ps.setInt(5, zip);
	 		ps.setString(6, userName);
	 		int i=ps.executeUpdate();

	 		if(i > 0){
	 			return true;
	 		}
	 		else{
	 			return false;
	 		}
	 	}

	 	catch(Exception e){
	 		return false;
	 	}
	 }

	 public static boolean editUserProfile(String userName,String phone,String email,String address,int zip){

	 	try{

	 		String query="update system_user set phone=?,email=?,address=?,zip=? where userName=?";
	 		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(query);
	 		ps.setString(1, phone);
	 		ps.setString(2, email);
	 		ps.setString(3, address);
	 		ps.setInt(4, zip);
	 		ps.setString(5, userName);
	 		int i=ps.executeUpdate();

	 		if(i > 0){
	 			return true;
	 		}
	 		else{
	 			return false;
	 		}
	 	}

	 	catch(Exception e){
	 		return false;
	 	}
	 }

	 public static boolean deleteReservation(String spotId){

	 	try{

	 		String query="Delete from reservations where spotid=?";
	 		PreparedStatement ps=conn.prepareStatement(query);
      		ps.setString(1, spotId);
      		int i=ps.executeUpdate();

      		if(i > 0){
      			return true;
      		}
      		else{
      			return false;
      		}
	 	}

	 	catch(Exception e){
	 		return false;
	 	}
	 }

	 public static boolean setNoShow(String userName){

	 	try{

	 		String query="update system_user set noShows = noShows + 1 where userName=?";
	 		PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, userName);
			int i=ps.executeUpdate();

			if(i > 0){
      			return true;
      		}
      		else{
      			return false;
      		}
	 	}

	 	catch(Exception e){
	 		return false;
	 	}
	 }

	 public static boolean setOverdue(String userName){

	 	try{
	 		String query="update system_user set overdue = overdue + 1 where userName=?";
	 		PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, userName);
			int i=ps.executeUpdate();

			if(i > 0){
      			return true;
      		}
      		else{
      			return false;
      		}
	 	}

	 	catch(Exception e){
	 		return false;
	 	}
	 }

	 //public int getNoShows(String userName){}
	 //public int getOverdue(String userName){}

	 public static boolean makeSpotUnavailable(String areaName, int number){

	 	try{

	 		String query="update parking set unavailable = unavailable + ? where AreaName = ?";
	 		PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, number);
        	ps.setString(2, areaName);
			int i=ps.executeUpdate();

			if(i > 0){
      			return true;
      		}
      		else{
      			return false;
      		}
	 	}

	 	catch(Exception e){
	 		return false;
	 	}
	 }

	 public static boolean changeUserRole(String userName, String firstName, String lastName, String email, String role){

	 	try{

	 		String query="update system_user set role=? where userName=?";
	 		PreparedStatement ps=conn.prepareStatement(query);
	 		ps.setString(1, role);
	 		ps.setString(2, userName);
	 		int i=ps.executeUpdate();

			if(i > 0){
      			return true;
      		}
      		else{
      			return false;
      		}
	 	}

	 	catch(Exception e){
	 		return false;
	 	}
	 }

	 public static boolean revokeUser(String userName, String email, String reason){

	 	try{

	 		String query="INSERT INTO revoked_users (userName,email,reason) values (?,?,?)";
	 		PreparedStatement ps=conn.prepareStatement(query);
	 		ps.setString(1, userName);
		  	ps.setString(2, email);
		  	ps.setString(3, reason);
		  	int i=ps.executeUpdate();

			if(i > 0){
      			return true;
      		}
      		else{
      			return false;
      		}
	 	}

	 	catch(Exception e){
	 		return false;
	 	}
	 }

	 public static boolean activateRevokedUser(String userName, String email){

	 	try{

	 		String query = "Delete from revoked_users where userName=? and email=?";
	 		PreparedStatement ps=conn.prepareStatement(query);
	 		ps.setString(1, userName);
          	ps.setString(2, email);
          	int i=ps.executeUpdate();

			if(i > 0){
      			return true;
      		}
      		else{
      			return false;
      		}
	 	}

	 	catch(Exception e){
	 		return false;
	 	}
	 }

}
