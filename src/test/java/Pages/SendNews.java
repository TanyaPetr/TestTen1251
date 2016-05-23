package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendNews extends AbstractPage{
    private final String BASE_URL = "http://auto.tut.by/tell_news";

    @FindBy(name = "unews_name")
    private WebElement unewsname;
    @FindBy(name = "unews_phone")
    private WebElement unewsphone;
    @FindBy(name = "unews_email")
    private WebElement unewsemail;
    @FindBy(name = "unews_body")
    private WebElement unewsbody;
    @FindBy(name = "unews_witness_name")
    private WebElement unewswitnessname;
    @FindBy(id = "sbm-button")
    private WebElement sbmbutton;
    @FindBy(css = "div.b-success")
    private WebElement b_success;

    public SendNews(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void sendnews(String name,String call,String email,String text) throws InterruptedException {
        unewsname.clear();
        unewsname.sendKeys(name);
        unewsphone.clear();
        unewsphone.sendKeys(call);
        unewsemail.clear();
        unewsemail.sendKeys(email);
        unewsbody.clear();
        unewsbody.sendKeys(text);
        unewswitnessname.clear();
        unewswitnessname.sendKeys(text);
        sbmbutton.click();
        Thread.sleep(3000);
    }

    public boolean issendnews(){
        return  b_success.isDisplayed();
    }
}