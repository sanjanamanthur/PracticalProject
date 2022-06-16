package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	
	
	public LandingPage(WebDriver driver) {
		this.driver=driver; // TODO Auto-generated constructor stub
	}
	
	
	private By popup = By.xpath("//button[text()='NO THANKS']");
	public WebElement pagePopup()
	{
		return driver.findElement(popup); 
	}
	
	private By loginButton = By.cssSelector("a[href*='sign_in']");
	public WebElement loginButtonClick()
	{
		return driver.findElement(loginButton); 
	}
	
	private By registerButton = By.cssSelector("a[href*='sign_up']");
	public WebElement registerButtonClick()
	{
		return driver.findElement(registerButton);	
	}
	
	private By coursesTitle = By.cssSelector(".text-center>h2");
	public WebElement coursesTitleText()
	{
		return driver.findElement(coursesTitle);
	}
	
	private By navBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	public WebElement navBarOptions()
	{
		return driver.findElement(navBar);
	}
	
	private By header = By.cssSelector(".col-sm-6.col-md-8.hidden-xs.video-banner>h3");
	public WebElement headerName()
	{
		return driver.findElement(header);
	}
	
}
