package metacube.testng.webtest;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestToLaunccEdgeDriver {

	public static void main(String[] args) {
		File f1 = new File("./Browsers");  
    	String Path = f1.getPath() + "/MicrosoftWebDriver.exe";
    	System.out.print("Path Is " + Path);
    	System.setProperty("webdriver.edge.driver", Path);
    	WebDriver driver = new EdgeDriver();
    	driver.get("http://www.mytestsite.com");
    	
	}
}