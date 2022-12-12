package POMtest;

import org.testng.annotations.Test;

public class LoginTest extends base {

	@Test
	public void verifyLogin() throws Exception {
		Thread.sleep(3000);
		// validation of application title before login
		lp.verificationAppTitle("Your store. Login");
		// test data
		lp.enterEmail(conf.getEmail());
		lp.enterPass(conf.getPass());
		lp.clickRememberCheckbox();
		lp.clickLoginButton();
		Thread.sleep(3000);
		// validation of application title before login
		lp.verificationAppTitle("Dashboard / nopCommerce administration");
	}

	// @Test
	public void verifyLogout() {
		lp.clickLoginButton();
	}

}
