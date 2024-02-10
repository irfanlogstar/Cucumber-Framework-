package com.enabill.stepdefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import commonmethods.Xls_Reader;
import enabillallpages.CustomerPage;
import enabillallpages.LoginPage;

import java.text.SimpleDateFormat;
import java.text.DateFormat;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseStepDefi {
	 public static WebDriver driver;
	 
	 public static LoginPage LP;
	 public static CustomerPage CP;
	 public static Properties prop;
	 public static Map<String,Map<String,String>> data;
	 
	 public static ExtentHtmlReporter htmlReporter;
	 public static ExtentReports extent;
	 public static ExtentTest logger;
	 public Scenario scenario;
	
	
	
	 public void before(Scenario Scenario)
	 {
		 this.scenario = Scenario;
	 }
	
	 public void  init()
	 {
		 prop=readProperties(System.getProperty("user.dir")+"/src/test/resources/Config/setting.properties");
		 createReport();
		 startDriver();
		// data = ReadExcelData(System.getProperty("user.dir")+"/src/test/resources/TestData/Data.xlsx" ,"Sheet1");
		
		 
	 }
	 

	 public void tierdown()
	 {
		//driver.quit();
	 }
	 
	 
	 
	 public void Flushreport()
	 {
		 extent.flush();
	 }
	

	    public void startDriver() {

			if(prop.getProperty("browserName").equals("chrome"))
			{
	        System.setProperty("webdriver.chrome.driver", "D:\\OneDrive - Logstar ERP India Pvt Ltd\\All Projects Logstar\\Selenium Data\\Automation Testing\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	    	ChromeOptions option = new ChromeOptions();
	    	
	        //option.setBinary("D:\\All Projects Logstar\\Selenium Data\\Maven\\Testing driver and browser\\chrome-win64\\chrome-win64\\chrome.exe");
	        option.addArguments("--remote-allow-origins=*");
	        driver = new ChromeDriver(option);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.get("http://172.16.23.54:9009/login");
	        option.addArguments("--remote-allow-origins=*");
			} 
			else if (prop.getProperty("browserName").equals("firefox")) 
			{
			    WebDriverManager.firefoxdriver().setup();
			    driver = new FirefoxDriver();
			}
			else if (prop.getProperty("browserName").equals("edge")) 
			{
			    WebDriverManager.edgedriver().setup();
			    driver = new EdgeDriver();
			}
			
			
	       
	        
	    }
	     
	 public Properties readProperties(String file)
	 {
		FileInputStream fis = null;
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
		 
	 }
	 
	 public  Map<String,Map<String,String>> ReadExcelData(String File , String Sheet)
	 {
		 Xls_Reader xr = new Xls_Reader(File);
		 int rowcount = xr.getRowCount(Sheet);
		 int columncount = xr.getColumnCount(Sheet);
		 Map<String,Map<String,String>> AllData = new HashMap<String,Map<String,String>>();
		 for(int i=2;i<=rowcount;i++)
		 {
			 Map<String,String> map = new HashMap<String,String>();
			 for(int j=0;j<columncount;j++)
			 {
				 String data = xr.getCellData(Sheet, j, i).trim();
				 map.put(xr.getCellData(Sheet, j, 1), data);
			 }
			 AllData.put(xr.getCellData(Sheet, 0, i), map);
		 }
		 return AllData;
	 }
	 
	 @SuppressWarnings("deprecation")
	public void createReport() 
		{
			DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
			Date d = new Date();
			String str = f.format(d);
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\src\\test\\java\\Enabill\\Reports,"+str+".html");
	    	// Create an object of Extent Reports
			extent = new ExtentReports();  
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host Name", "Enabill");
			    	extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User Name", "Irfan Inamdar");
			htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
			            // Name of the report
			htmlReporter.config().setReportName("Enabill Automation Testing Report"); 
			            // Dark Theme
			htmlReporter.config().setTheme(Theme.STANDARD); 
		}
	 
	 
	 

	 
	
	}
