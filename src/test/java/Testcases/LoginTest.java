package Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.loginpage;

public class LoginTest extends BaseClass{
	
	@Test
	public void TC01_LoginFailureTest() {
		
		loginpage lp = new loginpage();
		lp.LoginFunction("abc@xyz.com", "Abcd@1234");
		lp.ValidateErrorMsg("The email or password you have entered is invalid.");
		
	}
	
	@Test
	public void TC02_LoginSuccessTest() {
		
		loginpage lp = new loginpage();
		lp.LoginFunction("pqr@xyz.com", "Correct@1234");
		
	}

}
