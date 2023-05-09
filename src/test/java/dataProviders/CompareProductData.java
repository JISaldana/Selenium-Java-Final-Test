package dataProviders;

import org.testng.annotations.DataProvider;

public class CompareProductData {
    @DataProvider(name = "productCompare")
    public static Object[][] getCompareProductData() {
        return new Object[][]{
                {"LARGE CAMERA BAG", "RETRO CHIC EYEGLASSES"},
        };
    }
}