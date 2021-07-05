package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.MailBox;
import pages.MailRuMainPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    public MailRuMainPage mailRuMainPage;
    public MailBox mailBox;


    @BeforeTest
    public void start() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        options.addArguments("--test-type");
        ChromeDriverService chromeDriverService = ChromeDriverService.createDefaultService();
        driver = new ChromeDriver(chromeDriverService, options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void finish() {
        if (driver != null)
            driver.quit();
    }
}