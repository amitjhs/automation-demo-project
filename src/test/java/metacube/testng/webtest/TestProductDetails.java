package metacube.testng.webtest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.metacube.testng.ApplicationPages.GoogleSearchPage;
import com.metacube.testng.FrameworkHelper.Browser;
import com.metacube.testng.FrameworkHelper.MAssert;
import com.metacube.testng.FrameworkHelper.Prop;


public class TestProductDetails extends BaseTest{
	String expectedTitle = "Metacube Software";

	@Test
	public void GivenProductsImagesOnHomePageWhenClickOnAnyProductImageThenProductDetailsPageShouldRender() {

		String actualTitle = driver.getTitle();
		MAssert.assertAreEqual(actualTitle,"B");

	}

	@Test
	public void GivenHomeIconOnBreadCrumWhenClickThenHomePageShouldRender() {

		String actualTitle = driver.getTitle();
		MAssert.assertAreEqual(actualTitle,"B");

	}

	@Test
	public void GivenAddToCartButtonWhenCLickForProductThenConfirmationMessageShouldDisplayOnOverLay() {
		String actualTitle = driver.getTitle();
		MAssert.assertAreEqual(actualTitle,"B");
	}
}
