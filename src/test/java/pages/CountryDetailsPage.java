package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CountryDetailsPage {
    String newaddress = "г. Алматы, улица Курмангазы, д. 97";
    SelenideElement
            currencyActual = $x("//span[@class='simple-menu__currency']"),
            countryLegend = $x("//legend[@class='country__title']"),
            currencyFlag = $x("//span[@class='radio-with-text__flag flag-kz']"),
            addresses = $x("//a[@data-wba-header-name='Pick_up_points']"),
            addressInput = $x("(//input[@placeholder='Введите адрес'])[1]"),
            popupList = $x("//ymaps[@class='ymaps-2-1-79-islets_serp-popup']"),
            newcity = $x("//ymaps[@class='ymaps-2-1-79-islets_serp-item__title']"),
            addressItemName = $x("//span[contains(text(),'" + newaddress + "')]"),
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
            element.shouldHave(text(value));
        }
        return this;
    }

    @Step("Проверить поиск инфо об адресе пункта выдачи")
    public CountryDetailsPage findDeliveryAddress(String city) {
        addresses.click();
        addressInput.scrollTo().setValue(city).pressEnter();
        popupList.shouldBe(visible);
        newcity.shouldHave(text((city))).click();
        sleep(4000);
        addressItemName.scrollTo().click();
        addressPopup.shouldBe(visible);
        return this;
    }
}
