package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class SearchPage {
SelenideElement
    searchInput = $x("//input[@id='searchInput']"),
    autoHintText = $x("//div[@class='autocomplete__scroll-container']"),
    queryFilter = $x("//button[@class='dropdown-filter__btn dropdown-filter__btn--burger']"),
    filterColor = $x("//button[contains(text(),'Цвет')]"),
    dropdownColor = $x("(//div[@class='dropdown-filter__content'])[5]"),
    selectedColor = $x("//span[contains(text(),'синий')]//span[@class='checkbox-with-text__color']"),
    submitButtonColor = $x("//button[contains(text(),'Готово')]"),
    chosenParameter = $x("//span[@class='your-choice__btn']");
    ElementsCollection
    results = $$x("//span[@class='goods-name']"),
    autoHints = $$x("//p[@class='autocomplete__text']"),
    appleResults = $$x("//span[@class='brand-name']"),
    blueAppleResults = $$x("//span[@class='brand-name']");

    @Step("Открыть сайт")
    public SearchPage openWebsite() {
        open(baseUrl);
        return this;
    }

    @Step("Сделать поисковый запрос, введя {phone} в строку поиска")
    public SearchPage inputSearchPhone(String phone) {
        searchInput.click();
        searchInput.setValue(phone).pressEnter();
        return this;
    }

    @Step("Проверить, что все результаты поиска содержат {phone}")
    public SearchPage checkSearchPhone(String phone) {
        results.shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : results) {
            element.shouldHave(text(phone));
        }
        return this;
    }

    @Step("Осуществить поиск, кликнув на подсказку {model} в поисковой строке")
    public SearchPage searchAutocompleteHintPhoneModel(String model) {
        searchInput.click();
        autoHintText.shouldBe(visible);
        autoHints.shouldHave(CollectionCondition.sizeGreaterThan(0));
        autoHints.findBy(exactText(model)).click();
        return this;
    }

    @Step("Проверить, что в блоке фильтра запроса отображается {model} и все результаты поиска содержат {brand}")
    public SearchPage searchFilterPhoneModelBrand(String model, String brand) {
        queryFilter.shouldHave(text(model));
        appleResults.shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : appleResults) {
            element.shouldHave(text(brand));
        }
        return this;
    }

    @Step("Выбрать фильтр 'Цвет', в выпадающем списке кликнуть чекбокс 'Синий', нажать кнопку 'Готово'")
    public SearchPage chooseBluePhones() {
        filterColor.click();
        dropdownColor.shouldBe(visible);
        selectedColor.click();
        submitButtonColor.shouldBe(visible).click();
        return this;
    }

    @Step("Проверить, что в блоке фильтра поиска отображается 'синий' и все результаты поиска синих телефонов содержат бренд {brand}")
    public SearchPage searchFilterBlueAndBrand(String brand) {
        chosenParameter.shouldHave(text("синий"));
        blueAppleResults.shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : blueAppleResults) {
            element.shouldHave(text(brand));
        }
        return this;

    }
}
