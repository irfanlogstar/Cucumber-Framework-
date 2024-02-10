package enabillallpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import commonmethods.commonmethods;


public class LoginPage {

    private WebDriver driver;
    public commonmethods cm;
    private ExtentTest logger;

    public LoginPage(WebDriver driver, ExtentTest logger) 
    {
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements(driver, this);
        cm = new commonmethods(driver, logger);
    }

    @FindBy(id = "email")
    WebElement Userid;

    @FindBy(id = "password")
    WebElement Pass;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginbu;

    @FindBy(xpath = "//div[@class='flex-grow-1']")
    WebElement Profile;
    
    @FindBy(xpath = "//i[@class='ti ti-logout txt-w']")
    WebElement logout;
    
    @FindBy(xpath = "//div[@role='alert']")
    WebElement  Invaliduser ;
    

    public void Login(String Username, String password) {
        userid(Username);
        Password(password);  
    }

    public void loginb() {
        loginbutton();    
        
    }
    
    public void Logout() {     
           Profile1();
           switchTo();
           logout();
    }
    
    public void invaliduser() {        
        Invalid_User();
    }
    

    public void userid(String val) {
        cm.EnterValue(Userid, val, "Text " + val + " has been entered into userid field");
    }

    public void Password(String val) {
        cm.EnterValue(Pass, val, "Text " + val + " has been entered into password field");
    }

    public void loginbutton() { 

        cm.ClickElement(loginbu, "Login button has been clicked");
    }
    
       public void Profile1() { 
       cm.ClickElementToBeClickable(Profile, "Profile  button has been clicked");
        }
    
     public void switchTo() { 
    	 
    	 JavascriptExecutor executor = (JavascriptExecutor) driver;
    	 executor.executeScript("arguments[0].click();", Profile);
         cm.ClickElementToBeClickable(Profile, "Profile");
    }
   
  /*  public void Profile1() { 
       cm.ClickElementToBeClickable(Profile, "Profile in button has been clicked");
    }*/
     public void logout() { 
    	    if (cm.ClickElementToBeClickable(logout, "logout Button has been clicked")) {
    	        System.out.println("Pass");
    	    } else {
    	        System.out.println("Fail");
    	    }
    	}
     
     public void  Invalid_User () { 

         cm.dispaly(Invaliduser, "Invalid user validation is displayed");
     }
    
   
    
}
