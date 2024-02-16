
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.DataHelper;
import helpers.DbHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.PaymentPage;

import java.text.ParseException;

import static com.codeborne.selenide.Selenide.open;
import static helpers.DbHelper.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DbTimeTest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
    MainPage mainPage = new MainPage();
    PaymentPage paymentPage = new PaymentPage();

    @Test
    @DisplayName("Time created test by credit")
    void creditTimeCreatedTest() throws ParseException {
        cleanDB();
        var info = DataHelper.CardInformationModel.getValidFormApprovedCard();
        open("http://localhost:8080/");

        mainPage.clickCreditCard();
        paymentPage.fillForm(info);
        paymentPage.shouldBeSuccessNotification();

        long duration = getDurationOfTimeForCreditEntity();

        assertTrue(duration <= 3000);
    }
    @Test
    @DisplayName("Time created test by pay")
    void paymentTimeCreatedTest() throws ParseException {
        cleanDB();
        var info = DataHelper.CardInformationModel.getValidFormApprovedCard();
        open("http://localhost:8080/");

        mainPage.clickDebitCard();
        paymentPage.fillForm(info);
        paymentPage.shouldBeSuccessNotification();

        long duration = getDurationOfTimeForPaymentEntity();
        assertTrue(duration <= 3000);
    }
    @Test
    @DisplayName("Time created test by pay into order entity")
    void orderTimeCreatedTestByPay() throws ParseException {
        cleanDB();
        open("http://localhost:8080/");
        var info = DataHelper.CardInformationModel.getValidFormApprovedCard();
        open("http://localhost:8080/");

        mainPage.clickDebitCard();
        paymentPage.fillForm(info);
        paymentPage.shouldBeSuccessNotification();

        long duration = getDurationOfTimeForOrderEntity();
        assertTrue(duration <= 3000);
    }

    @Test
    @DisplayName("Time created test by credit into credit entity")
    void orderTimeCreatedTestByCredit() throws ParseException {
        cleanDB();
        open("http://localhost:8080/");

        var info = DataHelper.CardInformationModel.getValidFormApprovedCard();
        open("http://localhost:8080/");

        mainPage.clickDebitCard();
        paymentPage.fillForm(info);
        paymentPage.shouldBeSuccessNotification();

        long duration = getDurationOfTimeForOrderEntity();
        assertTrue(duration <= 3000);
    }
}
