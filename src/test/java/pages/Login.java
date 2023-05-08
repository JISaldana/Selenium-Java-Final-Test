package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    public static WebDriver driver;

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

    public void setCredentials (String email, String pass){
        emailBox.sendKeys(email);
        passBox.sendKeys(pass);
        loginBtn.click();

    }

}
