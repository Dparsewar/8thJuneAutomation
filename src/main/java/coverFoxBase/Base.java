package coverFoxBase;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import coverFoxUtility.Utility;

public class Base {

	
	protected  static WebDriver driver;
	
	public void launchBrowser() throws IOException
	{
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		Reporter.log("Browser window is maximizing", true);
driver.manage().window().maximize();
driver.get(Utility.readDataFromPropertyFile("url"));
driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
driver.get(Utility.readDataFromPropertyFile("url"));

driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
Reporter.log("Launching browser", true);

//Reporter.log("Wating for next page", true);
	
	}
	
	public void closeBrowser()
	{
		Reporter.log("Closing  browser", true);
		driver.quit();
	}
	
}
