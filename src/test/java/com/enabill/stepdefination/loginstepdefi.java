package com.enabill.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import enabillallpages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class loginstepdefi extends BaseStepDefi {
	  private WebDriver driver;
	
    public LoginPage LP;
	
	@Given("user should  be on login page")
	public void user_should_be_on_login_page() {
		init();
		logger = extent.createTest(scenario.getName());
		LP = new LoginPage(driver,logger);	     
	}
	

	@When("user enters Invalid userid as {string} and entered Invalid password as {string}")
	public void user_enters_invalid_userid_and_entered_invalid_password(String id, String pass) {
	    driver.findElement(By.id("email")).sendKeys(id);
	    driver.findElement(By.id("password")).sendKeys(pass);
	   // LP.Login(id, pass);
	    LP.loginb();
	}


	@Then("validation should be displayed")
	public void validation_should_be_displayed() {
	driver.findElement(By.xpath("//div[@class='alert alert-danger' and @role='alert']")).isDisplayed();
	    
	}
   

	
	@When("user enters valid userid and entered valid password")
	public void user_enters_valid_userid_and_entered_valid_password() {
		LP.Login("irfan.inamdar@logstarerp.com", "Pass@222");
		
	   
	}
	@When("click on login button")
	public void click_on_login_button() {
		LP.loginb();
		//driver.findElement(By.xpath("//button[@class='btn btn-Enabill-login btn-block btn-flat b-r-10']")).click();
	
	}
	
	@Then ("Close WebBwowser")
	public void Close_WebBwowser()
	{
		extent.flush();
		driver.quit();
	}
	
	

}
