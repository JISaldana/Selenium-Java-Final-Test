package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private static WebDriver driver;

    public ProductPage(WebDriver driver) {
        ProductPage.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (className = "btn-cart")
    public static WebElement addCartBtn;

    @FindBy (className = "link-compare")
    public WebElement addCompareListBtn;

    //Add item to cart
    public Cart addItem(){
        addCartBtn.click();
        return new Cart(driver);
    }
    //Add item to compare list
    public void addToCompare(){
        addCompareListBtn.click();
    }

    @FindBy(id = "search")
    public WebElement searchBar;

    //Search the product
    public ProductSearchPage search(String product){
        searchBar.sendKeys(product);
        searchBar.sendKeys(Keys.ENTER);
        return new ProductSearchPage(driver);
    }

}
