package UiTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.DataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.PaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class NumberFieldTests {

    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    public static void tearDownAll(){
        SelenideLogger.removeListener("allure");
    }

    @Nested
    public static class NumberFieldTestsByPayWay {
        MainPage mainPage = new MainPage();
        PaymentPage paymentPage = new PaymentPage();

        @Test
        @DisplayName("Number field with one digit by pay")
        public void numberWithSingleDigitByPay() {
            var info = DataHelper.CardInformationModel.getFormWithSingleNumber();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Number field with sixteen digits by pay")
        public void numberWithSixteenDigitsByPay() {
            var info = DataHelper.CardInformationModel.getFormWithSixteenNulls();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeFailNotification();
        }
        @Test
        @DisplayName("Number field with fourteen digits by pay")
        public void numberWithFourteenDigitsByPay() {
            var info = DataHelper.CardInformationModel.getFormWithFourteenNumber();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Number field with letters by pay")
        public void numberWithLettersByPay() {
            var info = DataHelper.CardInformationModel.getFormWithLettersIntoNumberField();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Number field with symbols by pay")
        public void numberWithSymbolsByPay(){
            var info = DataHelper.CardInformationModel.getFormWithSymbols();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
    }

    @Nested
    public static class NumberFieldTestsByCreditWay {
        MainPage mainPage = new MainPage();
        PaymentPage paymentPage = new PaymentPage();

        @Test
        @DisplayName("Number field with one digit by credit")
        public void numberWithSingleDigitByCredit() {
            var info = DataHelper.CardInformationModel.getFormWithSingleNumber();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Number field with sixteen digits by credit")
        public void numberWithSixteenDigitsByCredit() {
            var info = DataHelper.CardInformationModel.getFormWithSixteenNulls();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeFailNotification();
        }
        @Test
        @DisplayName("Number field with fourteen digits by credit")
        public void numberWithFourteenDigitsByCredit() {
            var info = DataHelper.CardInformationModel.getFormWithFourteenNumber();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Number field with letters by credit")
        public void numberWithLettersByCredit() {
            var info = DataHelper.CardInformationModel.getFormWithLettersIntoNumberField();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Number field with symbols by credit")
        public void numberWithSymbolsByCredit(){
            var info = DataHelper.CardInformationModel.getFormWithSymbols();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
    }

}

