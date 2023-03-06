package test;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CountryDetailsPage;
import pages.ProductSearchPage;

public class WbTests extends TestBase {

    ProductSearchPage productSearchPage = new ProductSearchPage();
    CountryDetailsPage countryDetailsPage = new CountryDetailsPage();
    String phone = "iphone", model = "iphone 12", brand = "Apple", currency = "тг.", city = "Алматы";

    @BeforeEach
    void searchProduct() {
        productSearchPage
                .openWebsite()
                .inputSearchPhone(phone);
    }

    @Test
    @Story("Проверка поиска по сайту")
    @DisplayName("Проверяем работу поисковой строки")
    public void searchCheck() {
        productSearchPage.checkSearchPhone(phone);
    }

    @Test
    @Story("Проверка поиска по сайту")
    @DisplayName("Проверяем работу автоподсказки в поисковой строке")
    public void autoHint() {
        productSearchPage
                .searchAutocompleteHintPhoneModel(model)
                .searchFilterPhoneModelBrand(model, brand);
    }

    @Test
    @Story("Проверка поиска по сайту")
    @DisplayName("Проверяем работу фильтра цвета")
    public void colorFilter() {
        productSearchPage
                .chooseBluePhones()
                .searchFilterBlueAndBrand(brand);
    }

    @Test
    @Story("Проверка поиска по сайту")
    @DisplayName("Проверяем, что работает окно быстрого просмотра")
    public void quickView() {
        productSearchPage.hoverForQuickView();
    }

    @Test
    @Story("Проверка поиска по сайту")
    @DisplayName("Страница товара")
    public void onProductPage() {
        productSearchPage.goToProductPage();
    }

    @Test
    @Story("Проверка смены параметров покупателя")
    @DisplayName("Сменить валюту и проверить, что цены отображаются в новой валюте")
    public void countryCurrency() {
        countryDetailsPage.changeCurrency(currency);
    }

    @Test
    @Story("Проверка смены параметров покупателя")
    @DisplayName("Смена адреса выдачи")
    public void deliveryAddress() {
        countryDetailsPage.findDeliveryAddress(city);
    }
}
