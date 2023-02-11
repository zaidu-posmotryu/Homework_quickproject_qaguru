package test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class WbSearchPage {

    @Step("Открыть сайт")
    public WbSearchPage openWebsite() {
        open(baseUrl);
        return this;
    }

    @Step("Сделать поисковый запрос, введя {phone} в строку поиска")
    public WbSearchPage inputSearchPhone(String phone) {
        $x("//input[@id='searchInput']").click();
        $x("//input[@id='searchInput']").setValue(phone).pressEnter();
        return this;
    }

    @Step("Проверить, что все результаты поиска содержат {phone}")
    public WbSearchPage checkSearchPhone(String phone) {
        ElementsCollection results = $$x("//span[@class='goods-name']").shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : results) {
            element.shouldHave(text(phone));
        }
        return this;
    }

    @Step("Осуществить поиск, кликнув на подсказку {model} в поисковой строке")
    public WbSearchPage searchAutocompleteHintPhoneModel(String model) {
        $x("//input[@id='searchInput']").click();
        $x("//div[@class='autocomplete__scroll-container']").shouldBe(visible);
        ElementsCollection autoHints = $$x("//p[@class='autocomplete__text']").shouldHave(CollectionCondition.sizeGreaterThan(0));
        autoHints.findBy(exactText(model)).click();
        return this;
    }

    @Step("Проверить, что в блоке фильтра запроса отображается {model} и все результаты поиска содержат {brand}")
    public WbSearchPage searchFilterPhoneModelBrand(String model, String brand) {
        $x("//button[@class='dropdown-filter__btn dropdown-filter__btn--burger']").shouldHave(text(model));
        ElementsCollection appleResults = $$x("//span[@class='brand-name']").shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : appleResults) {
            element.shouldHave(text(brand));
        }
        return this;
    }

    @Step("Выбрать фильтр 'Цвет', в выпадающем списке кликнуть чекбокс 'Синий', нажать кнопку 'Готово'")
    public WbSearchPage chooseBluePhones() {
        $x("//button[contains(text(),'Цвет')]").click();
        $x("(//div[@class='dropdown-filter__content'])[5]").shouldBe(visible);
        $x("//span[contains(text(),'синий')]//span[@class='checkbox-with-text__color']").click();
        $x("//button[contains(text(),'Готово')]").shouldBe(visible).click();
        return this;
    }

    @Step("Проверить, что в блоке фильтра поиска отображается 'синий' и все результаты поиска синих телефонов содержат бренд {brand}")
    public WbSearchPage searchFilterBlueAndBrand(String brand) {
        $x("//span[@class='your-choice__btn']").shouldHave(text("синий"));
        ElementsCollection blueAppleResults = $$x("//span[@class='brand-name']").shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : blueAppleResults) {
            element.shouldHave(text(brand));
        }
        return this;

    }
}
