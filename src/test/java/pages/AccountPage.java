package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

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

    //Clear the comparison list
    public void clickClearAllBtn() {
            clearAllBtn.click();
            driver.switchTo().alert().accept();
            System.out.println("There are no more items in the compare list, waiting for the next test. ");
        }

    //Open the Compare List pop-up windows
    public CompareListPopUp clickCompareBtn(){
        compareBtn.click();
        return new CompareListPopUp(driver);
    }
}