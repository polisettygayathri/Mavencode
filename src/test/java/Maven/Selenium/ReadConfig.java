package Maven.Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	public ReadConfig() throws IOException {
		// TODO Auto-generated constructor stub
		FileInputStream fis = new FileInputStream("./TestData/config.properties");
		prop = new Properties();
		prop.load(fis);		
	}
	
	public String amazon() {
		return prop.getProperty("amazonURL");
	}
	public String hyrtutorials() {
		return prop.getProperty("hyrtutorialsURL");
	}
	public String orangelive() {
		return prop.getProperty("orangeliveURL");
	}
	public String nopcommerce() {
		return prop.getProperty("nopcommerceURL");
	}
	public String testingblog() {
		return prop.getProperty("testingblogURL");
	}
	public String paytm() {
		return prop.getProperty("paytmURL");
	}

	public String getEmail() {
		return prop.getProperty("email");
	}
	public String getPass() {
		return prop.getProperty("password");
	}
	
}
