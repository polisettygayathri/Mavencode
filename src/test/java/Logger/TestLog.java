package Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLog extends BaseTest{

	@Test
    public void verifyLogin() throws Exception {
		Thread.sleep(4000);
		WebElement txt_Email = driver.findElement(By.xpath("//input[@id='Email']"));
        txt_Email.clear();
        log.info("enter username"+ conf.getEmail());
        txt_Email.sendKeys(conf.getEmail());
        driver.findElement(By.xpath("//input[@type=\"password\"]")).clear();
        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(conf.getPass());
        driver.findElement(By.xpath("//button[contains(text(),'Log')]")).click();
        System.out.println("login test case'");
        Thread.sleep(4000);
        String actualTitle = driver.getTitle();
        System.out.println("Application Title after login: " + actualTitle);
       Thread.sleep(4000);
        //click on Logout
        driver.findElement(By.xpath("//a[contains(text(),'Log')]")).click();
        Thread.sleep(8000);
    }

}

        
        
