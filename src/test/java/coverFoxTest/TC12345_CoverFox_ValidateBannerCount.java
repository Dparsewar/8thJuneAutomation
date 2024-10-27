package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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

public class TC12345_CoverFox_ValidateBannerCount extends Base {
	CoverFoxHomePage homepage;
	CoverFoxHealthPlanPage healthPlanPage;
MemberDetailsPage memberDetailsPage;
CoverFoxAddressdetailsPage addressDetailspage;
CoverFoxResultpage resultPage;
String excelPath="E:\\Dpworkspace\\Testss.xlsx";
String sheetName="Sheet1";
public static  Logger logger;//logger is variable and Capital Logger is interface 

	
	
	@BeforeMethod
	
		public void enterDetails() throws EncryptedDocumentException, IOException, InterruptedException
		{
		
		launchBrowser();
		logger=	Logger.getLogger("Loggerinformation");
	  PropertyConfigurator.configure("log4j.properties");
	  logger.info("Collection log information");
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
			
		}

	
  @Test
  public void validatePincodeErroreMsg() throws InterruptedException, EncryptedDocumentException, IOException {
	 
	  logger.warn("Please enter valid mno");
		addressDetailspage.mobilenumber(Utility.ExcelReading(excelPath, sheetName, 0, 2));
		logger.info("entering  mobileno");
		addressDetailspage.continueb();
		logger.info("Clicking on   continue button");
		String actualPinErrorMsg = addressDetailspage.getPinErrMsg();
		String expectedPinErrorMsg= Utility.ExcelReading(excelPath,sheetName,0,3);
		Thread.sleep(2000);
		Assert.assertEquals(actualPinErrorMsg, expectedPinErrorMsg, "Error msg not mathcing ,Tc failed");
		Thread.sleep(2000);
  }
@Test
  public void validateMnoErrmsg() throws EncryptedDocumentException, IOException
  {
	  addressDetailspage.pincodes(Utility.ExcelReading(excelPath, sheetName, 0, 1));
		
		addressDetailspage.continueb();
		logger.info("Clicking on   continue button");
		
String actualMnoErrmsg =	addressDetailspage.getMnoErrMsg();
	
String ExpectedMobErrMsg=Utility.ExcelReading(excelPath, sheetName, 0, 4);

Assert.assertEquals(actualMnoErrmsg, ExpectedMobErrMsg,"Erroe msg are not matchingplese check mno");
  }
  @AfterMethod
  public void closeApplication()
  {
	  closeBrowser();
	  logger.warn("Closing your browser in a sec and it's closed");
	  
  }
}
