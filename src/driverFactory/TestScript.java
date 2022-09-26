package driverFactory;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import applicationLayer.AdminLogin;
import applicationLayer.AdminLogoutPage;
import applicationLayer.Emppage;

public class TestScript {
	WebDriver driver;
	@BeforeTest
	public void startTest() throws Throwable{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AdminLogin login= PageFactory.initElements(driver, AdminLogin.class);
		login.VerifyLogin("Admin", "Qedge123!@#");
		
		
	}
	@Test
	public void employeecreation()throws Throwable{
	Emppage emp=PageFactory.initElements(driver, Emppage.class);
	boolean res=emp.VerifyAddEmp("Thota", "sai", "bhageerath");
	System.out.println(res);
	}
	
	@AfterTest
	public void teardown()throws Throwable {
		AdminLogoutPage logout=PageFactory.initElements(driver, AdminLogoutPage.class);
		logout.VerifyLogout();
	}

}
