package pages;

import hooks.PropertyFileRead;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailRuMainPage extends BasePage {

    @FindBy(xpath = "//input[@name='login']")
    WebElement loginField;

    @FindBy(xpath = "//button[@data-testid='enter-password']")
    WebElement openPasswordFieldButton;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;


    @FindBy(xpath = "//button[@data-testid='login-to-mail']")
    WebElement submitBtn;

    @FindBy(xpath = "//div[@id='sideBarContent']/descendant::a[1]")
    WebElement incomingMailsBtn;
    //span[@class='compose-button__wrapper']/ancestor::a

    String SITE_URL = new PropertyFileRead().getProp("URL");


    public MailRuMainPage(WebDriver driver) {
        super(driver);
    }

    public MailRuMainPage open() {
        SITE_URL = new PropertyFileRead().getProp("URL");
        driver.get(SITE_URL);
        return this;

    }

    public MailRuMainPage fillInLogin(String login){
        writeText(loginField, login);
        return this;
    }

    public MailRuMainPage openPasswordFieldBtnClick(){
        click(openPasswordFieldButton);
        return this;
    }

    public MailRuMainPage fillInPass(String pass){
        writeText(passwordField, pass);
        return this;
    }

    public MailRuMainPage submitBtnClick(){
        click(submitBtn);
        return this;
    }

    public MailRuMainPage isLoginCorrect() {
        isElementDisplayed(incomingMailsBtn);
        return this;
    }
}
