package POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver rdriver) {
		// this.driver = driver;
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Identification
	@FindBy(id = "Email")
    WebElement txt_Email;
	By txtPass = By.id("Password");
	By chkRem = By.xpath("//input[@name='RememberMe']");
	By btnLogin = By.tagName("button");

	// Methods
	public void enterEmail(String email) {
		txt_Email.clear();
		txt_Email.sendKeys(email);
	}

	public boolean verifyElementPresent(By eleLocator) {
		return driver.findElement(eleLocator).isDisplayed();
	}

	//public boolean verifyEmailTxtboxDispalyed() {
	//	return verifyElementPresent(txtEmail);
	//}

	public void enterPass(String pwd) {
		driver.findElement(txtPass).clear();
		driver.findElement(txtPass).sendKeys(pwd);
	}

	public void clickRememberCheckbox() {
		driver.findElement(chkRem).click();
	}

	public void clickLoginButton() {
		driver.findElement(btnLogin).click();
	}

	public void verificationAppTitle(String expectedValue) {
		Assert.assertEquals(driver.getTitle(), expectedValue);
	}
}
