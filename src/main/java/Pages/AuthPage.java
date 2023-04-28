package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage extends AbstractPage {
    public AuthPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//button[contains(@class, 'ph-login')]")
    private WebElement button_auth;

    @FindBy (xpath = "//input[@name='username']")
    private WebElement input_username;

    @FindBy (xpath = "//button[@data-test-id='next-button']")
    private WebElement button_password;

    @FindBy (xpath = "//input[@name='password']")
    private WebElement input_password;

    @FindBy (xpath = "//button[@data-test-id='submit-button']")
    private WebElement button_login;

    @FindBy (css = "iframe[class='ag-popup__frame__layout__iframe']")
    private WebElement iframe;

    public AuthPage auth() throws InterruptedException {
        button_auth.click();
        Thread.sleep(5000);
        getDriver().switchTo().frame(iframe);
        return this;
    }
    public AuthPage inputUsername() {
        input_username.sendKeys("antontest2023@mail.ru");
        return this;
    }

    public AuthPage password() throws InterruptedException {
        button_password.click();
        Thread.sleep(2000);
        return this;
    }

    public AuthPage inputPassword(){
        input_password.sendKeys("Test_1989");
        return this;
    }

    public AuthPage login() throws InterruptedException {
        button_login.click();
        Thread.sleep(4000);
        return this;
    }
}
