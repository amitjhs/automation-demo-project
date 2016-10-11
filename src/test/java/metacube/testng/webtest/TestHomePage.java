package metacube.testng.webtest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.metacube.testng.ApplicationPages.HomePage;
import com.metacube.testng.ApplicationPages.ProductDetails;
import com.metacube.testng.FrameworkHelper.MAssert;

public class TestHomePage extends BaseTest{

	@BeforeMethod
	public void TestHomePage()
	{
		homePage = new HomePage(driver);
		productDetails = new ProductDetails(driver);
	}

	@Test
	public void GivenApplicationWhenUserRenderAppicationThenApplicationHomePageShouldRender() {
		MAssert.assertAreEqual(homePage.getTitle(),"My Store");
	}

	@Test
	public void GivenFeaturedProductsWhenUSerLaunchHomePageFeaturedProductsShouldLauchOnHomePage() {
		MAssert.assertTrue(homePage.getHomePageFeaturedProducts().size()>1);
	}

	@Test
	public void GivenMerchandisingZonesOnHomePageWhenUserLaunchHomePageHomePageMorethanOneSliderShouldLaunch() {
		MAssert.assertTrue(homePage.getHomePageSliders().size()>1);
	}

	@Test
	public void GivenFeaturedProductOnHomePageWhenClickOnOneThenProductDetailsPageShouldRender() {
		homePage.selectFeaturedProductFromHomePage();
		MAssert.assertAreEqual(productDetails.getTitle(),"Product Details");
	}
}
