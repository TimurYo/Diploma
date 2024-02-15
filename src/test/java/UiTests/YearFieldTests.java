package UiTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.DataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.PaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class YearFieldTests {
    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    public static void tearDownAll(){
        SelenideLogger.removeListener("allure");
    }

    @Nested
    public static class YearFieldTestsByPayWay {
        MainPage mainPage = new MainPage();
        PaymentPage paymentPage = new PaymentPage();
        @Test
        @DisplayName("Year field with nulls by pay")
        public void yearWithNullsByPay() {
            var info = DataHelper.CardInformationModel.getYearWithNulls();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongCardTime();
        }
        @Test
        @DisplayName("Year field with single number by pay")
        public void yearWithSingleNumberByPay() {
            var info = DataHelper.CardInformationModel.getYearWithSingleNumber();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Year field with letters by pay")
        public void yearWithLettersByPay() {
            var info = DataHelper.CardInformationModel.getYearWithLetters();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Year field with symbols by pay")
        public void yearWithSymbolsByPay() {
            var info = DataHelper.CardInformationModel.getYearWithSymbols();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Year field with local year plus 6 years by pay")
        public void yearWithSixYearsByPay(){
            var info = DataHelper.CardInformationModel.getInvalidYearMoreFiveYearsLater();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongMonthTime();
        }
        @Test
        @DisplayName("Year field with local time plus 61 month by pay")
        public void yearWithSixtyOneMonthByPay() {
            var info = DataHelper.CardInformationModel.getInvalidYearWithMoreSixtyMonths();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongCardTime();
            paymentPage.shouldBeWrongMonthTime();
        }
        @Test
        @DisplayName("Year field with local year minus 5 years by pay")
        public void yearWithMinusFiveYearsByPay() {
            var info = DataHelper.CardInformationModel.getInvalidYearWithMinusFiveYears();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongCardTime();
        }
        @Test
        @DisplayName("Year field with local year minus 1 year by pay")
        public void yearWithMinusOneYearByPay() {
            var info = DataHelper.CardInformationModel.getInvalidYearWithMinusOneYear();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongCardTime();
        }

    }
    @Nested
    public static class YearFieldTestsByCreditWay {
        MainPage mainPage = new MainPage();
        PaymentPage paymentPage = new PaymentPage();

        @Test
        @DisplayName("Year field with nulls by credit")
        public void yearWithNullsByCredit() {
            var info = DataHelper.CardInformationModel.getYearWithNulls();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongCardTime();
        }
        @Test
        @DisplayName("Year field with single number by credit")
        public void yearWithSingleNumberByCredit() {
            var info = DataHelper.CardInformationModel.getYearWithSingleNumber();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Year field with letters by credit")
        public void yearWithLettersByCredit() {
            var info = DataHelper.CardInformationModel.getYearWithLetters();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Year field with symbols by credit")
        public void yearWithSymbolsByCredit() {
            var info = DataHelper.CardInformationModel.getYearWithSymbols();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Year field with local year plus 6 years by credit")
        public void yearWithSixYearsByCredit(){
            var info = DataHelper.CardInformationModel.getInvalidYearMoreFiveYearsLater();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongCardTime();
        }
        @Test
        @DisplayName("Year field with local time plus 61 month by credit")
        public void yearWithSixtyOneMonthByCredit() {
            var info = DataHelper.CardInformationModel.getInvalidYearWithMoreSixtyMonths();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongCardTime();
            paymentPage.shouldBeWrongMonthTime();
        }
        @Test
        @DisplayName("Year field with local year minus 5 years by credit")
        public void yearWithMinusFiveYearsByCredit() {
            var info = DataHelper.CardInformationModel.getInvalidYearWithMinusFiveYears();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongCardTime();
        }
        @Test
        @DisplayName("Year field with local year minus 1 year by credit")
        public void yearWithMinusOneYearByCredit() {
            var info = DataHelper.CardInformationModel.getInvalidYearWithMinusOneYear();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongCardTime();
        }
    }
}

