package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quiz extends AbstractPage{
    private final String BASE_URL = "https://tut.by";
    private final String ifcontents = "голос";


    @FindBy(id = "aid14941")
    private WebElement quiz;

    @FindBy(name = "send")
    private WebElement send;

    @FindBy(css = "p.b-article-details > span")
    private WebElement quiztrue;

    public Quiz(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void quiz()
    {
        quiz.click();
        send.click();
    }
    //true если проголосовал успешно либо уже голосовал
    public boolean isquiz(){
        return  quiztrue.getText().contains(ifcontents);
    }
}
