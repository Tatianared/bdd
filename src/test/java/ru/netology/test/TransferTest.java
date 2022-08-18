package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import

public class TransferTest {

        @BeforeEach
        void setUp() {
            open("http://localhost:9999");
        }

        @Test
        void shouldTransferFirstToSecondCard() {
            int amount = 200;
            val loginPage = new LoginPage();
            val authInfo = DataHelper.getAuthInfo();
            val verificationPage = loginPage.validLogin(authInfo);
            val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
            val dashboard = verificationPage.validVerify(verificationCode);
            val cardBalanceFirst = dashboard.getFirstCardBalance();
            val cardBalanceSecond = dashboard.getSecondCardBalance();


        }
}
