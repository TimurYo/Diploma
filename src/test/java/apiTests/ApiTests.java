package apiTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.ApiHelper;
import helpers.DataHelper;
import helpers.DbHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static helpers.DbHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTests {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Nested
    public static class ApiTestsByPay {

        @Test
        @DisplayName("Api tests with approved card by pay")
        public void apiTestWithApprovedCardByPay() {
            DbHelper.cleanDB();
            var info = DataHelper.CardInformationModel.getValidFormApprovedCard();
            var response = ApiHelper.getMethodForPayWay(info);
            assertTrue(response.contains("APPROVED"));
            var actualStatus = "APPROVED";
            var expectedStatus = getPaymentEntity().getStatus();
            assertEquals(expectedStatus, actualStatus);
            var expectedAmount = "4500000";
            var actualAmount = getPaymentEntity().getAmount();
            assertEquals(expectedAmount, actualAmount);
            var expectedId = getPaymentEntity().getTransaction_id();
            var actualId = getOrderEntity().getPayment_id();
            assertEquals(expectedId, actualId);
        }
        @Test
        @DisplayName("Api tests with declined card by pay")
        public void apiTestWithDeclinedCardByPay(){
            DbHelper.cleanDB();
            var info = DataHelper.CardInformationModel.getValidFormDeclinedCard();
            var response = ApiHelper.getMethodForPayWay(info);
            assertTrue(response.contains("DECLINED"));
            var actualStatus = "DECLINED";
            var expectedStatus = getPaymentEntity().getStatus();
            assertEquals(expectedStatus, actualStatus);
            var expectedId = getPaymentEntity().getTransaction_id();
            var actualId = getOrderEntity().getPayment_id();
            assertEquals(expectedId, actualId);
        }
    }
    @Nested
    public static class ApiTestsByCredit {
        @Test
        @DisplayName("Api tests with approved card by credit")
        public void apiTestWithApprovedCardByCredit(){
            DbHelper.cleanDB();
            var info = DataHelper.CardInformationModel.getValidFormApprovedCard();
            var response = ApiHelper.getMethodForCreditWay(info);
            assertTrue(response.contains("APPROVED"));
            var expectedStatus = "APPROVED";
            var actualStatus = getCreditEntity().getStatus() ;
            assertEquals(expectedStatus, actualStatus);
            var expectedId = getCreditEntity().getBank_id();
            var actualId = getOrderEntity().getCredit_id();
            assertEquals(expectedId, actualId);

        }
        @Test
        @DisplayName("Api tests with declined card by credit")
        public void apiTestWithDeclinedCardByCredit(){
            DbHelper.cleanDB();
            var info = DataHelper.CardInformationModel.getValidFormDeclinedCard();
            var response = ApiHelper.getMethodForCreditWay(info);
            assertTrue(response.contains("DECLINED"));
            var expectedStatus = "DECLINED";
            var actualStatus = getCreditEntity().getStatus() ;
            assertEquals(expectedStatus, actualStatus);
            var expectedId = getCreditEntity().getBank_id();
            var actualId = getOrderEntity().getCredit_id();
            assertEquals(expectedId, actualId);
        }

    }
}
