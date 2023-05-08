package dataProviders;

import org.testng.annotations.DataProvider;

public class ProductData {
    @DataProvider(name = "products")
    public static Object[][] getProductData() {
        return new Object[][]{
                {"LARGE CAMERA BAG", "$120.00", "$9.90"},
                {"RETRO CHIC EYEGLASSES", "$295.00", "$24.34"},
                {"16GB MEMORY CARD", "$30.00", "$2.48"},
        };
    }
}