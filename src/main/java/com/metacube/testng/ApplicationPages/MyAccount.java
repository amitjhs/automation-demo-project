package com.metacube.testng.ApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

	private WebDriver driver;
	
	@FindBy(xpath = "")
	private WebElement _local;

	// Default Constructor
	public MyAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public MyAccount Load(String url) {
		driver.get(url);
		return this;
	}

	
	public MyAccount isLoaded() {
		return this;
	}

	public void clickOnLink(String linkText){
		driver.findElement(By.linkText(linkText)).click();
	}
}
