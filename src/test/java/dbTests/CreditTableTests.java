package dbTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.SQLHelper.cleanDB;
import static helpers.SQLHelper.getCreditEntity;
import static helpers.TimeHelper.getDurationOfTimeForCreditEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditTableTests {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void creditTimeCreatedTest() throws ParseException {
        cleanDB();
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить в кредит")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue("4444444444444441");
        $(byText("Месяц")).parent().$("input.input__control").setValue("12");
        $(byText("Год")).parent().$("input.input__control").setValue("25");
        $(byText("Владелец")).parent().$("input.input__control").setValue("Timur");
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue("335");
        $(byText("Продолжить")).click();
        $(byText("Успешно")).parent().$("div.notification__content").shouldBe(Condition.visible, Duration.ofSeconds(30)).shouldHave(Condition.exactText("Операция одобрена Банком."));

        long duration = getDurationOfTimeForCreditEntity();

        assertTrue(duration <= 3000);
    }

    @Test
    void creditStatusTestWithApprovedCard() {
        cleanDB();
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить в кредит")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue("4444444444444441");
        $(byText("Месяц")).parent().$("input.input__control").setValue("12");
        $(byText("Год")).parent().$("input.input__control").setValue("25");
        $(byText("Владелец")).parent().$("input.input__control").setValue("Timur");
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue("335");
        $(byText("Продолжить")).click();
        $(byText("Успешно")).parent().$("div.notification__content").shouldBe(Condition.visible, Duration.ofSeconds(30)).shouldHave(Condition.exactText("Операция одобрена Банком."));
        var expectedStatus = "APPROVED";
        var actualStatus = getCreditEntity().getStatus();
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    void creditStatusTestWithDeclinedCard() {
        cleanDB();
        //Configuration.holdBrowserOpen = true;
        open("http://localhost:8080/");
        $(byText("Купить в кредит")).click();
        $(byText("Номер карты")).parent().$("input.input__control").setValue("4444444444444442");
        $(byText("Месяц")).parent().$("input.input__control").setValue("12");
        $(byText("Год")).parent().$("input.input__control").setValue("25");
        $(byText("Владелец")).parent().$("input.input__control").setValue("Timur");
        $(byText("CVC/CVV")).parent().$("input.input__control").setValue("335");
        $(byText("Продолжить")).click();
        $(byText("Успешно")).parent().$("div.notification__content").shouldBe(Condition.visible, Duration.ofSeconds(30)).shouldHave(Condition.exactText("Операция одобрена Банком."));
        var expectedStatus = "DECLINED";
        var actualStatus = getCreditEntity().getStatus();
        assertEquals(expectedStatus, actualStatus);
    }

}
