package coverFoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlanPage {
//Variable
	//Construcotr
	//methods
	
	
	@FindBy(xpath="//div[@class='next-btn']") private WebElement next;//variable declaaration
	
	public CoverFoxHealthPlanPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void nextbuttons()
	{
		Reporter.log("Clicking on Next button", true);
		next.click();
	}
}
