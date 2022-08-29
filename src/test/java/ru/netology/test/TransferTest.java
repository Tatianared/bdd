package ru.netology.test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataHelper.getFirstCardInfo;
import static ru.netology.data.DataHelper.getSecondCardInfo;


public class TransferTest {


    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldTransferFirstToSecondCard() {
        int amount = 200;
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var firstCardInfo = getFirstCardInfo();
       // var secondCardInfo = getSecondCardInfo();
        var expectedBalanceFirstCard = dashboardPage.getFirstCardBalance() - amount;
        var expectedBalanceSecondCard = dashboardPage.getSecondCardBalance() + amount;
        var transferPage = dashboardPage.secondCardButton();
        dashboardPage = transferPage.moneyTransfer(firstCardInfo, amount);
        assertEquals(expectedBalanceFirstCard, dashboardPage.getFirstCardBalance());
        assertEquals(expectedBalanceSecondCard, dashboardPage.getSecondCardBalance());
    }

    @Test
    void shouldTransferSecondToFirstCard() {
        int amount = 500;
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var firstCardInfo = getFirstCardInfo();
        var secondCardInfo = getSecondCardInfo();
        var expectedBalanceFirstCard = dashboardPage.getFirstCardBalance() + amount;
        var expectedBalanceSecondCard = dashboardPage.getSecondCardBalance() - amount;
        var transferPage = dashboardPage.firstCardButton();
        dashboardPage = transferPage.moneyTransfer(secondCardInfo, amount);
        assertEquals(expectedBalanceFirstCard, dashboardPage.getFirstCardBalance());
        assertEquals(expectedBalanceSecondCard, dashboardPage.getSecondCardBalance());
    }

    @Test
    void shouldTransferFirstToSecondCardMoreSum() {
        int amount = 20000;
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var firstCardInfo = getFirstCardInfo();
        // var secondCardInfo = getSecondCardInfo();
        var expectedBalanceFirstCard = dashboardPage.getFirstCardBalance() - amount;
        var expectedBalanceSecondCard = dashboardPage.getSecondCardBalance() + amount;
        var transferPage = dashboardPage.secondCardButton();
        dashboardPage = transferPage.moneyTransfer(firstCardInfo, amount);
        assertEquals(expectedBalanceFirstCard, dashboardPage.getFirstCardBalance());
        assertEquals(expectedBalanceSecondCard, dashboardPage.getSecondCardBalance());
    }
}
