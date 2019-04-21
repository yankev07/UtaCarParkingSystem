package functions;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CarParkingSystem_Functions {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public void CPS_Login(WebDriver driver, String sUserName, String sPassword){

		//provide username
		driver.findElement(By.xpath(prop.getProperty("Txt_Login_UserName"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Txt_Login_UserName"))).sendKeys(sUserName);
	    // Provide Password
	    driver.findElement(By.xpath(prop.getProperty("Txt_Login_Password"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Txt_Login_Password"))).sendKeys(sPassword);
	    //Click on Login button
	    driver.findElement(By.xpath(prop.getProperty("Txt_Login_Click"))).click();

	}
	
	public void EmployeeRegistration(WebDriver driver, String userName, String password, String firstName, String lastName, String role, String utaID, String phone, String email, String address, String city, String state, String zipCode) {
		
		driver.findElement(By.xpath(prop.getProperty("Lst_Registration_UserName"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_UserName"))).sendKeys(userName);
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Password"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Password"))).sendKeys(password);
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_FirstName"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_FirstName"))).sendKeys(firstName);
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_LastName"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_LastName"))).sendKeys(lastName);
	    //new Select(driver.findElement(By.name("role"))).selectByVisibleText(role);
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_UtaID"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_UtaID"))).sendKeys(utaID);
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Phone"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Phone"))).sendKeys(phone);
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Email"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Email"))).sendKeys(email);
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Address"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Address"))).sendKeys(address);
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_City"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_City"))).sendKeys(city);
	    new Select(driver.findElement(By.xpath(prop.getProperty("Lst_Registration_State")))).selectByVisibleText(state);
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Zip"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Zip"))).sendKeys(zipCode);
	    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Btn"))).click();
	    driver.findElement(By.id("txt6")).click();
	}
	
	public void adminSearchUser(WebDriver driver, String userName, String email) {
		
		driver.findElement(By.id("txt9")).click();
	    driver.findElement(By.xpath(prop.getProperty("Admin_SearchUser_UserName"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Admin_SearchUser_UserName"))).sendKeys(userName);
	    driver.findElement(By.xpath(prop.getProperty("Admin_SearchUser_Email"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Admin_SearchUser_Email"))).sendKeys(email);
	    driver.findElement(By.xpath(prop.getProperty("Admin_SearchUser_Btn"))).click();
	}
	
	public void adminUpdateUserProfile(WebDriver driver, String phone, String email, String address, String zip) {
		
		driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Phone"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Phone"))).sendKeys(phone);
	    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Email"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Email"))).sendKeys(email);
	    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Address"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Address"))).sendKeys(address);
	    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Zip"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Zip"))).sendKeys(zip);
	    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Btn"))).click();
	}
	
	public void ManagerSetUserNoShow(WebDriver driver, String userName) {
		
		driver.findElement(By.linkText("Set User to No-Show")).click();
	    driver.findElement(By.xpath(prop.getProperty("Manager_SetNoShow_Username"))).clear();
	    driver.findElement(By.xpath(prop.getProperty("Manager_SetNoShow_Username"))).sendKeys(userName);
	    driver.findElement(By.xpath(prop.getProperty("Manager_SetNoShow_Btn"))).click();
	    driver.findElement(By.id("txt7")).click();
	}


}
