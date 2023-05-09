package pages;

import io.qameta.allure.Step;
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

    public CompareListPopUp clickCompareBtn(){
        compareBtn.click();
        return new CompareListPopUp(driver);
    }
}