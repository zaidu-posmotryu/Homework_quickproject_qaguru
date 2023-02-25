package test;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WbSearchPage;

public class WbSearchTest extends TestBase {

    WbSearchPage wbSearchPage = new WbSearchPage();
    String phone = "iphone", model = "iphone 12", brand = "Apple";

    @Test
    //@Feature("Проверка поиска телефонов на Wildberries.ru")
    //@Story("Найти модель iPhone 12 синего цвета")
    @DisplayName("Проверяем автоподсказку в строке поиска и фильтр цвета")
    @Owner("Daria Cherchimtseva")
    public void wildBerriesHasIphone() {
        wbSearchPage
                .openWebsite()
                .inputSearchPhone(phone)
                .checkSearchPhone(phone)
                .searchAutocompleteHintPhoneModel(model)
                .searchFilterPhoneModelBrand(model, brand)
                .chooseBluePhones()
                .searchFilterBlueAndBrand(brand);
    }
}
