package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static SelenideElement debitCardButton = $(byText("Купить"));
    public static SelenideElement creditCardButton = $(byText("Купить в кредит"));

    public static void clickDebitCard() {
        debitCardButton.click();
    }
    public static void clickCreditCard() {
        creditCardButton.click();
    }
}
