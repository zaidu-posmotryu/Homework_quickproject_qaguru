package test.java;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class PageWildBerries {

    @Step("Открыть сайт")
    public PageWildBerries openWebsite() {
        open(baseUrl);
        return this;
    }

    @Step("Сделать поисковый запрос, введя {phone} в строку поиска")
    public PageWildBerries inputSearchPhone(String phone) {
        $x("//input[@id='searchInput']").click();
        $x("//input[@id='searchInput']").setValue(phone).pressEnter();
        return this;
    }

    @Step("Проверить, что все результаты поиска содержат {phone}")
    public PageWildBerries checkSearchPhone(String phone) {
        ElementsCollection results = $$x("//span[@class='goods-name']").shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : results) {
            element.shouldHave(text(phone));
        }
        return this;
    }

    @Step("Осуществить поиск, кликнув на подсказку {model} в поисковой строке")
    public PageWildBerries searchAutocompleteHintPhoneModel(String model) {
        $x("//input[@id='searchInput']").click();
        $x("//div[@class='autocomplete__scroll-container']").shouldBe(visible);
        ElementsCollection autohints = $$x("//p[@class='autocomplete__text']").shouldHave(CollectionCondition.sizeGreaterThan(0));
        autohints.findBy(exactText(model)).click();
        return this;
    }

    @Step("Проверить, что в блоке фильтра запроса отображается {model} и все результаты поиска содержат {brand}")
    public PageWildBerries searchFilterPhoneModelBrand(String model, String brand) {
        $x("//button[@class='dropdown-filter__btn dropdown-filter__btn--burger']").shouldHave(text(model));
        ElementsCollection appleresults = $$x("//span[@class='brand-name']").shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : appleresults) {
            element.shouldHave(text(brand));
        }
        return this;
    }

    @Step("Выбрать фильтр 'Цвет', в выпадающем списке кликнуть чекбокс 'Синий', нажать кнопку 'Готово'")
    public PageWildBerries chooseBluePhones() {
        $x("//button[contains(text(),'Цвет')]").click();
        $x("(//div[@class='dropdown-filter__content'])[5]").shouldBe(visible);
        $x("//span[contains(text(),'синий')]//span[@class='checkbox-with-text__color']").click();
        $x("//button[contains(text(),'Готово')]").shouldBe(visible).click();
        return this;
    }

    @Step("Проверить, что в блоке фильтра поиска отображается 'синий' и все результаты поиска синих телефонов содержат бренд {brand}")
    public PageWildBerries searchFilterBlueAndBrand(String brand) {
        $x("//span[@class='your-choice__btn']").shouldHave(text("синий"));
        ElementsCollection blueappleresults = $$x("//span[@class='brand-name']").shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : blueappleresults) {
            element.shouldHave(text(brand));
        }
        return this;

    }
}
