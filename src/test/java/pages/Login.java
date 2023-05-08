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

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/div/div/form/div/div[2]/div[1]/ul/li[1]/div/input")
    public WebElement emailBox;

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/div/div/form/div/div[2]/div[1]/ul/li[2]/div/input")
    public static WebElement passBox;

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/div/div/form/div/div[2]/div[2]/button")
    public static WebElement loginBtn;

    public void setCredentials (String email, String pass){
        emailBox.sendKeys(email);
        passBox.sendKeys(pass);
        loginBtn.click();
    }

}
