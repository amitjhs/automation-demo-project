package demo.testng.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SimplePage extends BasePage{

	   // Default Constructor
    public SimplePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(how = How.XPATH, using = "//div[@id='productDetail']")
    private WebElement _productDetailsPage;

    @FindBy(how = How.CLASS_NAME, using = "sku")
    private WebElement _productSku;

    @FindBy(how = How.XPATH, using = "//select[@title='Packaged Quantity']")
    private WebElement _packagedQtyDropDown;

    @FindBy(how = How.XPATH, using = "//div[@class='secondaryDesc']")
    private WebElement _productDescription;

 
    public boolean isLoaded() {
            waitForElement(_productDetailsPage);
            return isElementPresent(_productDetailsPage);
        }
    
    public void selectProductVariantByValue(String value) {
    	setElementInVisibleArea(_packagedQtyDropDown);
        Select _dropdown = new Select(_packagedQtyDropDown);
        _dropdown.selectByValue(value);
        waitForPageLoaded();
    }
    public String getProductDescription() {
        return _productDescription.getText();
    }
}