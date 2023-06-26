package dataProviders;

import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name = "credentials")
    public static Object[][] getsLoginData() {
        return new Object[][]{
                {"juanignaciojobs@gmail.com", "Data123!"},
                {"juanignaciojobs@gmail.com", "n-an-a"},
                {"n-a@n-a.com", "Data123!"},
        };
    }
}