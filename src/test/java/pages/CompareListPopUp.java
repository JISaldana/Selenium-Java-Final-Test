package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompareListPopUp {

    public static WebDriver driver;
    public CompareListPopUp(WebDriver driver) {
        CompareListPopUp.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "td:nth-child(2) > .product-name > a")
    public WebElement item1;

    @FindBy (css = ".last > .product-name > a")
    public WebElement item2;



}
