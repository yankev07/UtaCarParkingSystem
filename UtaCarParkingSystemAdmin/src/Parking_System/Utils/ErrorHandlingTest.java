package Parking_System.Utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

//import static org.junit.Assert.*;

//import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ErrorHandlingTest {
   //ErrorHandling e=new ErrorHandling();
//   @Test
//   public void checkUserNameTest()
//   {
//       assertFalse(ErrorHandling.checkUserName(""));
//       assertTrue(ErrorHandling.checkUserName("Abc"));
//   }
   
   @Test
   public void checkUserNameLengthTest()
   {
	   assertFalse(ErrorHandling.checkUserNameLength("ab"));
	   assertTrue(ErrorHandling.checkUserNameLength("Abcd"));
   }
   
   @Test
   public void checkPasswordTest()
   {
	   assertFalse(ErrorHandling.checkPassword(""));
	   assertTrue(ErrorHandling.checkPassword("Abc"));
   }
   
   @Test
   public void checkPasswordMatchTest()
   {
	   assertFalse(ErrorHandling.checkPasswordMatch("Abc"));
	   assertTrue(ErrorHandling.checkPasswordMatch("Akshat@95"));
   }
   
   @Test
   public void checkFnameTest()
   {
	   assertFalse(ErrorHandling.checkFname(""));
	   assertTrue(ErrorHandling.checkFname("Abc"));
   }
   
   @Test
   public void checkLnameTest()
   {
	   assertFalse(ErrorHandling.checkLname(""));
	   assertTrue(ErrorHandling.checkLname("Abc"));
   }
   
   @Test
   public void checkUATIdTest()
   {
	   assertFalse(ErrorHandling.checkUtaId(""));
	   assertTrue(ErrorHandling.checkUtaId("Abc"));
   }
   
   @Test
   public void checkUATIdLengthTest()
   {
	   assertFalse(ErrorHandling.checkUtaIdLength("100155650766"));
	   assertTrue(ErrorHandling.checkUtaIdLength("1001556506"));
   }
   
   @Test
   public void checkPhoneTest()
   {
	   assertFalse(ErrorHandling.checkPhone(""));
	   assertTrue(ErrorHandling.checkPhone("Abc"));
   }
   
   @Test
   public void checkPhoneLengthTest()
   {
	   assertFalse(ErrorHandling.checkPhoneLength("100155650766"));
	   assertTrue(ErrorHandling.checkPhoneLength("1001556506"));
   }
   
   @Test
   public void checkEmailTest()
   {
	   assertFalse(ErrorHandling.checkEmail(""));
	   assertTrue(ErrorHandling.checkEmail("Abc"));
   }
   
   @Test
   public void checkEmailMatchTest()
   {
	   assertFalse(ErrorHandling.checkEmailMatch("Abc"));
	   assertTrue(ErrorHandling.checkEmailMatch("abc@gmail.com"));
   }
   
   @Test
   public void checkAddressTest()
   {
	   assertFalse(ErrorHandling.checkAddress(""));
	   assertTrue(ErrorHandling.checkAddress("Abc"));
   }
   
   @Test
   public void checkCityTest()
   {
	   assertFalse(ErrorHandling.checkCity(""));
	   assertTrue(ErrorHandling.checkCity("Abc"));
   }
   
   @Test
   public void checkZipTest()
   {
	   assertFalse(ErrorHandling.checkZip(""));
	   assertTrue(ErrorHandling.checkZip("Abc"));
   } 
   
   @Test
   public void checkZipLengthTest() 
   {
	   assertFalse(ErrorHandling.checkZipLength("123"));
	   assertTrue(ErrorHandling.checkZipLength("76013"));
   }
   @Test
   public void checkDriverLicenseTest()
   {
	   assertFalse(ErrorHandling.checkDriverLicense(""));
	   assertTrue(ErrorHandling.checkDriverLicense("Abc"));
   }
   
}
