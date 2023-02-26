package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryDetailsPage {
    SelenideElement
    currencyActual = $x("//span[@class='simple-menu__currency']"),
    countryLegend = $x("//legend[@class='country__title']"),
    currencyFlag = $x("//span[@class='radio-with-text__flag flag-kz']"),
    addresses = $x("//a[@data-wba-header-name='Pick_up_points']"),
    addressInput = $x("(//input[@placeholder='Введите адрес'])[1]"),
    popupList = $x("//ymaps[@class='ymaps-2-1-79-islets_serp-popup']"),
    newcity = $x("//ymaps[@class='ymaps-2-1-79-islets_serp-item__title']"),
    addressItemName = $x("//div[@class='address-item__name']"),
    addressPopup = $x("//ymaps[@class='ymaps-2-1-79-balloon__content']");

    ElementsCollection
    resultsNewCurr = $$x("//div[@class='product-card__price price j-cataloger-price']");

    @Step("Проверить смену валюты")
    public CountryDetailsPage changeCurrency(String value) {
        currencyActual.hover();
        countryLegend.shouldBe(Condition.visible);
        currencyFlag.click();
        resultsNewCurr.shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement element : resultsNewCurr) {
            element.shouldHave(text(value)); }
        return this;
    }

    @Step("Проверить смену адреса пункта выдачи")
    public CountryDetailsPage findDeliveryAddress(String city, String newaddress) {
        addresses.click();
        addressInput.setValue(city).click();
        popupList.shouldBe(visible);
        newcity.find(new ByText(city)).click();
        addressItemName.find(new ByText(newaddress)).click();
        addressPopup.shouldBe(visible);
        return this;
    }


}
