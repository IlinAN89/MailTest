import Pages.AuthPage;
import Pages.MailPage;
import Utils.MyScreenshots;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AuthAndMailPagesTest extends AbstractTest {

    private void saveScreen(String name) throws IOException {
        File file = MyScreenshots.makeScreenshot(getDriver(), name + " " + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Test
    public void sendMailTest() throws InterruptedException, IOException {
        AuthPage authPage = new AuthPage(getDriver());
        MailPage mailPage = new MailPage(getDriver());
        authPage.auth().inputUsername().password().inputPassword().login();
        saveScreen("Авторизация на почте Mail.ru");
        Assertions.assertTrue(getDriver().getCurrentUrl().contains(authUrl));
        mailPage.writeMail().writeTo().writeText().send();
        saveScreen("Отправка письма на адрес");
    }
}

