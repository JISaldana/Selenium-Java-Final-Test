package scripts;

import dataProviders.ProductData;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import static org.testng.AssertJUnit.assertEquals;


public class TaxCheckTest {

    private WebDriver driver;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        ChromeOptions allowRemoteOrigins=new ChromeOptions();
        allowRemoteOrigins.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(allowRemoteOrigins);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Description("This test verifies the correct display of taxes in the cart.")
    @Test(testName = ("Tax Check "), dataProvider = "products", dataProviderClass = ProductData.class)
    public void taxCheck(String productParam, String priceParam, String taxParam) throws Exception {


        // Navigate to the home page of the web application being tested.
        driver.get("http://magento-demo.lexiconn.com/");

        // Add item to the cart
        HomePage homePage = new HomePage(driver);
        homePage.search(productParam);
        ProductSearchPage productSearchPage = homePage.search(productParam);
        ProductPage productPage = productSearchPage.clickProduct(productParam);
        Cart cart = productPage.addItem();

        //Check if the taxes are correct
        assertEquals(cart.tax.getText(), taxParam);



    }




}