package UiTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.DataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.PaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class CvcFieldTests {
    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    public static void tearDownAll(){
        SelenideLogger.removeListener("allure");
    }

    @Nested
    public static class CvcTestsByPay{
        MainPage mainPage = new MainPage();
        PaymentPage paymentPage = new PaymentPage();
        @Test
        @DisplayName("Cvc field with one number by pay")
        public void cvcWithOneNumberByPay(){
            var info = DataHelper.CardInformationModel.getCvcWithSingleNumber();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Cvc field with double number by pay")
        public void cvcWithDoubleNumbersByPay(){
            var info = DataHelper.CardInformationModel.getCvcWithDoubleNumber();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Cvc field with triple nulls by pay")
        public void cvcWithTripleNullsByPay() {
            var info = DataHelper.CardInformationModel.getCvcWithTripleNull();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Cvc field with letters by pay")
        public void cvcWithLettersByPay(){
            var info = DataHelper.CardInformationModel.getCvcWithLetters();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Cvc field with symbols by pay")
        public void cvcWithSymbolsByPay() {
            var info = DataHelper.CardInformationModel.getCvcWithSymbols();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
    }
    @Nested
    public static class CvcTestsByCredit{
        MainPage mainPage = new MainPage();
        PaymentPage paymentPage = new PaymentPage();
        @Test
        @DisplayName("Cvc field with one number by credit")
        public void cvcWithOneNumberByCredit(){
            var info = DataHelper.CardInformationModel.getCvcWithSingleNumber();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Cvc field with double number by credit")
        public void cvcWithDoubleNumbersByCredit(){
            var info = DataHelper.CardInformationModel.getCvcWithDoubleNumber();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Cvc field with triple nulls by credit")
        public void cvcWithTripleNullsByCredit() {
            var info = DataHelper.CardInformationModel.getCvcWithTripleNull();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Cvc field with letters by credit")
        public void cvcWithLettersByCredit(){
            var info = DataHelper.CardInformationModel.getCvcWithLetters();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Cvc field with symbols by credit")
        public void cvcWithSymbolsByCredit() {
            var info = DataHelper.CardInformationModel.getCvcWithSymbols();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
    }
}
