package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends AbstractPage {

    public MailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/compose/']")
    private WebElement write_letter;

    @FindBy(xpath = "//div[contains(@class, 'fields_container')]//input[contains(@class, 'container')]")
    private WebElement write_to;

    @FindBy(xpath = "//div[contains(@class, 'cke_editable cke_editable_inline ')]/div[1]")
    private WebElement write_text;

    @FindBy(xpath = "//button[@data-test-id='send']")
    private WebElement send;

    public MailPage writeMail() throws InterruptedException {
        write_letter.click();
        Thread.sleep(2000);
        return this;
    }

    public MailPage writeTo() {
        write_to.sendKeys("IlinAN89@yandex.ru");
        return this;
    }

    public MailPage writeText() {
        write_text.sendKeys("Тестовое сообщение!");
        return this;
    }

    public MailPage send() throws InterruptedException {
        send.click();
        Thread.sleep(1000);
        return this;
    }
}
