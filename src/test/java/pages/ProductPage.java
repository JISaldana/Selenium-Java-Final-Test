package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private static WebDriver driver;
    @FindBy (className = "btn-cart")
    public static WebElement addCartBtn;

    public ProductPage(WebDriver driver) {
        ProductPage.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public Cart addItem(){
        addCartBtn.click();
        return new Cart(driver);
    }


}
