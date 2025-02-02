package demo.testng.webtest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.simplepage.functionaltest.FrameworkHelper.*;

import demo.testng.page.SimplePage;

public class SimplePageTest extends BaseTest {
    private SimplePage page;

    @BeforeMethod
    public void setup() {
        this.page = new SimplePage(driver);
    }

    @Test(dataProvider="productvariant")
    public void VerifyProductDescriptionBasedOnProductVariant(String variant, String description) {
    	MAssert.assertTrue(page.isLoaded());
        page.selectProductVariantByValue(variant);
        String productSku = page.getProductDescription();
        MAssert.assertAreEqual(productSku,description);
    }
    
    @DataProvider
    public Object[][] productvariant() throws Exception{
  	    // Setting up the Test Data Excel file
        String xlsFileName = getClass().getClassLoader().getResource("DataSet/productdetails.xls").getPath();
    	Object[][] testObjArray = Excel.ReadExcelSheet(xlsFileName,"product");
       	return (testObjArray);
  		}
}