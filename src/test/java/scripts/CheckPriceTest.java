package scripts;

import dataProviders.ProductData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Cart;
import pages.HomePage;
import pages.ProductPage;
import pages.ProductSearchPage;

import static org.testng.AssertJUnit.assertEquals;

public class CheckPriceTest {
    private WebDriver driver;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        ChromeOptions allowRemoteOrigins = new ChromeOptions();
        allowRemoteOrigins.addArguments("--remote-allow-origins=*");
        driver = (WebDriver) new ChromeDriver(allowRemoteOrigins);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "products", dataProviderClass = ProductData.class)
    public void test(String productParam, String priceParam, String taxParam) throws Exception {


        // Navigate to the home page of the web application being tested.
        driver.get("http://magento-demo.lexiconn.com/");

        // Instantiate the HomePage class to access its methods.
        HomePage homePage = new HomePage(driver);
        homePage.search(productParam);
        ProductSearchPage productSearchPage = homePage.search(productParam);
        ProductPage productPage = productSearchPage.clickProduct(productParam);
        Cart cart = productPage.addItem();
        assertEquals(cart.price.getText(), priceParam);
    }
}
