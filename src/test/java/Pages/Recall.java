package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recall extends AbstractPage{
    private final String BASE_URL = "http://finance.tut.by/banks/alfa";
    private final String contentcomments = "Комментарий получен, он отобразится после проверки модератором";


    @FindBy(linkText = "Вход")
    private WebElement enter;
    @FindBy(name = "comment")
    private WebElement comment;
    @FindBy(css = "div.b-success")
    private WebElement commentistrue;

    @FindBy(css = "div.i-holder > input[name=\"login\"]")
    private WebElement login;
    @FindBy(css = "div.i-holder > input[name=\"password\"]")
    private WebElement pass;
    @FindBy(css = "div.b-auth-f > form.b-auth-content > div.b-hold > input.button")
    private WebElement but_1;
    @FindBy(css = "#main_controls > input.button")
    private WebElement inbut;

    public Recall(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void recall(String username,String password,String text)
    {
        enter.click();
        login.clear();
        login.sendKeys(username);
        pass.clear();
        pass.sendKeys(password);
        but_1.click();
        comment.clear();
        comment.sendKeys(text);
        inbut.click();
    }

    public boolean isrecall(){
        return commentistrue.getText().contains(contentcomments);
    }
}