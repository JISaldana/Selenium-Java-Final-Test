package dataProviders;

import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name = "credentials")
    public static Object[][] getsLoginData() {
        return new Object[][]{
                {"juanignaciojobs@gmail.com", "Data123!"},
                {"juanignaciojobs@gmail.com", "n-a"},
                {"n-a@n-a", "Data123!"},
                {"n-a@n-a", "n-a"}
        };
    }
}