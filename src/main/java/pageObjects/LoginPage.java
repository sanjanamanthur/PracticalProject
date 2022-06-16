package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver; // TODO Auto-generated constructor stub
	}
	
	private By email = By.id("user_email");
	public WebElement emailTextBox()
	{
		return driver.findElement(email); 
	}
	
	private By pswd = By.id("user_password");	
	public WebElement pswdTextFeild()
	{
		return driver.findElement(pswd); 
	}
	
	private By login = By.cssSelector("input[value='Log In']");	
	public WebElement loginButton()
	{
		return driver.findElement(login); 
	}
}
