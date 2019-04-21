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

public class ManagerConfigurationFileTest extends CarParkingSystem_Functions {
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
  public void testManagerNoShow() throws Exception {
    driver.get(sAppURL);
    
    driver.findElement(By.xpath(prop.getProperty("Txt_Registration_Hyperlink"))).click();
    
    EmployeeRegistration(driver, "amazingTester", "helloworld", "Kevin", "Yanogo", "regexp:Admin\\s+", "1001675766", "2105895893", "kevin.yanogo@gmail.com", "807 Spaniolo Dr, Arlington TX,", "Arlington", "TX", "76010");
    
    CPS_Login(driver, "amazingTester", "helloworld");
    
    ManagerSetUserNoShow(driver, "user3");
    
    
    }
  
}
