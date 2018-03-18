package demo.testng.webtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.simplepage.functionaltest.FrameworkHelper.*;



public class BrowserResolutionTest {
	WebDriver driver;
 //   private SimplePage page;
    private Prop prop = new Prop();
    public String defaultURL = prop.get("BaseURL");
  
    @Test(dataProvider="browser")
    public void LaunchBrowserWithDifferentResolutions(String browser,String resolution) {
    	driver = new BrowserFactory().getDriver(browser,resolution);
		driver.get(defaultURL);
	//	this.page = new SimplePage(driver);
    	//MAssert.assertTrue(page.isLoaded());
    }

    @DataProvider
    public String[][] browser() throws Exception{
  	    // Setting up the Test Data Excel file
    	 String xlsFileName = getClass().getClassLoader().getResource("DataSet/browser.xls").getPath();
    	 String[][] testObjArray = Excel.ReadExcelSheet(xlsFileName,"product");
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

