package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPom.CoverFoxAddressdetailsPage;
import coverFoxPom.CoverFoxHealthPlanPage;
import coverFoxPom.CoverFoxHomePage;
import coverFoxPom.CoverFoxResultpage;
import coverFoxPom.MemberDetailsPage;
import coverFoxUtility.Utility;

public class TC1234_CoverFox_ValidateBannerCount extends Base {
	CoverFoxHomePage homepage;
	CoverFoxHealthPlanPage healthPlanPage;
MemberDetailsPage memberDetailsPage;
CoverFoxAddressdetailsPage addressDetailspage;
CoverFoxResultpage resultPage;
String excelPath="E:\\Dpworkspace\\Testss.xlsx";
String sheetName="Sheet1";
public static  Logger logger;//logger is variable and Capital Logger is interface 

	@BeforeClass
	public void openApplication() throws IOException
	{
		launchBrowser();
		logger=	Logger.getLogger("Loggerinformation");
	  PropertyConfigurator.configure("log4j.properties");
	  logger.info("Collection log information");
	}
	
	@BeforeMethod
	
		public void enterDetails() throws EncryptedDocumentException, IOException, InterruptedException
		{
			homepage=new CoverFoxHomePage(driver);
			healthPlanPage =new CoverFoxHealthPlanPage(driver);
			memberDetailsPage = new MemberDetailsPage(driver);
			addressDetailspage = new CoverFoxAddressdetailsPage(driver);
			homepage.ClickonGender();
			Thread.sleep(2000);
			healthPlanPage.nextbuttons();
			Thread.sleep(2000);
			memberDetailsPage.Genderdropdown(Utility.ExcelReading(excelPath,sheetName, 0, 0));
			memberDetailsPage.nextbutton();
			  logger.info("Clicking  on next button");
			Thread.sleep(2000);
			addressDetailspage.pincodes(Utility.ExcelReading(excelPath, sheetName, 0, 1));
			logger.warn("Please enter valid mno");
			addressDetailspage.mobilenumber(Utility.ExcelReading(excelPath, sheetName, 0, 2));
			logger.info("entering  mobileno");
			addressDetailspage.continueb();
			logger.info("Clicking on   continue button");
			
			Thread.sleep(4000);
		}

	
  @Test
  public void validatePolicycCount() throws InterruptedException {
	 
	  resultPage= new CoverFoxResultpage(driver);
	 int TextCount= resultPage.getCountFromText();
	 
	 System.out.println(TextCount);
	 int bannerCount= resultPage.getCountFromBanner();
	 System.out.println(bannerCount);
	 //Thread.sleep(2000);
	 Assert.assertEquals(TextCount, bannerCount,"text count not matching with banner");
	//Assert.fail();//You can forcefully fail this and check screenshots is taking or not
  }
  @AfterClass
  public void closeApplication()
  {
	  closeBrowser();
	  logger.warn("Closing your browser in a sec and it's closed");
	  
  }
}
