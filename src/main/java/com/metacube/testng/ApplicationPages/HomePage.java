package com.metacube.testng.ApplicationPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.metacube.testng.FrameworkHelper.Browser;

public class HomePage {

	private WebDriver driver;

	@FindBy(xpath = "")
	private WebElement _local;

	@FindBy(xpath = ".//div[@id='homepage-slider']//li")
	private List <WebElement> _homePageSliders;
	
	@FindBy(xpath = "//ul[@id='homefeatured']//li/div[@class='product-container']")
	private List <WebElement> _productContainers;
	
	
	// Default Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitle()
	{
		return Browser.getTitle(driver);
	}
	
	public HomePage isLoaded() {
		return this;
	}

	public void clickOnLink(String linkText){
		driver.findElement(By.linkText(linkText)).click();
	}
	
	public List <WebElement> getHomePageSliders()
	{
		return _homePageSliders;
	}
	
	public List <WebElement> getHomePageFeaturedProducts()
	{
		return _productContainers;
	}

	public HomePage selectFeaturedProductFromHomePage()
	{
		_productContainers.get(2).findElement(By.tagName("a")).click();
		return this;
	}
}
