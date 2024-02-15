package UiTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.DataHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.PaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class NameFieldTests {
    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterAll
    public static void tearDownAll(){
        SelenideLogger.removeListener("allure");
    }

    @Nested
    public static class NameFieldTestsByPay {
        MainPage mainPage = new MainPage();
        PaymentPage paymentPage = new PaymentPage();
        @Test
        @DisplayName("Name field with letters and numbers by pay")
        public void nameWithLettersAndNumbersByPay() {
            var info = DataHelper.CardInformationModel.getNameWithBothify();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Name field with letters and symbols by pay")
        public void nameWithLettersAndSymbolsByPay() {
            var info = DataHelper.CardInformationModel.getNameWithLettersAndSymbols();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Name with symbols by pay")
        public void nameWithSymbolsByPay(){
            var info = DataHelper.CardInformationModel.getNameWithSymbols();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Japanese name by pay")
        public void nameWithJapaneseNameByPay(){
            var info = DataHelper.CardInformationModel.getJapaneseName();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Russian name by pay")
        public void nameWithRussianNameByPay() {
            var info = DataHelper.CardInformationModel.getRussianName();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Name field with one letter by pay")
        public void nameWithOneLetterByPay() {
            var info = DataHelper.CardInformationModel.getNameWithSingleLetter();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Name field with 254 letters by pay")
        public void nameWith254LettersByPay() {
            var info = DataHelper.CardInformationModel.getNameWith254Letters();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Name field with numbers by pay")
        public void nameWithNumbersByPay(){
            var info = DataHelper.CardInformationModel.getNameWithNumbers();
            open("http://localhost:8080/");

            mainPage.clickDebitCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
    }
    @Nested
    public static class NameFieldTestsByCredit {
        MainPage mainPage = new MainPage();
        PaymentPage paymentPage = new PaymentPage();
        @Test
        @DisplayName("Name field with letters and numbers by credit")
        public void nameWithLettersAndNumbersByCredit() {
            var info = DataHelper.CardInformationModel.getNameWithBothify();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Name field with letters and symbols by credit")
        public void nameWithLettersAndSymbolsByCredit() {
            var info = DataHelper.CardInformationModel.getNameWithLettersAndSymbols();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Name with symbols by credit")
        public void nameWithSymbolsByCredit(){
            var info = DataHelper.CardInformationModel.getNameWithSymbols();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Japanese name by credit")
        public void nameWithJapaneseNameByCredit(){
            var info = DataHelper.CardInformationModel.getJapaneseName();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Russian name by credit")
        public void nameWithRussianNameByCredit() {
            var info = DataHelper.CardInformationModel.getRussianName();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Name field with one letter by credit")
        public void nameWithOneLetterByCredit() {
            var info = DataHelper.CardInformationModel.getNameWithSingleLetter();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Name field with 254 letters by credit")
        public void nameWith254LettersByCredit() {
            var info = DataHelper.CardInformationModel.getNameWith254Letters();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
        @Test
        @DisplayName("Name field with numbers by credit")
        public void nameWithNumbersByCredit(){
            var info = DataHelper.CardInformationModel.getNameWithNumbers();
            open("http://localhost:8080/");

            mainPage.clickCreditCard();
            paymentPage.fillForm(info);
            paymentPage.shouldBeWrongFormat();
        }
    }
}
