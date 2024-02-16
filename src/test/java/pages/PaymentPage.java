package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class PaymentPage {
    public static SelenideElement cardNumberField = $(byText("Номер карты"));
    public static SelenideElement monthField = $(byText("Месяц"));
    public static SelenideElement yearField = $(byText("Год"));
    public static SelenideElement nameField = $(byText("Владелец"));
    public static SelenideElement cvcField = $(byText("CVC/CVV"));
    public static SelenideElement finishButton = $(byText("Продолжить"));
    public static SelenideElement successNotification = $(byText("Успешно"));
    public static SelenideElement failNotification = $(byText("Ошибка"));
    public static SelenideElement wrongFormat = $("span.input__sub");
    public static SelenideElement wrongCardTime = $("span.input__sub");
    public static SelenideElement wrongMonthTime = $("span.input__sub");
    public static SelenideElement fieldNeedToFill = $("span.input__sub");

    public static void fillForm(DataHelper.CardInformationModel info) {
        cardNumberField.parent().$("input.input__control").setValue(info.getNumber());
        monthField.parent().$("input.input__control").setValue(info.getMonth());
        yearField.parent().$("input.input__control").setValue(info.getYear());
        nameField.parent().$("input.input__control").setValue(info.getName());
        cvcField.parent().$("input.input__control").setValue(info.getCvc());
        finishButton.click();
    }
    public static void shouldBeSuccessNotification() {
        successNotification.parent().$("div.notification__content").shouldBe(Condition.visible, Duration.ofSeconds(30)).shouldHave(Condition.exactText("Операция одобрена Банком."));
    }

    public static void shouldBeFailNotification() {
        failNotification.parent().$("div.notification__content").shouldBe(Condition.visible, Duration.ofSeconds(30)).shouldHave(Condition.exactText("Ошибка! Банк отказал в проведении операции."));
    }
    public static void shouldBeWrongFormat() {
        wrongFormat.shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(Condition.exactText("Неверный формат"));
    }
    public static void shouldBeWrongCardTime() {
        wrongCardTime.shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(Condition.exactText("Истёк срок действия карты"));
    }
    public static void shouldBeWrongMonthTime() {
        wrongMonthTime.shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(Condition.exactText("Неверно указан срок действия карты"));
    }
    public static void shouldBeFieldNeedToFill() {
        fieldNeedToFill.shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }
    public static void numberFieldNeedToFill(){
        cardNumberField.parent().$("span.input__sub").shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }
    public static void monthFieldNeedToFill(){
        monthField.parent().$("span.input__sub").shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }
    public static void yearFieldNeedToFill(){
        yearField.parent().$("span.input__sub").shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }
    public static void nameFieldNeedToFill(){
        nameField.parent().$("span.input__sub").shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }
    public static void cvcFieldNeedToFill(){
        cvcField.parent().$("span.input__sub").shouldBe(Condition.visible, Duration.ofSeconds(5)).shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }
}
