package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    public WebDriver driver;

    public Login(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "pass")
    public static WebElement passBox;

    @FindBy(id = "send2")
    public static WebElement loginBtn;

    @FindBy (className = "error-msg")
    public WebElement accessErrorMsg;

    public boolean existErrorMsg(){
        return accessErrorMsg.isDisplayed();
    }

    @Step("Type credentials email: {email} and Password: {pass}")
    public HomePage setCredentials (String email, String pass){
        emailBox.sendKeys(email);
        passBox.sendKeys(pass);
        loginBtn.click();

        return new HomePage(driver);
    }

}
