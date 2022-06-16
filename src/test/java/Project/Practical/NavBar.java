package Project.Practical;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

//@Listeners(Listeners.class)
public class NavBar extends Base{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	LandingPage lp;
	
	
	@BeforeTest
	public void openURL() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		lp = new LandingPage(driver);
		}
	
	@Test
	public void navBar() throws IOException 
	{
	
		//We can invoke methods of any class by 1.inheriting class or 2.creating object of that class
		
		if(lp.pagePopup().isDisplayed()) {
			lp.pagePopup().click();
		}
		Assert.assertTrue(lp.navBarOptions().isDisplayed());
		log.info("NavBar test case");
		//System.out.println(lp.coursesTitleText().getText());
		Assert.assertEquals(lp.coursesTitleText().getText(), "FEATURED COURSES"); //-  assertEquals(actual, expected)
	}
	
	@Test
	public void header() throws IOException
	{
		Assert.assertEquals(lp.headerName().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
