package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement amountCard = $("[data-test-id=amount] input");
    private SelenideElement from = $("[data-test-id=from] input");
    private SelenideElement sendButtton = $("[data-test-id=action-transfer]");

    public DashboardPage moneyTransfer(DataHelper.CardInfo card, int amount) {
        amountCard.setValue(String.valueOf(amount));
        from.setValue(card.getCardNumber());
        sendButtton.click();
        return null;
    }
}
