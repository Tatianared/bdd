package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;


public class TransferPage {
    private SelenideElement amountCard = $("[data-test-id=amount] input");
    private SelenideElement from = $("[data-test-id=from] input");
    private SelenideElement sendButtton = $("[data-test-id=action-transfer]");

    public DashboardPage moneyTransfer(DataHelper.CardInfo card, int amount) {
        amountCard.setValue(String.valueOf(amount));
        from.setValue(card.getCardNumber());
        sendButtton.click();
        return new DashboardPage();
    }

    public SelenideElement errorMessageForBalance() {
        return $(withText("У вас недостаточно средств на карте")).shouldBe(visible);
    }


}
