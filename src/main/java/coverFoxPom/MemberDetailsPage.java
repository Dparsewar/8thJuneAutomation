package coverFoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class MemberDetailsPage {

	
	//variable//Contructor//methods
	@FindBy(xpath="//select[@id='Age-You']") private WebElement agedropdown;
	
	@FindBy(xpath="//div[text()='Next']") private WebElement button;
	
	public MemberDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Genderdropdown(String age)
	{
		Reporter.log("Handling Age drop down ", true);
		Select c= new Select(agedropdown);
		
		c.selectByValue(age+"y");
	}
	
	
	public void nextbutton()
	{
		Reporter.log("Clicking on Next button on memberdetails page", true);
		button.click();
	}
}
