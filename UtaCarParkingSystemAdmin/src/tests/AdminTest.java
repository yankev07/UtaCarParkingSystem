package tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.firefox.marionette", "file:///GeckoSelenium/geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAdminUpdateProfile() throws Exception {
    driver.get(baseUrl + "/UtaCarParkingSystemAdmin/");
    driver.findElement(By.xpath("(//h2[@id='txt2'])[2]")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("");
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("");
    driver.findElement(By.id("btn1")).click();
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("funnyTester");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("itskevin");
    driver.findElement(By.name("fname")).clear();
    driver.findElement(By.name("fname")).sendKeys("Kevin");
    driver.findElement(By.name("lname")).clear();
    driver.findElement(By.name("lname")).sendKeys("Yanogo");
    driver.findElement(By.name("id")).clear();
    driver.findElement(By.name("id")).sendKeys("1001675700");
    driver.findElement(By.name("phone")).clear();
    driver.findElement(By.name("phone")).sendKeys("0000011111");
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("200 Cooper St, Arlington");
    driver.findElement(By.name("city")).clear();
    driver.findElement(By.name("city")).sendKeys("Arlington");
    driver.findElement(By.id("btn1")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("kevin.yanogo@gmail.com");
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("200, Cooper ST, Arlinton TX");
    driver.findElement(By.name("city")).clear();
    driver.findElement(By.name("city")).sendKeys("Arlington");
    new Select(driver.findElement(By.name("state"))).selectByVisibleText("TX");
    driver.findElement(By.name("zip")).clear();
    driver.findElement(By.name("zip")).sendKeys("76010");
    driver.findElement(By.id("btn1")).click();
    driver.findElement(By.id("txt6")).click();
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("funnyTester");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("itskevin");
    driver.findElement(By.id("btn1")).click();
    driver.findElement(By.id("txt9")).click();
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("user1");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("kevin.yanogo@gmail.com");
    driver.findElement(By.id("btn2")).click();
    driver.findElement(By.name("phone")).clear();
    driver.findElement(By.name("phone")).sendKeys("0000000000");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("email@gmail.com");
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("200, Cooper ST, Arlinton TX");
    driver.findElement(By.name("zip")).clear();
    driver.findElement(By.name("zip")).sendKeys("76019");
    driver.findElement(By.id("btn2")).click();
    driver.findElement(By.id("txt7")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
