package scripts;


import dataProviders.LoginData;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;

import io.qameta.allure.Param;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Login;

import static org.testng.AssertJUnit.assertEquals;


public class LoginTest {

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

    @Description("This test should try to log in to the website with the specified credentials")
    @Test(testName = "Login Test ",dataProvider = "credentials", dataProviderClass = LoginData.class)
    public void loginTest(String email, String pass) throws Exception {


        // Navigate to the home page of the web application being tested.
        driver.get("http://magento-demo.lexiconn.com/customer/account/login/");

        //Login into the website
        Login loginPage = new Login(driver);
        loginPage.setCredentials(email, pass);

        //Check if the login was successful
        HomePage homePage = new HomePage(driver);
        String actualMsgText = homePage.getMsgText();
        String expectedMsgText = "WELCOME, JUAN SALDAÑA!";
        assertEquals(expectedMsgText, actualMsgText);
    }
}