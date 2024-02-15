package UiTests;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.DataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.PaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class GeneralTests {
    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    public static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
    @Nested
    public static class GeneralTestsByPay {
        MainPage mainPage = new MainPage();
        PaymentPage paymentPage = new PaymentPage();
        @Test
        @DisplayName("Valid test with approved card by pay")
        public void validTestWithApprovedCardByPay(){
            var info = DataHelper.CardInformationModel.getValidFormApprovedCard();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeSuccessNotification();
        }
        @Test
        @DisplayName("Valid test with declined card by pay")
        public void validTestWithDeclinedCardByPay(){
            var info = DataHelper.CardInformationModel.getValidFormDeclinedCard();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeFailNotification();
        }
        @Test
        @DisplayName("Invalid test with empty form by pay")
        public void invalidTestWithEmptyFormByPay(){
            var info = DataHelper.CardInformationModel.getEmptyForm();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.numberFieldNeedToFill();
            paymentPage.monthFieldNeedToFill();
            paymentPage.yearFieldNeedToFill();
            paymentPage.nameFieldNeedToFill();
            paymentPage.cvcFieldNeedToFill();
        }
    }
    @Nested
    public static class GeneralTestsByCredit{
        MainPage mainPage = new MainPage();
        PaymentPage paymentPage = new PaymentPage();
        @Test
        @DisplayName("Valid test with approved card by credit")
        public void validTestWithApprovedCardByCredit(){
            var info = DataHelper.CardInformationModel.getValidFormApprovedCard();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeSuccessNotification();
        }
        @Test
        @DisplayName("Valid test with declined card by credit")
        public void validTestWithDeclinedCardByCredit(){
            var info = DataHelper.CardInformationModel.getValidFormDeclinedCard();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeFailNotification();
        }
        @Test
        @DisplayName("Invalid test with empty form by credit")
        public void invalidTestWithEmptyFormByCredit(){
            var info = DataHelper.CardInformationModel.getEmptyForm();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.numberFieldNeedToFill();
            paymentPage.monthFieldNeedToFill();
            paymentPage.yearFieldNeedToFill();
            paymentPage.nameFieldNeedToFill();
            paymentPage.cvcFieldNeedToFill();
        }
    }
}

