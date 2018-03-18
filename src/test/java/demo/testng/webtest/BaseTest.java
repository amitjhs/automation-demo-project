package demo.testng.webtest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.simplepage.functionaltest.FrameworkHelper.*;

import java.io.IOException;

public class BaseTest {

	public WebDriver driver;

    private Prop prop = new Prop();

    public String defaultURL = prop.get("BaseURL");

    @BeforeClass(alwaysRun = true)
	@Parameters({"browser", "resolution"})
	public void LaunchApplication(@Optional("chrome") String browser, @Optional("1920,1080") String resolution) {
		driver = new BrowserFactory().getDriver(browser, resolution);
		driver.get(defaultURL);
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		releaseWebDriver();
	}

	private void releaseWebDriver() {
		if (driver == null){
			return;
		}
    	driver.quit();
		if (driver.toString().contains("InternetExplorerDriver")) {
			try {
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		driver = null;
	}

}