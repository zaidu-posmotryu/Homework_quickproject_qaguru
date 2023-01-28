package test.java;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestWildBerries extends test.java.BaseTest {

    PageWildBerries pageWildBerries = new PageWildBerries();
    String phone = "iphone", model = "iphone 12", brand = "Apple";

    @Test
    @Tag("systemPropertiesTest")
    @Feature("Проверка поиска телефонов на Wildberries.ru")
    @Story("Найти модель iPhone 12 синего цвета")
    @DisplayName("Проверяем автоподсказку в строке поиска и фильтр цвета")
    @Owner("Daria Cherchimtseva")
    public void wildBerriesHasIphone() {
        pageWildBerries
                .openWebsite()
                .inputSearchPhone(phone)
                .checkSearchPhone(phone)
                .searchAutocompleteHintPhoneModel(model)
                .searchFilterPhoneModelBrand(model, brand)
                .chooseBluePhones()
                .searchFilterBlueAndBrand(brand);
    }
}
