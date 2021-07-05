package test;

import hooks.PropertyFileRead;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.MailBox;
import pages.MailRuMainPage;


public class MailTest extends TestBase {
    PropertyFileRead properties = new PropertyFileRead();
    private String login = properties.getProp("login");
    private String password = properties.getProp("password");
    private String mailTheme = properties.getProp("mailTheme");


    @Test
    public void loginIntoMailRuBoxCheckCredentialsAndSendMail() throws InterruptedException {

        mailRuMainPage = PageFactory.initElements(driver, MailRuMainPage.class);
        mailBox = PageFactory.initElements(driver, MailBox.class);

        mailRuMainPage
                .open()
                .fillInLogin(login)
                .openPasswordFieldBtnClick()
                .fillInPass(password)
                .submitBtnClick()
                .isLoginCorrect();

        mailBox
                .createNewMessage()
                .fillAddress(login + "@mail.ru")
                .fillMailTheme(mailTheme)
                .fillMessage()
                .sendMessage()
                .isSendingMessage();
    }
}
