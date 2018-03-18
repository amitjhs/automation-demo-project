package demo.testng.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SimplePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@ng-controller='ProductController']")
    private WebElement _productDetailsPage;

    @FindBy(how = How.CLASS_NAME, using = "sku")
    private WebElement _productSku;

    @FindBy(how = How.XPATH, using = "//select[@data-key='Packaged-Quantity']")
    private WebElement _packagedQtyDropDown;

    @FindBy(how = How.XPATH, using = "//div[@class='product-description']/span")
    private WebElement _productDescription;

    // Default Constructor
    public SimplePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded() {
        {
            waitForElement(_productDetailsPage);
            return isElementPresent(_productDetailsPage);
        }
    }

    public void selectProductVariantByValue(String value) {
        setElementInVisibleArea(_packagedQtyDropDown);
        MoveToElement(_packagedQtyDropDown);
        Select _dropdown = new Select(_packagedQtyDropDown);
        _dropdown.selectByValue(value);
        waitfor(2000);
    }

    public String getProductDescription() {
        return _productDescription.getText();
    }
}