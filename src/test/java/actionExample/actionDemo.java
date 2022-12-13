package actionExample;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class actionDemo {

	WebDriver driver;

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

	@Test
	public void rightClick() throws InterruptedException {

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement btn = driver.findElement(By.cssSelector("span.btn-neutral"));
		WebElement delete = driver.findElement(By.xpath("//span[contains(text(),'Del')]"));
		Actions act = new Actions(driver);
		act.contextClick(btn).perform();
		delete.click();
		Thread.sleep(4000);
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		Assert.assertTrue(a.getText().contains("delete"));
		a.dismiss();
	}

	/*@Test
	public void verifyDoubleClickTest() throws InterruptedException {

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		// Create an Object of Actions class
		Actions act = new Actions(driver);
		WebElement doubleButton = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
		act.doubleClick(doubleButton).perform();
		// handle Alert
		Thread.sleep(4000);
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		Assert.assertTrue(a.getText().contains("double"));
		a.dismiss();
	}

	@Test
	public void verifyRightClickTest() throws InterruptedException {
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().fullscreen();
		Thread.sleep(4000);
		WebElement myframe = driver.findElement(By.xpath("//iframe[contains(@data-src,'photo-manager')]"));
		driver.switchTo().frame(myframe);
		Actions act = new Actions(driver);
		WebElement img3 = driver.findElement(By.xpath("//img[contains(@src,'tatras3')]"));
		WebElement trash = driver.findElement(By.cssSelector("div#trash"));
		act.dragAndDrop(img3, trash).perform();
	}

	@Test
	public void verifyDragDropTest() throws Exception {
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().fullscreen();
		WebElement myframe = driver.findElement(By.xpath("//iframe[contains(@data-src,'photo-manager')]"));
		driver.switchTo().frame(myframe);
		Actions act = new Actions(driver);
		WebElement img3 = driver.findElement(By.xpath("//img[contains(@src,'tatras3')]"));
		WebElement img4 = driver.findElement(By.xpath("//img[contains(@src,'tatras4')]"));
		WebElement trash = driver.findElement(By.cssSelector("div#trash"));
		// method1
		act.dragAndDrop(img3, trash).perform();
		Thread.sleep(4000);
		// method2
		// A convenience method that performs click-and-hold at the location of the
		// source element,
		// moves to the location of the target element, then releases the mouse.
		act.clickAndHold(img4).moveToElement(trash).release().perform();
	}
	
	@Test
	public void handlingFrames() throws InterruptedException {
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().fullscreen();
		Thread.sleep(4000);
		String parentWindow = driver.getWindowHandle();
		System.out.println("parentWindow: "+ parentWindow);
		Thread.sleep(4000);
		//window counts
		//driver.getWindowHandle();			//single window
		//driver.getWindowHandles(); 			//multiple window
		//Click on Hotel Button
		driver.findElement(By.xpath("//a[@href=\"https://hotel.irctctourism.com/hotels\"]")).click();
		Thread.sleep(4000);
		Set<String> allwindow = driver.getWindowHandles(); 			//multiple window
		System.out.println("Window count: " + allwindow.size());
		String mainWindow =(String)allwindow.toArray()[0];
		String HotelWindow =(String)allwindow.toArray()[1];
		System.out.println(mainWindow);
		System.out.println(HotelWindow);
		Thread.sleep(4000);
		//swicth To Hotel window
		driver.switchTo().window(HotelWindow);
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(4000);
		//swicth To Hotel window
		driver.switchTo().window(mainWindow);
		//driver.findElement(By.xpath("//a[contains(text(),'CON')]")).click();
		System.out.println(driver.findElement(By.xpath("//h2[text()='HOLIDAYS']")).getText());
		Thread.sleep(4000);
		//swicth To Hotel window
		driver.switchTo().window(HotelWindow);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}*/
}
