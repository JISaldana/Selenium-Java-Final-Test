package scripts;

import dataProviders.CompareProductData;
import io.qameta.allure.Description;
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

    @Description("This test verifies the correct display of the compare list popup")
    @Test(testName = ("Comparison list test "), dataProvider = "productCompare", dataProviderClass = CompareProductData.class)
    public void compareItemsTest(String productParam, String productParam2) throws Exception {

        driver.get("http://magento-demo.lexiconn.com/customer/account/login/");

        // Login into the system
        Login loginPage = new Login(driver);
        loginPage.setCredentials("juanignaciojobs@gmail.com", "Data123!");
        AccountPage accountPage = new AccountPage(driver);

        // Navigate to the home page of the web application being tested.
        driver.get("http://magento-demo.lexiconn.com/");

        // Adds 2 items to the comparison list
        HomePage homePage = new HomePage(driver);
        homePage.search(productParam);
        ProductSearchPage productSearchPage = homePage.search(productParam);
        ProductPage productPage = productSearchPage.clickProduct(productParam);
        productPage.addToCompare();
        productPage.search(productParam2);
        productSearchPage.clickProduct(productParam2);
        productPage.addToCompare();

        // Go to my account page
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
        //Check that both items have been successfully uploaded to the compare list
        String item1 = compareListPopUp.item1.getText();
        String item2 = compareListPopUp.item2.getText();
        assertEquals(productParam, item1);
        assertEquals(productParam2, item2);

        //Clear compare list
        driver.switchTo().window(parentWindowHandle);
        accountPage.clickClearAllBtn();



    }


}
