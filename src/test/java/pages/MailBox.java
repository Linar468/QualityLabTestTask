package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailBox extends BasePage {
    @FindBy(xpath = "//span[@class='compose-button__txt']")
    WebElement newMsgButton;

    @FindBy(xpath = "//div[@class='container--ItIg4']/descendant::input")
    WebElement addressField;

    @FindBy(xpath = "//div[@class='container--3QXHv compressed--2KOQl']/descendant::input" )
    WebElement mailThemeField;

    @FindBy(xpath = "//div[@role='textbox']")
    WebElement msgField;

    @FindBy (xpath = "//div[@class='compose-app__buttons']/span[1]")
    WebElement sendMsgBtn;

    @FindBy(xpath = "//a[@class='layer__link']")
    WebElement successSendMessageLabel;

    public MailBox(WebDriver driver) {
        super(driver);
    }


    public MailBox createNewMessage() {
        click(newMsgButton);
        return this;
    }

    public MailBox fillAddress(String address) {
        writeText(addressField, address);
        return this;
    }

    public MailBox fillMailTheme(String mailTheme) {
        writeText(mailThemeField, mailTheme);
        return this;
    }

    public MailBox fillMessage() {
        String message = "Message for Quality Lab";
        writeText(msgField, message);
        return this;
    }

    public MailBox sendMessage() {
        click(sendMsgBtn);
        return this;
    }

    public MailBox isSendingMessage(){
        isElementDisplayed(successSendMessageLabel);
        return this;
    }
}
