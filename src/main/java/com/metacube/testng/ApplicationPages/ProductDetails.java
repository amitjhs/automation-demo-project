package com.metacube.testng.ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.metacube.testng.FrameworkHelper.Browser;

public class ProductDetails {

	private WebDriver driver;
	
	@FindBy(xpath = "")
	private WebElement _local;

	// Default Constructor
	public ProductDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ProductDetails Load(String url) {
		driver.get(url);
		return this;
	}
	
	public String getTitle()
	{
		return Browser.getTitle(driver);
	}
	
	
	public ProductDetails isLoaded() {
		return this;
	}

	public void clickOnLink(String linkText){
		driver.findElement(By.linkText(linkText)).click();
	}
}
