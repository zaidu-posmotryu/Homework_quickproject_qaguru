package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductSearchPage {
    SelenideElement
            searchBox = $x("//*[@id='searchInput']"),
            searchBtn = $x("//button[@id='applySearchBtn']"),
            catalog = $x("//div[@class='product-card-list']"),
            autoHintText = $x("//div[@class='autocomplete__scroll-container']"),
            queryFilter = $x("//button[@class='dropdown-filter__btn dropdown-filter__btn--burger']"),
            filterColor = $x("//button[contains(text(),'Цвет')]"),
            dropdownColor = $x("(//div[@class='dropdown-filter__content'])[5]"),
            selectedColor = $x("//span[contains(text(),'синий')]//span[@class='checkbox-with-text__color']"),
            submitButtonColor = $x("//button[contains(text(),'Готово')]"),
            chosenParameter = $x("//span[@class='your-choice__btn']"),
            productCard = $x("//a[@class='product-card__main j-card-link']"),
            buttonQuickView = $x("//button[contains(@type,'button')][contains(text(),'Быстрый просмотр')]"),
            popupQuickView = $x("//div[@class='product']"),
            article = $x("//span[contains(text(),'Артикул:')]"),
            productId = $x("//span[@id='productNmId']");
    ElementsCollection
            results = $$x("//span[@class='goods-name']"),
            autoHints = $$x("//p[@class='autocomplete__text']"),
            appleResults = $$x("//span[@class='brand-name']"),
            blueAppleResults = $$x("//span[@class='brand-name']");

    @Step("Открыть сайт")
    public ProductSearchPage openWebsite() {
        open(baseUrl);
        return this;
    }

    @Step("Сделать поисковый запрос, введя {phone} в строку поиска")
    public ProductSearchPage inputSearchPhone(String phone) {
        searchBox.scrollTo().click();
        searchBox.setValue(phone);
        searchBtn.click();
        catalog.shouldBe(visible, Duration.ofMillis(4000));
        sleep(4000);
        return this;
    }

    @Step("Проверить, что все результаты поиска содержат {phone}")
    public ProductSearchPage checkSearchPhone(String phone) {
        results.shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : results) {
            element.shouldHave(text(phone));
        }
        return this;
    }

    @Step("Осуществить поиск, кликнув на подсказку {model} в поисковой строке")
    public ProductSearchPage searchAutocompleteHintPhoneModel(String model) {
        searchBox.click();
        autoHintText.shouldBe(visible);
        autoHints.shouldHave(CollectionCondition.sizeGreaterThan(0));
        autoHints.findBy(exactText(model)).click();
        return this;
    }

    @Step("Проверить, что в блоке фильтра запроса отображается {model} и все результаты поиска содержат {brand}")
    public ProductSearchPage searchFilterPhoneModelBrand(String model, String brand) {
        queryFilter.shouldHave(text(model));
        appleResults.shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : appleResults) {
            element.shouldHave(text(brand));
        }
        return this;
    }

    @Step("Выбрать фильтр 'Цвет', в выпадающем списке кликнуть чекбокс 'Синий', нажать кнопку 'Готово'")
    public ProductSearchPage chooseBluePhones() {
        filterColor.click();
        dropdownColor.shouldBe(visible);
        selectedColor.click();
        submitButtonColor.shouldBe(visible).click();
        return this;
    }

    @Step("Проверить, что в блоке фильтра поиска отображается 'синий' и все результаты поиска синих телефонов содержат бренд {brand}")
    public ProductSearchPage searchFilterBlueAndBrand(String brand) {
        chosenParameter.shouldHave(text("синий"));
        blueAppleResults.shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : blueAppleResults) {
            element.shouldHave(text(brand));
        }
        return this;
    }

    @Step("Проверить, что при наведении курсора на карточку товара появляется кнопка 'Быстрый просмотр', по клику на нее открывается всплывающее окно просмотра")
    public ProductSearchPage hoverForQuickView() {
        productCard.hover().shouldHave(text("Быстрый просмотр"));
        buttonQuickView.click();
        popupQuickView.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что при клике на карточку товара открывается страница товара")
    public ProductSearchPage goToProductPage() {
        productCard.click();
        article.shouldBe(visible);
        String currentUrl = url();
        String articleFromUrl = currentUrl.substring(35, 44);
        String productIdText = productId.getText();
        assertEquals(articleFromUrl, productIdText);
        return this;
    }
}
