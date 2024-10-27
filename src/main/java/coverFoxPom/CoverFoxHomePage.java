package coverFoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage {

	
	
	//Variable
	//Constructor
	//Methods
	
	@FindBy(xpath="//div[text()='Male']") private WebElement Gender;
	
	public CoverFoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void ClickonGender()
	{
		Reporter.log("Clicking on Gender button", true);
		Gender.click();
	}
	
		
	
}
