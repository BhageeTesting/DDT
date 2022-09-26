package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {
	//define repository for page events
	@FindBy(xpath="//input[@name='txtUsername']")
	WebElement user;
	@FindBy(xpath="//input[@name='txtPassword']")
	WebElement pass;
	@FindBy(xpath="//input[@name='Submit']")
	WebElement button;
	//write method
	public void VerifyLogin(String username, String password) {
		user.sendKeys("Admin");
		pass.sendKeys("Qedge123!@#");
		button.click();
		
	}
	

}
