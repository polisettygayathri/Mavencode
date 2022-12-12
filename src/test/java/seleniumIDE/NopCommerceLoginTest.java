package seleniumIDE;

import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Maven.Selenium.ReadConfig;


public class NopCommerceLoginTest{

	ReadConfig config;
    WebDriver driver;
	public NopCommerceLoginTest() throws IOException {

		config = new ReadConfig();
	}

	@BeforeTest
	public void launchApp() {
		driver = new ChromeDriver();
	}

	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void nopCommerceLogin() throws InterruptedException {
		driver.get(config.nopcommerce());
		WebElement Email = driver.findElement(By.id("Email"));
		Email.clear();
		Email.sendKeys("admin@yourstore.com");
		WebElement Password = driver.findElement(By.cssSelector("[value='admin']"));
		Password.clear();
		Password.sendKeys("admin");
		// driver.findElement(By.cssSelector(".button-1")).click();
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//p[contains(text(),'Customers')]//parent::a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@href=\"/Admin/Customer/List\"]")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@Parameters("browsertest")
	@Test
	public void amazonTest() throws InterruptedException {
		driver.get(config.amazon());
		Thread.sleep(4000);
		driver.findElement(By.xpath("//h2[contains(text(),'Top')]//parent::div//following-sibling::div[@class='a-cardui-footer']//child::a[text()='See more']")).click();
		Thread.sleep(4000);
	}

	@Test
	public void hyrtutorial() throws InterruptedException {
		driver.get(config.hyrtutorials());
		Thread.sleep(4000);
		driver.findElement(
				By.xpath("//td[text()='Helen Bennett']//preceding-sibling::td//child::input[@type='checkbox']"))
				.click();
		Thread.sleep(4000);
	}

	@Test
	public void orangeliveTest() throws InterruptedException {
		driver.get(config.orangelive());
		Thread.sleep(4000);
		driver.manage().window().setSize(new Dimension(635, 569));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector(".oxd-button")).click();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector(".bi-caret-down-fill")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(4000);
		assertThat(driver.findElement(By.cssSelector(".orangehrm-login-forgot-header")).getText(),
				is("Forgot your password?"));
	}

}
