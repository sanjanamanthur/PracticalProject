package Project.Practical;

import java.io.IOException;
//import org.apache.logging.log4j.core.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;


public class HomePage extends Base{
	
	public static Logger log = LogManager.getLogger(HomePage.class);  //log4j
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void openURL() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		}

	@Test(dataProvider="getData")
	public void basePageNavigation(String UserName, String Password) throws IOException 
	{
		
		//We can invoke methods of any class by 1.inheriting class or 2.creating object of that class
		LandingPage lp = new LandingPage(driver);
		
		//lp.popup = By.xpath("xyz"); - Here we can edit assigned values for popup as they are declared as private
		//lp.loginButton = By.xpath("xyz");
		
		//<Properties>
	    //<Property name="basepath">.\src\main\java\resources</Property>              
	  //</Properties> 
		
		if(lp.pagePopup().isDisplayed()) 
		{
			lp.pagePopup().click();
		}
		
		lp.loginButtonClick().click();
		
		LoginPage loginpg = new LoginPage(driver);
		loginpg.emailTextBox().sendKeys(UserName);
		log.info("Homepage test case");
		loginpg.pswdTextFeild().sendKeys(Password);
		loginpg.loginButton().click();
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		data[0][0]="asd@gmail.com";
		data[0][1]="password1";
		
		data[1][0]="qwe@gmail.com";
		data[1][1]="password2";
		return data;
	}
	
	
}
