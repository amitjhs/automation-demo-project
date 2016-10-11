package metacube.testng.webtest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.metacube.testng.FrameworkHelper.Browser;
import com.metacube.testng.FrameworkHelper.MAssert;

public class TestMyAccount extends BaseTest{

		@Test
	public void GivenSignInLinkOnHomePageWhenUserClickOnSignInThenMyAccountPageShouldRender() {
		String expectedTitle = "Metacube Software";
		String actualTitle = driver.getTitle();
		MAssert.assertAreEqual(actualTitle, expectedTitle);
	}
	@Test
	public void GivenEmailAddressTextBoxOnMyAccountWhenProvideInvalidEmailThenApplicationShouldRespondToInvalidEmailAddress() {
		String expectedTitle = "Metacube Software";
		String actualTitle = driver.getTitle();
		MAssert.assertAreEqual(actualTitle, expectedTitle);
	}
	@Test
	public void GivenEmailAddressTextBoxOnMyAccountWhenProvideValidButAlreadyUsedEmailThenApplicationShouldRespondToAcceptEmailButDisplayValidationMessage(){
		String expectedTitle = "Metacube Software";
		String actualTitle = driver.getTitle();
		MAssert.assertAreEqual(actualTitle, expectedTitle);
	}
	@Test
	public void GivenEmailAddressTextBoxOnMyAccountWhenProvideValidUserEmailThenApplicationShouldAcceptAndRenderCreateAnAccountPage(){
		String expectedTitle = "Metacube Software";
		String actualTitle = driver.getTitle();
		MAssert.assertAreEqual(actualTitle, expectedTitle);
	}
}
