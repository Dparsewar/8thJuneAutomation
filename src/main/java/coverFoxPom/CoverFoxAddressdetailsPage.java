package coverFoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressdetailsPage {

	//varaible,constructor,methods
	
	@FindBy(xpath="//input[@placeholder='6 Digit Pincode']") private WebElement pincode;
	@FindBy(xpath="//input[@placeholder='Your mobile number']") private WebElement Mno;
	@FindBy(xpath="//div[text()='Continue']") private WebElement continuebut;
	@FindBy(xpath="//div[text()= ' Please enter a valid pincode ']") private WebElement pinErrmsg;//new chnge
	@FindBy(xpath="//div[text()=' Please enter a valid mobile no. ']") private WebElement moberrmsg;//new chnge
	
	public CoverFoxAddressdetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void pincodes(String pincodess)
	{
		Reporter.log("Entering pin code", true);
		pincode.sendKeys(pincodess);
	}
	public void mobilenumber(String mobno)
	{
		Reporter.log("Entering Mno", true);
		Mno.sendKeys(mobno);
	}
	
	public void continueb()
	{
		Reporter.log("Clicking on conitinue button", true);
		continuebut.click();
	}
	
	public String   getPinErrMsg()
	{
		String actualText= pinErrmsg.getText();
		return actualText;
	}
	public String   getMnoErrMsg()
	{
		String actualText= moberrmsg.getText();
		return actualText;
	}
}
