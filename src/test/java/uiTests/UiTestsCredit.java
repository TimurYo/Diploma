package uiTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UiTestsCredit {
    @BeforeAll
    static void setUpAll() {

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {

        SelenideLogger.removeListener("allure");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/ValidApprovedCard.csv")
    public void validTestsWithApprovedCard(String cardNumber, String month, String year, String name, String cvc, String cssText, String cssSelector, String resultText) {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить в кредит")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue(cardNumber);
        $(byText("Месяц")).parent().$("input.input__control").setValue(month);
        $(byText("Год")).parent().$("input.input__control").setValue(year);
        $(byText("Владелец")).parent().$("input.input__control").setValue(name);
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue(cvc);
        $(byText("Продолжить")).click();
        $(byText(cssText)).parent().$(cssSelector).shouldBe(Condition.visible, Duration.ofSeconds(30)).shouldHave(Condition.exactText(resultText));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/ValidDeclinedCard.csv")
    public void validTestsWithDeclinedCard(String cardNumber, String month, String year, String name, String cvc, String cssText, String cssSelector, String resultText) {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить в кредит")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue(cardNumber);
        $(byText("Месяц")).parent().$("input.input__control").setValue(month);
        $(byText("Год")).parent().$("input.input__control").setValue(year);
        $(byText("Владелец")).parent().$("input.input__control").setValue(name);
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue(cvc);
        $(byText("Продолжить")).click();
        $(byText(cssText)).parent().$(cssSelector).shouldBe(Condition.visible, Duration.ofSeconds(30)).shouldHave(Condition.exactText(resultText));
    }

    @Test
    public void emptyCardNumberField() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить в кредит")).click();
        $(byText("Месяц")).parent().$("input.input__control").setValue("12");
        $(byText("Год")).parent().$("input.input__control").setValue("25");
        $(byText("Владелец")).parent().$("input.input__control").setValue("Dmitry Ivanov");
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue("335");
        $(byText("Продолжить")).click();
        $(byText("Номер карты")).parent().$("span.input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void emptyMonthField() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить в кредит")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue("4444444444444441");
        $(byText("Год")).parent().$("input.input__control").setValue("25");
        $(byText("Владелец")).parent().$("input.input__control").setValue("Dmitry Ivanov");
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue("335");
        $(byText("Продолжить")).click();
        $(byText("Месяц")).parent().$("span.input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void emptyYearField() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить в кредит")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue("4444444444444441");
        $(byText("Месяц")).parent().$("input.input__control").setValue("12");
        $(byText("Владелец")).parent().$("input.input__control").setValue("Dmitry Ivanov");
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue("335");
        $(byText("Продолжить")).click();
        $(byText("Год")).parent().$("span.input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void emptyNameField() {
        open("http://localhost:8080/");
        $(byText("Купить в кредит")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue("4444444444444441");
        $(byText("Месяц")).parent().$("input.input__control").setValue("12");
        $(byText("Год")).parent().$("input.input__control").setValue("23");
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue("335");
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent().$("span.input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void emptyCVCField() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить в кредит")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue("4444444444444441");
        $(byText("Месяц")).parent().$("input.input__control").setValue("12");
        $(byText("Год")).parent().$("input.input__control").setValue("23");
        $(byText("Владелец")).parent().$("input.input__control").setValue("Dmitry Ivanov");
        $(byText("Продолжить")).click();
        $(byText("CVC/CVV")).parent().$("span.input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/InvalidCardNumber.csv")
    public void invalidCardNumberTest(String cardNumber) {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить в кредит")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue(cardNumber);
        $(byText("Месяц")).parent().$("input.input__control").setValue("12");
        $(byText("Год")).parent().$("input.input__control").setValue("25");
        $(byText("Владелец")).parent().$("input.input__control").setValue("Dmitry Ivanov");
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue("335");
        $(byText("Продолжить")).click();
        $(byText("Номер карты")).parent().$("span.input__sub").shouldHave(Condition.exactText("Неверный формат"));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/InvalidMonth.csv")
    public void invalidMonthTest(String month, String exactText) {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить в кредит")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue("4444444444444441");
        $(byText("Месяц")).parent().$("input.input__control").setValue(month);
        $(byText("Год")).parent().$("input.input__control").setValue("25");
        $(byText("Владелец")).parent().$("input.input__control").setValue("Dmitry Ivanov");
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue("335");
        $(byText("Продолжить")).click();
        $(byText("Месяц")).parent().$("span.input__sub").shouldHave(Condition.exactText(exactText));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/InvalidYear.csv")
    public void invalidYearTest(String year, String exactText) {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить в кредит")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue("4444444444444441");
        $(byText("Месяц")).parent().$("input.input__control").setValue("12");
        $(byText("Год")).parent().$("input.input__control").setValue(year);
        $(byText("Владелец")).parent().$("input.input__control").setValue("Dmitry Ivanov");
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue("335");
        $(byText("Продолжить")).click();
        $(byText("Год")).parent().$("span.input__sub").shouldHave(Condition.exactText(exactText));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/InvalidCVC.csv")
    public void invalidCvcTest(String cvc) {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить в кредит")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue("4444444444444441");
        $(byText("Месяц")).parent().$("input.input__control").setValue("12");
        $(byText("Год")).parent().$("input.input__control").setValue("23");
        $(byText("Владелец")).parent().$("input.input__control").setValue("Dmitry Ivanov");
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue(cvc);
        $(byText("Продолжить")).click();
        $(byText("CVC/CVV")).parent().$("span.input__sub").shouldHave(Condition.exactText("Неверный формат"));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/InvalidName.csv")
    public void invalidNameTest(String name) {
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить в кредит")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue("4444444444444441");
        $(byText("Месяц")).parent().$("input.input__control").setValue("12");
        $(byText("Год")).parent().$("input.input__control").setValue("23");
        $(byText("Владелец")).parent().$("input.input__control").setValue(name);
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue("999");
        $(byText("Продолжить")).click();
        $(byText("Владелец")).parent().$("span.input__sub").shouldHave(Condition.exactText("Неверный формат"));
    }
}
