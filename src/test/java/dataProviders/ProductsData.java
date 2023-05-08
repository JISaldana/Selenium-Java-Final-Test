package dataProviders;

import org.testng.annotations.DataProvider;

public class ProductsData {
    @DataProvider(name = "products")
    public static Object[][] getProductsData() {
        return new Object[][]{
                {"Large Camera Bag", "$120.00", "$9.90"},
//                {"RETRO CHIC EYEGLASSES", "$295.00"},
//                {"16GB MEMORY CARD", "$30.00"},
        };
    }
}