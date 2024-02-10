package enabillallpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import commonmethods.commonmethods;




public class CustomerPage {

	    private WebDriver driver;
	    public commonmethods cm;
	    private ExtentTest logger;

	    public CustomerPage(WebDriver driver, ExtentTest logger)
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
	    
	    @FindBy(xpath = "//p[normalize-space()='Application Settings']")
	    WebElement applicationSettings;
	    
	    @FindBy(xpath = "//div[@class='container-fluid']//div[1]//div[1]//div[1]")
	    WebElement customer;
	    
	    @FindBy(xpath = "//button[normalize-space()='Add']")
	    WebElement Addb;
	    
	    @FindBy(xpath = "//kendo-textbox[@class='backgroundT k-textbox k-input ng-pristine ng-invalid k-input-md k-rounded-md k-input-solid ng-touched']")
	    WebElement Ccode;
	    
	    
	    public void Login1(String Username, String password) {
	        userid(Username);
	        Password(password);
	    }
	    
	    public void Login2() {
	        loginbutton(); // Corrected the method name here
	    }
	    
	    public void customernavigate()
        {
	    	applicationclick();
	    	customerclickk();
	    	Addbutton();   
	    }
	    
	    
	    public void customerdata (String customercode)
	    {
	    	Ccodefield(customercode);
	    }
	    public void userid(String val) {
	        cm.EnterValue(Userid, val, "Text " + val + " has been entered into userid field");
	    }

	    public void Password(String val) {
	        cm.EnterValue(Pass, val, "Text " + val + " has been entered into password field");
	    }

	    public void loginbutton() { // Corrected method name
	        cm.ClickElement(loginbu, "Login in button has been clicked");
	    }
	    
	    public void applicationclick() { // Corrected method name
	        cm.ClickElement(applicationSettings, " Application Settings in button has been clicked");
	    }
	    
	    public void customerclickk() { // Corrected method name
	        cm.ClickElement(customer, "Customer in button has been clicked");
	    }
	    
	    public void Addbutton() { // Corrected method name
	        cm.ClickElement(Addb, "Add button has been clicked");
	    }
	    
	    public void Ccodefield(String val) { // Corrected method name
	        cm.EnterValue(Ccode, val, "Text " + val + " has been entered into password field");
	    }
	    
	    
	    
	    

}

