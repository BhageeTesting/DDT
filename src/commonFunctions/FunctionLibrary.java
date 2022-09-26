package commonFunctions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Reporter;
import config.AppUtil;

public class FunctionLibrary extends AppUtil{
	//method for login
	public static boolean verifylogin(String username, String password)throws Throwable {
		con.get(p.getProperty("url"));
		con.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		con.findElement(By.xpath(p.getProperty("user"))).sendKeys(username);
		con.findElement(By.xpath(p.getProperty("pass"))).sendKeys(password);
		con.findElement(By.xpath(p.getProperty("button"))).click();
		String expected="dashboard";
		String actual=con.getCurrentUrl();
		if (actual.contains(expected)) {
			Reporter.log("Login successful"+expected+"    "+actual);
			return true;
				}
		else {
			
			//capture error message
			String errormessage=con.findElement(By.xpath(p.getProperty("errormessage"))).getText();
			Reporter.log(errormessage+"  "+expected+"   "+actual);
			return false;
			
		}	
	}
}
