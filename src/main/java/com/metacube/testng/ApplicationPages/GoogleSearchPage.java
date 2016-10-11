package com.metacube.testng.ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//input[@title='Search']")
	private WebElement _searchBox;

	// Default Constructor
	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public GoogleSearchPage Load(String url) {
		driver.get(url);
		return this;
	}

	
	public GoogleSearchPage isLoaded() {
		return this;
	}

	public GoogleSearchPage Search(String searchText) {
		_searchBox.sendKeys(searchText + Keys.RETURN);
		return this;
	}

	public void clickOnLink(String linkText){
		driver.findElement(By.linkText(linkText)).click();
	}
}
