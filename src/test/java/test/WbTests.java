package test;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SearchPage;

public class WbTests extends TestBase {

    SearchPage searchPage = new SearchPage();
    String phone = "iphone", model = "iphone 12", brand = "Apple";

    @BeforeEach
    void searchInput() {
        searchPage
                .openWebsite()
                .inputSearchPhone(phone);
    }

    @Test
    //@Feature("Проверка поиска телефонов на Wildberries.ru")
    //@Story("Найти модель iPhone 12 синего цвета")
    @DisplayName("Проверяем работу поисковой строки")
    @Owner("Daria Cherchimtseva")
    public void checkSearch() {
        searchPage.checkSearchPhone(phone);
    }

    @Test
    @DisplayName("Проверяем работу автоподсказки в поисковой строке")
    @Owner("Daria Cherchimtseva")
    public void checkAutoHint() {
        searchPage
                .searchAutocompleteHintPhoneModel(model)
                .searchFilterPhoneModelBrand(model, brand);
    }

    @Test
    @DisplayName("Проверяем работу фильтра цвета")
    @Owner("Daria Cherchimtseva")
    public void checkColorFilter() {
        searchPage
                .chooseBluePhones()
                .searchFilterBlueAndBrand(brand);
    }

    /*@Test
    @DisplayName("Проверяем, что при клике на цену в карточке товара открывается страница товара")
    @Owner("Daria Cherchimtseva")
    public void checkProductPageIsOpened() {

    }*/
}
