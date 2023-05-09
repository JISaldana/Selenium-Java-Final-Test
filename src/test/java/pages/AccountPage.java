package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    public WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = ".block-content:nth-child(2) span > span")
    public WebElement compareBtn;

    @FindBy (linkText = "Clear All")
    public WebElement clearAllBtn;

    public void clickClearAllBtn() {
        clearAllBtn.click();
        driver.switchTo().alert().accept();
    }

    public CompareListPopUp clickCompareBtn(){
        compareBtn.click();
        return new CompareListPopUp(driver);
    }
}