package seleniumIDE;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class LoginTestTest {
	public WebDriver driver;
	
    @Parameters("browserTest")
	@BeforeTest
	public void setUp(String browser) throws InterruptedException, IOException {
    	System.out.println("Executing" +browser);
		//WebDriverManager.chromedriver().setup();
		 if(browser.equalsIgnoreCase("CHROME")) {
	            driver = new ChromeDriver();
	        }
	        else if(browser.equalsIgnoreCase("edge")) {
	        	//WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	        }
	        else {
	            System.out.println("execution on defaul browser: " + browser);
	            //default execution on chrome browser
	           driver = new ChromeDriver();
	        }
		driver.manage().window().maximize();
		System.out.println("intiating the session");
		Thread.sleep(4000);

	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("Closing the session");
		driver.quit();
	}

}
