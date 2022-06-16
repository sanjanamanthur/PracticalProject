package stepDefinations;


import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

import org.junit.runner.RunWith;


public class MyStepDefinitions extends Base{

	@Given("^Launch the Chrome browser$")
	public void launch_the_Chrome_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver= initializeDriver();
		System.out.println("test");
	}

	@And("^Open test \"([^\"]*)\"$")
	public void open_test_url(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@And("^Click on Login button$")
	public void click_on_Login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage lp = new LandingPage(driver);
		if(lp.pagePopup().isDisplayed()) 
		{
			lp.pagePopup().click();
		}
		
		lp.loginButtonClick().click();
	}

	@When("^Enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_and(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LoginPage loginpg = new LoginPage(driver);
		loginpg.emailTextBox().sendKeys(arg1);
		//log.info("Homepage test case");
		loginpg.pswdTextFeild().sendKeys(arg2);
		
	}

	@And("^Click on Login buttom$")
	public void click_on_Login_buttom() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LoginPage loginpg = new LoginPage(driver);
		loginpg.loginButton().click();
	}

	@Then("^User should be loggin in$")
	public void user_should_be_loggin_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}