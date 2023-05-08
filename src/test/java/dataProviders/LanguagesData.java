package dataProviders;

import org.testng.annotations.DataProvider;

public class LanguagesData {
    @DataProvider(name = "languages")
    public static Object[][] getLanguagesData() {
        return new Object[][]{
                {"English", "WELCOME","Search entire store here...", "ACCOUNT", "CART", "WOMEN", "MEN", "ACCESSORIES", "HOME & DECOR", "SALE", "VIP"},
                {"French", "BIENVENUE","Rechercher la boutique entière", "COMPTE", "PANIER", "FEMMES", "HOMMES", "ACCESSOIRES", "MAISON & DÉCORATION", "VENTE", "VIP"},
                {"German", "WILLKOMMEN","Den gesamten Shop durchsuchen...", "KON", "WARENKORB", "FRAUEN", "MÄNNER", "ACCESSOIRES", "WOHNEN & DEKOR", "VERKAUF", "VIP"}
        };
    }
}