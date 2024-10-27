package coverFoxPom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxResultpage {


	@FindBy(xpath="//div[contains(text(),'matching Health ')]") private WebElement resultText;
	
	@FindBy(xpath="//div[@class='plan-card-container']") private List<WebElement> planList;
	
	public CoverFoxResultpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public int getCountFromText()
	{
		Reporter.log("Getting policy count from text displayed", true);
		String resultInString= resultText.getText().substring(0, 2);
		int countFromText=	Integer.parseInt(resultInString);
		return  countFromText;
	}
	
	public int getCountFromBanner()
	{
		Reporter.log("Getting policy count from banners displayed", true);
		int countFromBanner=planList.size();
		return countFromBanner;
	}
	/*public void validateResult()
	{
		String resultInString= resultText.getText().substring(0, 2);
	int resultNumber=	Integer.parseInt(resultInString);
		int planListNumber=planList.size();
		
		System.out.println("Result number is"+resultNumber);
		System.out.println("Planlist number is"+planListNumber);
		if(resultNumber==planListNumber)
		{
			System.out.println("Result are matching Tc is passed");
		}
		else
		{
			System.out.println("Result is not matching ");
		}
//System.out.println(result.length());
	}*/
}
