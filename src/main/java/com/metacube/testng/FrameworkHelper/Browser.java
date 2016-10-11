package com.metacube.testng.FrameworkHelper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;


public class Browser 
{
	private static WebDriver _webDriver; 
	private static FirefoxDriver firefoxDriver;
	private static InternetExplorerDriver ieDriver;
	private static ChromeDriver chromeDriver;
	private static SafariDriver safariDriver;
	private static DesiredCapabilities capability=null;


	private static FirefoxDriver getFirefoxDriver()
	{
		if (firefoxDriver == null)
		{
			firefoxDriver = new FirefoxDriver();
		}

		return firefoxDriver;	

	}

	private static void setFirefoxDriver(){

		File f1 = new File("./Browsers/geckodriver.exe");  
		String Path = f1.getPath();
		System.setProperty("webdriver.gecko.driver", Path);
		_webDriver = new FirefoxDriver();
	}


	private static void setGecoDriver(){

		File f1 = new File("./Browsers/geckodriver.exe");  
		String Path = f1.getPath();
		System.setProperty("webdriver.gecko.driver", Path);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		_webDriver = new FirefoxDriver(capabilities);
		//_webDriver = new FirefoxDriver();
	}


	private static void  getIEDriver()
	{
		if (_webDriver == null)
		{
			File f1 = new File("./Browsers/IEDriverServer.exe");  
			String Path = f1.getPath();
			System.out.print("Path Is " + Path);
			System.setProperty("webdriver.ie.driver", Path);
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability("unexpectedAlertBehaviour", "ignore");
			_webDriver = new InternetExplorerDriver(capabilities);	
		}

	}

	private static void  getEdgeDriver()
	{
		if (_webDriver == null)
		{
			File f1 = new File("./Browsers");  
	    	String Path = f1.getPath() + "/MicrosoftWebDriver.exe";
	    	System.out.print("Path Is " + Path);
	    	System.setProperty("webdriver.edge.driver", Path);
	    	_webDriver = new EdgeDriver();
			
		}
	}


	private static void getChromeDriver()
	{
		if (_webDriver == null)
		{
			File f1 = new File("./Browsers/chromedriver.exe");  
			String Path = f1.getPath();
			System.out.print("Path Is " + Path);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("chrome.switches","--disable-extensions");
			System.setProperty("webdriver.chrome.driver", Path);
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
			_webDriver = new ChromeDriver(options);
		}
	}

	private static SafariDriver getSafariDriver() 
	{
		if(safariDriver == null){
			DesiredCapabilities capabilities = DesiredCapabilities.safari();
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "ignore");

			safariDriver = new SafariDriver(capabilities);
		}
		return safariDriver;
	}

	public static WebDriver getWebDriver(LaunchingBrowser driverType) {

		if (_webDriver != null) {
			return _webDriver;

		} else {

			setWebDriver(driverType);
		} 
		return _webDriver;
	}


	public static void setWebDriver(LaunchingBrowser driverType)
	{

		switch(driverType)
		{
		case FireFox:
			setFirefoxDriver();
			break;

		case IE:
			getIEDriver();
			break;

		case Chrome:
			getChromeDriver();
			break;

		case Edge:
			getEdgeDriver();
			break;

		}
	}

	public static WebDriver getDefaultDriver()
	{
		return getFirefoxDriver();
	}

	public static void releaseWebDriver(WebDriver driver)
	{
		driver.quit();
		if(_webDriver.toString().contains("InternetExplorerDriver"))
		{
			try {
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		_webDriver = null;

	}


	public static String getTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
}