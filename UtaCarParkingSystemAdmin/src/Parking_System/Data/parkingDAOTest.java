package Parking_System.Data;

import static org.junit.Assert.*;

//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import Parking_System.Data.parkingDAO;

@RunWith(JUnitParamsRunner.class)

public class parkingDAOTest {

	parkingDAO p = new parkingDAO();

    @Before
    public void connectTest()
    {
         
     assertTrue(p.connect());
     //assertEquals("jdbc:mysql://localhost/parking_system?user=root&password=root",p.getConnection(null, null, null));      
    }
    
    @Test
    public void addParkingAreaTest() 
    {
        assertTrue(p.addParkingArea("XYZ",300));
        assertFalse(p.addParkingArea("Abcdefghddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd",12));
    }
    
    @Test
    public void registerUserTest()
    {
        assertTrue(p.registerUser("uvw123", "prakhar@92", "U", "Sapre", "Basic","abc123","User", "1001508209", "6822484919", "prakhar@gmail.com", "601 Summit Ave", "Arlington", "Texas", "76013"));
        assertFalse(p.registerUser("prakhar123", "prakhar@92", "Prakhar", "Basic","abc123", "Sapre", "User", "1001508209", "6822484919", "prakhar@gmail.com", "601 Summit Ave", "Arlington", "Texas", "76013"));
    }
    
    
    @Test
    public void modifyParkingAreaTest()
    {
        assertTrue(p.modifyparkingArea("West Garage", 1200, 3, 2, 5, 10));
        assertFalse(p.modifyparkingArea("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 200, 3, 2, 5, 10));
    }
    
    @Test
    public void modifyReservationTest()
    {
        assertTrue(p.modifyReservation("West Garage", "WG00001", "user3", "YES", "NO", "YES", "YES", 1));
        assertFalse(p.modifyReservation("West Garage", "WG00001", "user3", "YEEEES", "NO", "YES", "YES", 1));
    }
    
    @Test
    public void updateAdminProfileTest()
    {
        assertTrue(p.updateAdminProfile("user001", "kevin01", "2105895893", "email@gmail.com", "807 Spaniolo Dr", 76010));
        assertFalse(p.updateAdminProfile("user001", "kevin01", "2105895893", "email@gmail.com", "807 Spaniolo Dr", 760101010));
    }
    
    @Test
    public void editUserProfileTest()
    {
        assertTrue(p.editUserProfile("user001", "2105895893", "email@gmail.com", "807 Spaniolo Dr", 76010));
        assertFalse(p.editUserProfile("user001", "2105895893", "email@gmail.com", "807 Spaniolo Dr", 760101010));
    }
    
    @Test
    public void setNoShowTest()
    {
        assertTrue(p.setNoShow("test01"));
        assertFalse(p.setNoShow("0101010101"));
    }
    
    @Test
    public void setOverdueTest()
    {
        assertTrue(p.setOverdue("test01"));
        assertFalse(p.setOverdue("0101010101"));
    }
    
    @Test
    public void revokeUserTest()
    {
        assertTrue(p.revokeUser("test01", "email@gmail.com", "too many no shows"));
        assertFalse(p.revokeUser("test01", "email", "too many no shows"));
    }
    
    @Test
    public void activateRevokedUserTest()
    {
        assertTrue(p.activateRevokedUser("test01", "email@gmail.com"));
        assertFalse(p.activateRevokedUser("test01", "email"));
    }
    
    @Test
    public void makeSpotUnavailableTest()
    {
        assertTrue(p.makeSpotUnavailable("Nedderman", 3));
        assertFalse(p.makeSpotUnavailable("Hello", 1));
    }
    
    @Test
    public void changeUserRoleTest()
    {
        assertTrue(p.changeUserRole("test01", "Kevin", "Yanogo", "email@gmail.com", "Manager"));
        assertFalse(p.changeUserRole("test01", "Kevin", "Yanogo", "email", "aaaaaaaaaaaaaaa"));
    }
    
    @Test
    public void deleteReservationTest()
    {
        assertTrue(p.deleteReservation("ND00001"));
        assertFalse(p.deleteReservation("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

}
