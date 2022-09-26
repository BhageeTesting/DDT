package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogoutPage {
	@FindBy(xpath="//a[@class='panelTrigger']")
	WebElement welcome;
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logout;
	public void VerifyLogout() {
		welcome.click();
		logout.click();
	}
}
	


