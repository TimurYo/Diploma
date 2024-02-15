package UiTests;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.DataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.PaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class MonthFieldTests {
    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    public static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Nested
    public static class MonthFieldTestsByPayWay {
        MainPage mainPage = new MainPage();
        PaymentPage paymentPage = new PaymentPage();

        @Test
        @DisplayName("Month field with one digit by pay")
        public void monthWithNullByDebit() {
            var info = DataHelper.CardInformationModel.getMonthWithNulls();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongMonthTime();
        }

        @Test
        @DisplayName("Month field with one digit by pay")
        public void monthWithSingleDigitByDebit() {

            var info = DataHelper.CardInformationModel.getMonthWithSingleNumber();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Month field with letters by pay")
        public void monthWithLettersByDebit() {
            var info = DataHelper.CardInformationModel.getMonthWithLetters();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Month field with symbols by pay")
        public void monthWithSymbolsByDebit() {
            var info = DataHelper.CardInformationModel.getMonthWithSymbols();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Month field with invalid numbers by pay")
        public void monthWithInvalidNumbersByDebit() {
            var info = DataHelper.CardInformationModel.getMonthWithInvalidNumber();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Month field with invalid month by pay")
        public void monthWithInvalidMonthByDebit() {
            var info = DataHelper.CardInformationModel.getInvalidMonthMinus();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongMonthTime();
        }
        @Test
        @DisplayName("Month field with plus ine month by pay")
        public void monthWithValidPlusMonthByPay() {
            var info = DataHelper.CardInformationModel.getValidMonthPlus();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeSuccessNotification();
        }
    }
    @Nested
    public static class MonthFieldTestsByCreditWay {
        MainPage mainPage = new MainPage();
        PaymentPage paymentPage = new PaymentPage();
        @Test
        @DisplayName("Month field with one digit by credit")
        public void monthWithNullByCredit() {
            var info = DataHelper.CardInformationModel.getMonthWithNulls();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongMonthTime();
        }

        @Test
        @DisplayName("Month field with one digit by credit")
        public void monthWithSingleDigitByCredit() {

            var info = DataHelper.CardInformationModel.getMonthWithSingleNumber();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Month field with letters by credit")
        public void monthWithLettersByCredit() {
            var info = DataHelper.CardInformationModel.getMonthWithLetters();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Month field with symbols by credit")
        public void monthWithSymbolsByCredit() {
            var info = DataHelper.CardInformationModel.getMonthWithSymbols();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Month field with invalid numbers by credit")
        public void monthWithInvalidNumbersByCredit() {
            var info = DataHelper.CardInformationModel.getMonthWithInvalidNumber();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Month field with invalid month by credit")
        public void monthWithInvalidMonthByCredit() {
            var info = DataHelper.CardInformationModel.getInvalidMonthMinus();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongMonthTime();
        }
        @Test
        @DisplayName("Month field with plus ine month by credit")
        public void monthWithValidPlusMonthByCredit() {
            var info = DataHelper.CardInformationModel.getValidMonthPlus();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeSuccessNotification();
        }
    }
}
