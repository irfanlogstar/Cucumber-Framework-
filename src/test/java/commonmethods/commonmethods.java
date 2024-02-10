package commonmethods;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class commonmethods {
private WebDriver driver;
public WebDriverWait wait;
private ExtentTest logger;
	
	public commonmethods(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger=logger;
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
	}
	
	public void EnterValue(WebElement elm , String val , String mgs)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(val);
		logger.pass(mgs+"  <a href='"+getscreenshot()+"'>Screenshot</a>");
		}
			catch(Exception e)
		{
		   e.printStackTrace();
		   logger.fail(e.getMessage()+  "<a href='"+getscreenshot()+"'>Screenshot</a>");
	    }
     }
	
	public void ClickElement(WebElement elm ,String mgs)
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();
		logger.pass(mgs+"  <a href='"+getscreenshot()+"'>Screenshot</a>");
		}
			catch(Exception e)
		{
		   e.printStackTrace();
		   logger.fail(e.getMessage()+  "<a href='"+getscreenshot()+"'>Screenshot</a>");
	    }
     }
	
	public void SelectVisibleText(WebElement elm , String val,String mgs)
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeSelected(elm));
		Select s = new Select (elm);
		s.selectByVisibleText(val);
		logger.pass(mgs+"  <a href='"+getscreenshot()+"'>Screenshot</a>");
		
		}
			catch(Exception e)
		{
		   e.printStackTrace();
		   logger.fail(e.getMessage()+  "<a href='"+getscreenshot()+"'>Screenshot</a>");
	    }
     }
	
       public void dispaly(WebElement elm ,String mgs)
       {
    	  
    	   try
   		{
   		wait.until(ExpectedConditions.visibilityOf(elm));
   		elm.isDisplayed();
   		logger.pass(mgs+"  <a href='"+getscreenshot()+"'>Screenshot</a>");
   		}
   			catch(Exception e)
   		{
   		   e.printStackTrace();
   		   logger.fail(e.getMessage()+  "<a href='"+getscreenshot()+"'>Screenshot</a>");
   		} 
    	   
       }
       
       public boolean ClickElementToBeClickable(WebElement element, String message) {
    	    try {
    	        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    	        logger.pass(message + "  <a href='" + getscreenshot() + "'>Screenshot</a>");
    	        return true; 
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	        logger.fail(e.getMessage() + " <a href='" + getscreenshot() + "'>Screenshot</a>");
    	        return false;
    	    }
    	}

       
       public void switchto(WebElement elm ,String mgs)
       {
    	  
    	   try
   		{
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(elm));
   		elm.click();
   		logger.pass(mgs+"  <a href='"+getscreenshot()+"'>Screenshot</a>");
   		}
   			catch(Exception e)
   		{
   		   e.printStackTrace();
   		   logger.fail(e.getMessage()+  "<a href='"+getscreenshot()+"'>Screenshot</a>");
   		} 
    	   
       }
       
       
	
	public String getscreenshot() 
	{
		DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
		Date d = new Date();
		String str = f.format(d);
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/src/test/java/Com/Enabill/Reports/screenshots/screenshots"+str+".png";
		//Move image file to new destination
		File DestFile=new File(path);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
	}
	
	
		
	}


