package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Search extends AbstractPage{
    private final String BASE_URL = "https://tut.by";

    @FindBy(id = "search_from_str")
    private WebElement searchfromstr;
    @FindBy(id = "search_5")
    private WebElement search5;
    @FindBy(name = "search")
    private WebElement search;
    @FindBy(name = "venders[0]")
    private WebElement venders;
    @FindBy(name = "models[0]")
    private WebElement models;
    @FindBy(name = "age_from[0]")
    private WebElement age_from;
    @FindBy(linkText = "Nissan Teana")
    private WebElement modelauto;
    @FindBy(xpath = "(//a[contains(text(),'Характеристики')])[2]")
    private WebElement chapt;
    @FindBy(css = "div.b-search-note")
    private WebElement search_note;
    @FindBy(css = "input.search_auto__btn")
    private WebElement search_auto_btn;

    public Search(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void search(String searcworld)
    {
        searchfromstr.clear();
        searchfromstr.sendKeys(searcworld);
        search.click();
        search5.click();
    }

    public boolean issearch(){

        return  search_note.isDisplayed();
    }

    public void searchauto(String mark,String model,String year)
    {
        venders.click();
        new Select(venders).selectByVisibleText(mark);
        new Select(models).selectByVisibleText(model);
        new Select(age_from).selectByVisibleText(year);
        search_auto_btn.click();
        modelauto.click();

    }

    public boolean issearchauto(){
        return  chapt.isDisplayed();
    }
}