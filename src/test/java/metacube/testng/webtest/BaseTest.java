package metacube.testng.webtest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.metacube.testng.ApplicationPages.GoogleSearchPage;
import com.metacube.testng.ApplicationPages.HomePage;
import com.metacube.testng.ApplicationPages.ProductDetails;
import com.metacube.testng.FrameworkHelper.Browser;
import com.metacube.testng.FrameworkHelper.LaunchingBrowser;
import com.metacube.testng.FrameworkHelper.Prop;
public class BaseTest {
	public WebDriver driver;
	public Properties envProp;
	static public String defaultURL;
	public HomePage homePage;
	public ProductDetails productDetails;
	public BaseTest()

	{
		envProp = Prop.LoadProperties("Environment.properties");
		//public final String  defaultBrowser = envProp.getProperty("defaultBrowser");
		defaultURL = "http://"+ envProp.getProperty("BaseURL")
				+"/" + envProp.getProperty("ApplicationURL");
	}

	public WebDriver LaunchBrowser(String _browser2) {
		LaunchingBrowser br = LaunchingBrowser.valueOf(_browser2);
		WebDriver _driver = null;
		switch(br)
		{
		case IE:
			_driver = Browser.getWebDriver(LaunchingBrowser.IE);
			break;

		case FireFox:
			_driver = Browser.getWebDriver(LaunchingBrowser.FireFox);
			break;

		case Chrome:
			_driver = Browser.getWebDriver(LaunchingBrowser.Chrome);
			break;
		}
		return _driver;
	}
	
	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void LaunchApplication(@Optional("Chrome") String  _browser)
	{
		if(driver!=null)
			return;

		WebDriver _driver = LaunchBrowser(_browser);
		_driver.get(defaultURL);
		this.driver = _driver;
	}
	
	@AfterClass(alwaysRun = true)
	public void CloseBrowser() {
		Browser.releaseWebDriver(driver);

	}

	
}