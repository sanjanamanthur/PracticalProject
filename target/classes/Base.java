package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	public WebDriver driver;
	@SuppressWarnings("deprecation")
	public Properties prop;

	public WebDriver initializeDriver() throws IOException 
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser"); // - this will get browser details from property file
		// String browserName = System.getProperty("browser"); //- this will get browser
		// details from maven command
		// mvn test -Dbrowser=chrome

		if (browserName.equals("Chrome")) {
			// execute in chrome browser
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			// ChromeOptions options = new ChromeOptions();
			// options.addArguments("--headless");
			driver = new ChromeDriver();

		}

		else if (browserName == "Firefox") {

			// execute in chrome Firefox

		} else if (browserName == "Edge") {
			// execute in chrome Edge
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // -- its deprecated
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver; // create driver globally - give knowledge of which browser to initialize -
						// return driver so that who ever uses this class can use driver

	}

	public String getScreenShotPath(String methodName, WebDriver driver) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + methodName + ".png";

		FileUtils.copyFile(ss, new File(destinationFile));
		return destinationFile;
	}

}
