package demo.testng.webtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.simplepage.functionaltest.FrameworkHelper.*;

import demo.testng.page.SimplePage;

public class BrowserResolutionTest {
	WebDriver driver;
    private SimplePage page;
    private Prop prop = new Prop();
    public String defaultURL = prop.get("BaseURL");
  
    @Test(dataProvider="browser")
    public void LaunchBrowserWithDifferentResolutions(String browser,String resolution) {
    	driver = new BrowserFactory().getDriver(browser,resolution);
		driver.get(defaultURL);
		this.page = new SimplePage(driver);
    	MAssert.assertTrue(page.isLoaded());
        
    }
    @DataProvider
    public String[][] browser() throws Exception{
  	    // Setting up the Test Data Excel file
    	String[][] testObjArray = Excel.ReadExcelSheet("D://Automation//git//automation-demo-project//src//test//resources//DataSet//browser.xls","product");
       	return (testObjArray);
  		}

    @AfterMethod
    public void closeBrowser() {
		releaseWebDriver();
	}

	private void releaseWebDriver() {
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

