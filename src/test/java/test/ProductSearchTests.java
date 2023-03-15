package test;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ProductSearchPage;

public class ProductSearchTests extends TestBase {

    ProductSearchPage productSearchPage = new ProductSearchPage();
    String phone = "iphone", model = "iphone 12", brand = "Apple";

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
    @DisplayName("Проверяем, что отображается окно быстрого просмотра")
    public void quickView() {
        productSearchPage.hoverForQuickView();
    }

    @Test
    @Story("Проверка поиска по сайту")
    @DisplayName("Проверяем переход на страницу товара")
    public void onProductPage() {
        productSearchPage.goToProductPage();
    }
}