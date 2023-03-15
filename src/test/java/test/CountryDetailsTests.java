package test;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.CountryDetailsPage;
import pages.ProductSearchPage;
import java.util.List;
import java.util.stream.Stream;

public class CountryDetailsTests extends TestBase {

    ProductSearchPage productSearchPage = new ProductSearchPage();
    CountryDetailsPage countryDetailsPage = new CountryDetailsPage();
    String phone = "iphone", currency = "тг.", city = "Алматы";
    static Stream<Arguments> deliveryBannerTextDataProvider() {
        return Stream.of(
                Arguments.of(List.of("Как сделать заказ", "Способы оплаты", "Возврат товара", "Возврат денежных средств", "Правила продажи", "Правила пользования торговой площадкой", "Вопросы и ответы")));
    }

    @BeforeEach
    void searchProduct() {
        productSearchPage
                .openWebsite();
    }

    @Test
    @Story("Проверка смены параметров покупателя")
    @DisplayName("Сменить валюту и проверить, что цены отображаются в новой валюте")
    public void countryCurrency() {
        productSearchPage.inputSearchPhone(phone);
        countryDetailsPage.changeCurrency(currency);
    }

    @Test
    @Story("Проверка смены параметров покупателя")
    @DisplayName("Сменить город. проверить наличие определенного пункта в списке")
    public void deliveryAddress() {
        countryDetailsPage.findDeliveryAddress(city);
    }

    @MethodSource("deliveryBannerTextDataProvider")
    @ParameterizedTest
    @Story("Проверка смены параметров покупателя")
    @DisplayName("Проверить, что в баннере нужный текст")
    public void deliveryBannerTextCheck(List<String> menuTexts) {
        countryDetailsPage.checkBannerText(menuTexts);
    }
}
