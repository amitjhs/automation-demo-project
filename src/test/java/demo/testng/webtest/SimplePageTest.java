package demo.testng.webtest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.simplepage.functionaltest.FrameworkHelper.MAssert;

import demo.testng.page.SimplePage;

public class SimplePageTest extends BaseTest {

    private SimplePage page;

    @BeforeMethod
    public void setup() {
        this.page = new SimplePage(driver);
    }

    @Test
    public void VerifyProductDescriptionBasedOnProductVariant() {
    	MAssert.assertTrue(page.isLoaded());
        page.selectProductVariantByValue("2 / Pack");
        String productSku = page.getProductDescription();
        MAssert.assertAreEqual(productSku,"30.3 mil Pen Point Size - Black - Blue Barrel - 2 / Pack");
    }
}

