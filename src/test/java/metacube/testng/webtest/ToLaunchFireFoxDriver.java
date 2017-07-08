package metacube.testng.webtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestToLaunchGecoDriver {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","D:\\Automation\\WebDriver\\Metacube\\Browsers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.metacube.com");
	}
}