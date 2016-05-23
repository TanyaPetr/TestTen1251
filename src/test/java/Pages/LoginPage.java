package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{
    private final String BASE_URL = "https://tut.by";

    @FindBy(linkText = "Войти")
    private WebElement enter;
    @FindBy(name = "login")
    private WebElement login;
    @FindBy(name = "password")
    private WebElement pasword;
    @FindBy(linkText = "Выйти")
    private WebElement out;
    @FindBy(css = "input.button.auth__enter")
    private WebElement signin;
    @FindBy(css = "span.uname")
    private WebElement signout;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void login(String username, String password)
    {
        enter.click();
        login.clear();
        login.sendKeys(username);
        pasword.clear();
        pasword.sendKeys(password);
        signin.click();

    }


    public void logout(String username, String password){
        enter.click();
        login.clear();
        login.sendKeys(username);
        pasword.clear();
        pasword.sendKeys(password);
        signin.click();
        signout.click();
        out.click();
    }

    public boolean islogout(){
        return  enter.isDisplayed();
    }

    public boolean islogin(){
        return  signout.isDisplayed();
    }
}