package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import dataProviders.LanguagesData;

public class HomePage {
    public static WebDriver driver;

    public HomePage(WebDriver driver) {
        HomePage.driver=driver;
        PageFactory.initElements(driver, HomePage.class);
    }

    @FindBy(id = "select-language")
    private WebElement langDropdown;

    public void selectLang(String lang) {
        langDropdown.click();
        WebElement langSelected = driver.findElement(By.xpath("//option[.='" + lang + "']"));
        langSelected.click();
    }

    @FindBy(xpath = "/html/body/div/div[2]/div[1]/div/p")
    public static WebElement welcomeMsg;

    public String getMsgText(){
        return welcomeMsg.getText();
    }

    @FindBy(id = "search")
    public WebElement searchBar;

    public ProductSearchPage search(String product){
        searchBar.sendKeys(product);
        searchBar.sendKeys(Keys.ENTER);
        return new ProductSearchPage(driver);
    }

    @FindBy(className = "skip-account")
    public static WebElement accountBtn;

    @FindBy(className = "skip-cart")
    public static WebElement cartBtn;

    @FindBy(className = "level0 nav-1")
    public static WebElement womenCategory;
    @FindBy(className = "level0 nav-2")
    public static WebElement menCategory;
    @FindBy(className = "level0 nav-3")
    public static WebElement accessoriesCategory;
    @FindBy(className = "level0 nav-4")
    public static WebElement hndCategory;
    @FindBy(className = "level0 nav-5")
    public static WebElement saleCategory;
    @FindBy(className = "level0 nav-6")
    public static WebElement vipCategory;





}