package com.simplepage.functionaltest.FrameworkHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.Dimension;


import java.util.Arrays;

import static org.openqa.selenium.remote.BrowserType.*;


public class BrowserFactory {

	
	public WebDriver getDriver(String browser, String resolution) {
		
		if (FIREFOX.equals(browser)) {

			return getFirefoxDriver();

		} else if (CHROME.equals(browser)) {

			return getChromeDriver(resolution);

		} else if (IE.equals(browser)) {

			return getIEDriver();

		} else if (EDGE.equals(browser)) {

			return getEdgeDriver();

		} else if (SAFARI.equals(browser)) {

			return getSafariDriver();

		} else {

			return getFirefoxDriver();
		}
	}

	private WebDriver getFirefoxDriver() {
		String driverPath = getClass().getClassLoader().getResource("browsers/windows/geckodriver.exe").getPath();
		if ("Mac".equals(getOS())){
			driverPath = getClass().getClassLoader().getResource("browsers/mac/geckodriver").getPath();
		}
		System.setProperty("webdriver.gecko.driver", driverPath);
		FirefoxOptions options = new FirefoxOptions();
		return new FirefoxDriver(options);
	}

	private WebDriver getChromeDriver(String resolution) {
		String driverPath = getClass().getClassLoader().getResource("browsers/windows/chromedriver.exe").getPath();
		if ("Mac".equals(getOS())){
			driverPath = getClass().getClassLoader().getResource("browsers/mac/chromedriver").getPath();
		}

		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches", "--disable-extensions");

		if(!resolution.contains("custom"))
		{
			options.addArguments(String.format("--window-size=%s",resolution));
		}

		System.setProperty("webdriver.chrome.driver", driverPath);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		return new ChromeDriver(options);
	}

	private WebDriver getEdgeDriver() {
		String driverPath = getClass().getClassLoader().getResource("browsers/windows/MicrosoftWebDriver.exe").getPath();
		System.setProperty("webdriver.edge.driver", driverPath);

		return new EdgeDriver();
	}

	private WebDriver getIEDriver() {
		String driverPath = getClass().getClassLoader().getResource("browsers/windows/IEDriverServer.exe").getPath();
		System.setProperty("webdriver.ie.driver", driverPath);

		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability("unexpectedAlertBehaviour", "ignore");

		return new InternetExplorerDriver(capabilities);
	}

	private WebDriver getSafariDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.safari();
		capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "ignore");

		return new SafariDriver(capabilities);
	}

	public Dimension resizeBrowser(String resolution) {
		String[] tokens = resolution.split(",", -1);

		Integer width = Integer.valueOf(tokens[0]);
		Integer hight = Integer.valueOf(tokens[1]);
		Dimension d = new Dimension(width,hight);
	//Resize current window to the set dimension
		return d;
	}


	public String getOS () {
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("win")) {

			return "Windows";

		} else if (os.contains("nux") || os.contains("nix")) {

			return "Linux";

		} else if (os.contains("mac")) {

			return "Mac";

		} else if (os.contains("sunos")) {

			return "Solaris";

		} else {

			return "Other";

		}
	}

}
