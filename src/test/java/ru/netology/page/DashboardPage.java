package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    private SelenideElement heading = $("[data-test-id=dashboard]");

    public static SelenideElement idFirst = $("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
    public static SelenideElement idSecond = $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");
    private SelenideElement buttonTransferToFirst = $("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"] [type=button]");
    private SelenideElement buttonTransferToSecond = $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"] [type=button]");

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public TransferPage firstCardButton() {
        buttonTransferToFirst.click();
        return new TransferPage();
    }

    public TransferPage secondCardButton() {
        buttonTransferToSecond.click();
        return new TransferPage();
    }

    public int getFirstCardBalance() {
        String valueFirst = idFirst.getText();
        return extractBalance(valueFirst);
    }

    public int getSecondCardBalance() {
        String valueSecond = idSecond.getText();
        return extractBalance(valueSecond);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }


}