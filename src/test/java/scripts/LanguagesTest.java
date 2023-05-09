package scripts;

import dataProviders.LanguagesData;
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

    @Test(dataProvider = "languages", dataProviderClass = LanguagesData.class)
    public void languagesTest(String lang, String welcome, String searchtext, String account, String cart, String women, String men, String accessories, String hnd, String sale, String vip) throws Exception {

        // Navigate to the home page of the web application being tested.
        driver.get("http://magento-demo.lexiconn.com");

        //Check if the text of the WebElements switch to the corresponding language
        HomePage homePage = new HomePage(driver);
        homePage.selectLang(lang);

        String welcomeText = homePage.welcomeMsg.getText();
        assertEquals(welcomeText, welcome);

        String accountText = homePage.searchBar.getAttribute("placeholder");
        assertEquals(accountText, searchtext);

        String expectedText = homePage.accountBtn.getText();
        assertEquals(expectedText, account);

        String cartText = homePage.cartBtn.getText();
        assertEquals(cartText, cart);

        String womenText = homePage.womenCategory.getText();
        assertEquals(womenText, women);

        String menText = homePage.menCategory.getText();
        assertEquals(menText, men);

        String accessoriesText = homePage.accessoriesCategory.getText();
        assertEquals(accessoriesText, accessories);

        String hndText = homePage.hndCategory.getText();
        assertEquals(hndText, hnd);

        String saleText = homePage.saleCategory.getText();
        assertEquals(saleText, sale);

        String vipText = homePage.vipCategory.getText();
        assertEquals(vipText, vip);



    }




}