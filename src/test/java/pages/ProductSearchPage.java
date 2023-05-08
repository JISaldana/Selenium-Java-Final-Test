package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPage {
    private static WebDriver driver;

    ProductSearchPage(WebDriver driver) {
        ProductSearchPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductPage clickProduct(String product) {
        WebElement productLink = driver.findElement(By.linkText(product)); // Finds the WebElement for the product link using the product name
        productLink.click(); // Clicks on the product link
        return new ProductPage(driver); // Returns a new instance of the ProductPage with the driver passed to it
    }

}