package Maven.Selenium;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class HandleList{
	ReadConfig config;
    WebDriver driver;
	public HandleList() throws IOException {
		config = new ReadConfig();
	}
	
	@BeforeTest
	public void launchApp() {
		driver = new ChromeDriver();
		//driver.get("https://demo.guru99.com/test/simple_context_menu.html");
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Parameters("browsertest")
	@Test
	public void handlelist() throws Exception {
		driver.get(config.testingblog());
		WebElement list = driver.findElement(By.cssSelector("select[name='FromLB']"));
		// handle dropdown
		// Select
		Select sel = new Select(list);
		System.out.println("listbox accept multiple selection or not: " + sel.isMultiple());
		// select value from dropdown
		sel.selectByIndex(0); // USA
		Thread.sleep(1000);
		sel.selectByValue("India"); // India
		Thread.sleep(1000);
		sel.selectByVisibleText("Spain"); // Spain
		Thread.sleep(2000);
		// deselect value from dropdown
		sel.deselectByValue("USA");
	}

	@Test
	public void handlelist2() throws Exception {
		driver.get(config.testingblog());
		WebElement list = driver.findElement(By.tagName("select"));
		// handle dropdown
		// Select
		Select sel = new Select(list);
		System.out.println("listbox accept multiple selection or not: " + sel.isMultiple());
		// select value from dropdown
		sel.selectByIndex(1); // Saab
		Thread.sleep(1000);
		sel.selectByValue("Singapore"); // India
		Thread.sleep(1000);
		sel.selectByVisibleText("Toyota"); // Spain
		Thread.sleep(2000);
		// deselect value from dropdown
		// sel.deselectByValue("USA");
	}

	@Test
	public void handleSimpleAlert() throws Exception {
		driver.get(config.testingblog());
		Thread.sleep(3000);
		// generate an alert
		driver.findElement(By.xpath("//input[contains(@value,'Show')]")).click();
		Thread.sleep(3000);
		// Alert/frame/windows ------- driver.switchTo().
		// handle alert
		// accept/dismiss/getText/sendKeys
		Alert simpleAlert = driver.switchTo().alert();
		System.out.println("Alert Text: " + simpleAlert.getText());
		// validation step
		Assert.assertEquals(simpleAlert.getText(), "Hi.. This is alert message!");
		Assert.assertTrue(simpleAlert.getText().contains("alert message"));
		// simpleAlert.accept();
		simpleAlert.dismiss();
	}

	@Test
	public void handleConfirmAlert() throws Exception {
		driver.get(config.testingblog());
		Thread.sleep(3000);
		// generate an alert
		driver.findElement(By.xpath("//button[contains(text(),'Confirmation')]")).click();
		Thread.sleep(3000);
		// Alert/frame/windows ------- driver.switchTo().
		// handle alert
		// accept/dismiss/getText/sendKeys
		Alert confirmAlert = driver.switchTo().alert();
		System.out.println("Alert Text: " + confirmAlert.getText());
		// validation step
		Assert.assertEquals(confirmAlert.getText(), "Press 'OK' or 'Cancel' button!");
		Assert.assertTrue(confirmAlert.getText().contains("'OK' or 'Cancel'"));
		confirmAlert.accept();
		// confirmAlert.dismiss();
		Thread.sleep(3000);
		String pressOk_cancel = driver.findElement(By.xpath("//*[@id='demo']")).getText();
		System.out.println(pressOk_cancel);
		// validation step
		Assert.assertEquals(pressOk_cancel, "You pressed OK!");
		Assert.assertTrue(pressOk_cancel.contains("OK"));
	}

	@Test
	public void handlePrompt() throws InterruptedException {
		driver.get(config.testingblog());
		driver.findElement(By.xpath("//button[text()='Show Me Prompt']")).click();
		Thread.sleep(3000);
		Alert promptalert = driver.switchTo().alert();
		System.out.println("Alert Text: " + promptalert.getText());
		Assert.assertEquals(promptalert.getText(), "Your Name Please");
		promptalert.sendKeys("Gayathri");
		promptalert.accept();
	}

	@Test
	public void handleFrame() throws InterruptedException {
		driver.get(config.paytm());
		driver.findElement(By.xpath("//span[contains(text(),'Sign')]")).click();
		Thread.sleep(4000);
		// WebElement myFrame = driver.findElement(By.tagName("iframe"));
		WebElement myFrame = driver.findElement(By.cssSelector("#app iframe"));
		//WebElement myFrame = driver.findElement(By.xpath("//iframe[contains(@src,'login')]"));
		// driver.switchTo().frame(0);
		// driver.switchTo().frame("id/name");
		// driver.switchTo().frame("#app iframe")
		driver.switchTo().frame(myFrame);
		Thread.sleep(4000);
        String payTMWebAccount = driver.findElement(By.cssSelector(".heading")).getText();
        System.out.println(payTMWebAccount);
        Assert.assertTrue(payTMWebAccount.contains("Paytm Web account"));
        driver.findElement(By.xpath("//span[contains(text(),'Watch')]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[@role=\"button\"]")).click();
        Thread.sleep(4000);
        driver.switchTo().parentFrame();
        Thread.sleep(4000);
	}

}
