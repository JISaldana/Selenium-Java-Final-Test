package scripts;

import dataProviders.LanguagesData;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.AssertJUnit.assertEquals;


public class LanguagesTest {

    private WebDriver driver;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        ChromeOptions allowRemoteOrigins=new ChromeOptions();
        allowRemoteOrigins.addArguments("--remote-allow-origins=*");
        driver = (WebDriver) new ChromeDriver(allowRemoteOrigins);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Description ("This test check the language change functionality of the Website")
    @Test(testName = ("Languages Test "), dataProvider = "languages", dataProviderClass = LanguagesData.class)
    public void languagesTest(String lang, String welcome, String searchtext, String account, String cart, String women, String men, String accessories, String hnd, String sale, String vip) throws Exception {

        // Navigate to the home page of the web application being tested.
        driver.get("http://magento-demo.lexiconn.com");

        //Check if the text of the WebElements switch to the corresponding language
        HomePage homePage = new HomePage(driver);
        homePage.selectLang(lang);

        String welcomeText = homePage.welcomeMsg.getText();
        assertEquals(welcome, welcomeText);

        String searchBarText = homePage.searchBar.getAttribute("placeholder");
        assertEquals(searchtext, searchBarText);

        String accountText = homePage.accountBtn.getText();
        assertEquals(account, accountText);

        String cartText = homePage.cartBtn.getText();
        assertEquals(cart, cartText);

        String womenText = homePage.womenCategory.getText();
        assertEquals(women, womenText);

        String menText = homePage.menCategory.getText();
        assertEquals(men, menText);

        String accessoriesText = homePage.accessoriesCategory.getText();
        assertEquals(accessories, accessoriesText);

        String hndText = homePage.hndCategory.getText();
        assertEquals(hnd, hndText);

        String saleText = homePage.saleCategory.getText();
        assertEquals(sale, saleText);

        String vipText = homePage.vipCategory.getText();
        assertEquals(vip, vipText);



    }




}