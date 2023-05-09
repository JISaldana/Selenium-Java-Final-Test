package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    public static WebDriver driver;

    public HomePage(WebDriver driver) {
        HomePage.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "select-language")
    public WebElement langDropdown;

//    @Step("Select language")
    public void selectLang(String lang) {
        langDropdown.click();
        WebElement langSelected = driver.findElement(By.xpath("//option[.='" + lang + "']"));
        langSelected.click();
    }

    @FindBy(className = "welcome-msg")
    public WebElement welcomeMsg;

    public String getMsgText(){
        return welcomeMsg.getText();
    }

    @FindBy(id = "search")
    public WebElement searchBar;

//    @Step("Search the product")
    public ProductSearchPage search(String product){
        searchBar.sendKeys(product);
        searchBar.sendKeys(Keys.ENTER);
        return new ProductSearchPage(driver);
    }

    @FindBy(className = "skip-account")
    public WebElement accountBtn;

    @FindBy(className = "skip-cart")
    public WebElement cartBtn;

    @FindBy(className = "nav-1")
    public WebElement womenCategory;
    @FindBy(className = "nav-2")
    public WebElement menCategory;
    @FindBy(className = "nav-3")
    public  WebElement accessoriesCategory;
    @FindBy(className = "nav-4")
    public WebElement hndCategory;
    @FindBy(className = "nav-5")
    public WebElement saleCategory;
    @FindBy(className = "nav-6")
    public WebElement vipCategory;





}