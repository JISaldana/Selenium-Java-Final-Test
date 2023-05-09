package scripts;

import dataProviders.CompareProductData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;


public class CompareItemsTest {

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

    @Test(dataProvider = "productCompare", dataProviderClass = CompareProductData.class)
    public void compareItemsTest(String productParam, String productParam2) throws Exception {

        driver.get("http://magento-demo.lexiconn.com/customer/account/login/");
        Login loginPage = new Login(driver);
        loginPage.setCredentials("juanignaciojobs@gmail.com", "Data123!");
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickClearAllBtn();

        // Navigate to the home page of the web application being tested.
        driver.get("http://magento-demo.lexiconn.com/");

        HomePage homePage = new HomePage(driver);
        homePage.search(productParam);
        ProductSearchPage productSearchPage = homePage.search(productParam);
        ProductPage productPage = productSearchPage.clickProduct(productParam);
        productPage.addToCompare();
        productPage.search(productParam2);
        productSearchPage.clickProduct(productParam2);
        productPage.addToCompare();

        driver.get("http://magento-demo.lexiconn.com/customer/account/");
        CompareListPopUp compareListPopUp = accountPage.clickCompareBtn();

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new window
        String parentWindowHandle = driver.getWindowHandle();
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String item1 = compareListPopUp.item1.getText();
        String item2 = compareListPopUp.item2.getText();
        assertEquals(productParam, item1);
        System.out.println("First item asserted");
        assertEquals(productParam2, item2);
        System.out.println("Second item asserted");



    }


}
