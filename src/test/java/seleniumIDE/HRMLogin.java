package seleniumIDE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HRMLogin {

	@Test

	public void verifyLogin() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C://Users/Student/Desktop/Software/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// sync issue
		Thread.sleep(4000);
		// locator
		// name
		WebElement txt_UserName = driver.findElement(By.name("username"));
		String userNamePlaceHolder = txt_UserName.getAttribute("placeholder");
		System.out.println(userNamePlaceHolder);
		txt_UserName.sendKeys("Admin");
		// locator - class
		// password
		// oxd-input oxd-input--active
		// driver.findElement(By.className("oxd-input")).sendKeys("admin"); //enter the
		// value ---
		// FindElements --- list of elemenent
		// List<WebElement> allElement =
		// driver.findElements(By.className("oxd-input--active"));
		List<WebElement> allElement = driver.findElements(By.className("oxd-input"));
		System.out.println("no of element are : " + allElement.size());
		String userLabel = allElement.get(0).getAttribute("placeholder");
		String passLabel = allElement.get(1).getAttribute("placeholder");
		System.out.println(userLabel + "  : " + passLabel);
		allElement.get(1).sendKeys("admin123");
		// Tagname
		// login button
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(4000);
		System.out.println("Application title: " + driver.getTitle());
		System.out.println("Application URL: " + driver.getCurrentUrl());
		// userdropdown
		// className
		String loggedInUser = driver.findElement(By.className("oxd-userdropdown-name")).getText();
		System.out.println(loggedInUser);
		driver.findElement(By.className("oxd-userdropdown-name")).click();
		Thread.sleep(4000);
		// click on Logout
		// LinkText
		// driver.findElement(By.linkText("Logout")).click();
		// PartialLinkeText
		driver.findElement(By.partialLinkText("ogou")).click();
		Thread.sleep(4000);
		System.out.println("==========after logout==============");
		System.out.println("Application title: " + driver.getTitle());
		System.out.println("Application URL: " + driver.getCurrentUrl());
		// xpath
		// driver.findElement(By.xpath("//p[text()='Forgot your password?']")).click();
		driver.findElement(By.className("orangehrm-login-forgot-header")).click();
		Thread.sleep(4000);
		// CSS
		driver.findElement(By.cssSelector("[type='button']")).click();
		Thread.sleep(5000);
		driver.close();

	}

}
