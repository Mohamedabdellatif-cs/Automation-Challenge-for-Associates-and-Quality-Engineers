package Maven_Testng.Maven_Testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	 private WebDriver driver=null;

	    @BeforeMethod
	    public void setUp() {
	    
	    	
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\eclipse-workspace\\Maven_Testng\\service\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        
	        driver.get("https://www.saucedemo.com/");
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }

	    @Test
	    public void testElementsPresence() {
	       
	        WebElement usernameField = driver.findElement(By.id("user-name"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.id("login-button"));

	        Assert.assertTrue(usernameField.isDisplayed());
	        Assert.assertTrue(passwordField.isDisplayed());
	        Assert.assertTrue(loginButton.isDisplayed());
	    }

	    @Test
	    public void testValidLogin() {
	    
	        WebElement usernameField = driver.findElement(By.id("user-name"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.id("login-button"));

	        usernameField.sendKeys("standard_user");
	        passwordField.sendKeys("secret_sauce");
	        loginButton.click();

	       
	        WebElement swagLabsDiv = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
	        Assert.assertTrue(swagLabsDiv.isDisplayed());
	    }

	    @Test
	    public void testInvalidLogin() {
	    
	        WebElement usernameField = driver.findElement(By.id("user-name"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.id("login-button"));

	        usernameField.sendKeys("invalid_user");
	        passwordField.sendKeys("invalid_password");
	        loginButton.click();

	        
	        WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container.error"));
	        Assert.assertTrue(errorMessage.isDisplayed());
	        Assert.assertTrue(errorMessage.getText().contains("Epic sadface: Username and password do not match any user in this service"));
	    }

	    @Test
	    public void testEmptyUsername() {
	     
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.id("login-button"));

	        passwordField.sendKeys("secret_sauce");
	        loginButton.click();

	     
	        WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container.error"));
	        Assert.assertTrue(errorMessage.isDisplayed());
	        Assert.assertTrue(errorMessage.getText().contains("Epic sadface: Username is required"));
	    }

	    @Test
	    public void testEmptyPassword() {
	        
	        WebElement usernameField = driver.findElement(By.id("user-name"));
	        WebElement loginButton = driver.findElement(By.id("login-button"));

	        usernameField.sendKeys("standard_user");
	        loginButton.click();

	        
	        WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container.error"));
	        Assert.assertTrue(errorMessage.isDisplayed());
	        Assert.assertTrue(errorMessage.getText().contains("Epic sadface: Password is required"));
	    }
}
//Maven_Testng.Maven_Testng.NewTest