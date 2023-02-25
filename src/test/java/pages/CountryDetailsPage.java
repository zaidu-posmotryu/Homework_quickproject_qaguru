package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryDetailsPage {
    SelenideElement
    currencyActual = $x("//span[@class='simple-menu__currency']"),
    countryLegend = $x("//legend[@class='country__title']"),
    currencyFlag = $x("//span[@class='radio-with-text__flag flag-kz']"),
    addresses = $x("//a[@data-wba-header-name='Pick_up_points']"),
    addressInput = $x("(//input[@placeholder='Введите адрес'])[1]");

    ElementsCollection
    resultsNewCurr = $$x("//div[@class='product-card__price price j-cataloger-price']");

    @Step("Проверить смену валюты")
    public CountryDetailsPage changeCurrency() {
        currencyActual.hover();
        countryLegend.shouldBe(Condition.visible);
        currencyFlag.click();
        resultsNewCurr.shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : resultsNewCurr) {
            element.shouldHave(text("тг.")); }
        return this;
    }

    @Step("Проверить смену адреса пункта выдачи")
    public CountryDetailsPage changeDeliveryAddress() {
        addresses.click();
        addressInput.setValue("Алматы").click();
        return this;
    }


}
