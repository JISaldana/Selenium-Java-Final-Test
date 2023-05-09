package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {

    public static WebDriver driver;
    public Cart(WebDriver driver) {
        Cart.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".product-cart-price .price")
    public static WebElement price;

    @FindBy(css = "tr:nth-child(2) .price")
    public static WebElement tax;






}
