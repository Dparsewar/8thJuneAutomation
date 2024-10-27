package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static void TakeScreenShot(WebDriver driver, String fileName) throws IOException
	{
		String date = new SimpleDateFormat("HHmmss").format(new Date());
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File distination = new File("E:\\DPYoworkspace\\8thJuneCoverFox\\screenShot\\"+fileName+""+date+".jpg");
		FileHandler.copy(source, distination);
	}
	
	public static String ExcelReading(String excelPath,String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException 
	{
		//FileInputStream file = new FileInputStream("E:\\Dpworkspace\\Testss.xlsx");
		FileInputStream file = new FileInputStream(excelPath);
		String value = WorkbookFactory.create(file).getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		Properties properties = new Properties();
		FileInputStream myfile=new FileInputStream(System.getProperty("user.dir")+"//File.properties");
		
		properties.load(myfile);
		String value=properties.getProperty(key);
		return value;
	}
	
}
