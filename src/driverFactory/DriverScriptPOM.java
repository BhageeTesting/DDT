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
import utilities.ExcelFileUtil;

public class DriverScriptPOM {
WebDriver driver;
String inputpath="F:\\secondclass\\DDT_Framework\\TestInput\\pushpa.xlsx";
String outpath="F:\\secondclass\\DDT_Framework\\TestOutput\\pushpaReview.xlsx";
@BeforeTest
public void setup()throws Throwable {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	AdminLogin login=PageFactory.initElements(driver, AdminLogin.class);
	login.VerifyLogin("Admin", "Qedge123!@#");
		
}
@Test
public void startTest()throws Throwable {
	ExcelFileUtil xl=new ExcelFileUtil(inputpath);
	int rc=xl.getRow("Login");
	for (int i = 1; i <=rc; i++) {
		String para1=xl.getcelldata("Login", i, 0);
		String para2=xl.getcelldata("Login", i, 1);
		String para3=xl.getcelldata("Login", i, 2);
		Emppage emp=PageFactory.initElements(driver, Emppage.class);
		boolean res=emp.VerifyAddEmp(para1, para2, para3);
		if (res) {
			xl.SetCellValue("Login", i, 3, "Pass", outpath);
			
		}
		else {
			xl.SetCellValue("Login", i, 3, "Fail", outpath);
		}
		
		
	}
	
}
@AfterTest
public void teardown() {
	AdminLogoutPage logout=PageFactory.initElements(driver, AdminLogoutPage.class);
	logout.VerifyLogout();
	driver.close();
	
}
}
