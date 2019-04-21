package tests;

import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import functions.CarParkingSystem_Functions;

public class AdminSharedUIMapTest extends CarParkingSystem_Functions {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public static String sAppURL, sSharedUIMapPath;

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.firefox.marionette", "file:///GeckoSelenium/geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    prop = new Properties();
    
    // Load Configuration file
    prop.load(new FileInputStream("./Configuration/CPS_Configuration.properties"));
    // get Application URL
    sAppURL = prop.getProperty("sAppURL");
    // get sharedUIMap folder path
    sSharedUIMapPath = prop.getProperty("SharedUIMap");
    
    // Load Shared UI Map
    prop.load(new FileInputStream(sSharedUIMapPath));
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testAdminUpdateProfile() throws Exception {
    driver.get(sAppURL);
    
    driver.findElement(By.xpath(prop.getProperty("Txt_Registration_Hyperlink"))).click();
    
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_UserName"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_UserName"))).sendKeys("funnyTester");
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Password"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Password"))).sendKeys("itskevin");
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_FirstName"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_FirstName"))).sendKeys("Kevin");
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_LastName"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_LastName"))).sendKeys("Yanogo");
    //new Select(driver.findElement(By.name("role"))).selectByVisibleText(role);
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_UtaID"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_UtaID"))).sendKeys("1001675766");
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Phone"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Phone"))).sendKeys("2105895893");
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Email"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Email"))).sendKeys("kevin.yanogo@gmail.com");
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Address"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Address"))).sendKeys("807 Spaniolo Dr, Arlington TX,");
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_City"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_City"))).sendKeys("Arlington");
    new Select(driver.findElement(By.xpath(prop.getProperty("Lst_Registration_State")))).selectByVisibleText("TX");
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Zip"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Zip"))).sendKeys("76010");
    driver.findElement(By.xpath(prop.getProperty("Lst_Registration_Btn"))).click();
    driver.findElement(By.id("txt6")).click();
    
    driver.findElement(By.xpath(prop.getProperty("Txt_Login_UserName"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Txt_Login_UserName"))).sendKeys("funnyTester");
    driver.findElement(By.xpath(prop.getProperty("Txt_Login_Password"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Txt_Login_Password"))).sendKeys("itskevin");
    driver.findElement(By.xpath(prop.getProperty("Txt_Login_Click"))).click();
    
    driver.findElement(By.id("txt9")).click();
    driver.findElement(By.xpath(prop.getProperty("Admin_SearchUser_UserName"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Admin_SearchUser_UserName"))).sendKeys("user1");
    driver.findElement(By.xpath(prop.getProperty("Admin_SearchUser_Email"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Admin_SearchUser_Email"))).sendKeys("kevin.yanogo@gmail.com");
    driver.findElement(By.xpath(prop.getProperty("Admin_SearchUser_Btn"))).click();
    
    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Phone"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Phone"))).sendKeys("0000000000");
    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Email"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Email"))).sendKeys("email@gmail.com");
    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Address"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Address"))).sendKeys("200, Cooper ST, Arlinton TX");
    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Zip"))).clear();
    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Zip"))).sendKeys("76019");
    driver.findElement(By.xpath(prop.getProperty("Admin_EditUser_Btn"))).click();
    
    driver.findElement(By.id("txt7")).click();
    
  }
  
  
  

}
