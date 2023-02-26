package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CountryDetailsPage;
import pages.SearchPage;

public class WbTests extends TestBase {

    SearchPage searchPage = new SearchPage();
    CountryDetailsPage countryDetailsPage = new CountryDetailsPage();
    String phone = "iphone", model = "iphone 12", brand = "Apple", currency = "тг.", city = "Алматы", newaddress = "Думан";

    @BeforeEach
    void searchInput() {
        searchPage
                .openWebsite()
                .inputSearchPhone(phone);
    }

    @Test
    @DisplayName("Проверяем работу поисковой строки")
    public void searchCheck() {
        searchPage.checkSearchPhone(phone);
    }

    @Test
    @DisplayName("Проверяем работу автоподсказки в поисковой строке")
    public void autoHint() {
        searchPage
                .searchAutocompleteHintPhoneModel(model)
                .searchFilterPhoneModelBrand(model, brand);
    }

    @Test
    @DisplayName("Проверяем работу фильтра цвета")
    public void colorFilter() {
        searchPage
                .chooseBluePhones()
                .searchFilterBlueAndBrand(brand);
    }

    @Test
    @DisplayName("Проверяем, что работает окно быстрого просмотра")
    public void quickView() {
        searchPage.hoverForQuickView();
    }

    @Test
    @DisplayName("Страница товара")
    public void onProductPage() {
        searchPage.goToProductPage();
    }

    @Test
    @DisplayName("Сменить валюту и проверить, что цены отображаются в новой валюте")
    public void countryCurrency() {
        countryDetailsPage.changeCurrency(currency);
    }

    @Test
    @DisplayName("Смена адреса выдачи")
    public void deliveryAddress() {
        countryDetailsPage.findDeliveryAddress(city,newaddress);

    }

}
