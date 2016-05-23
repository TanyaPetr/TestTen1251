package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Calc extends AbstractPage{
    private final String BASE_URL = "http://finance.tut.by/calcs/kredit";
    private final String everymounthpayment = "≈жемес€чный платеж:";
    private final String procent = "12";

    @FindBy(name = "summa_cred")
    private WebElement summacred;
    @FindBy(name = "srok")
    private WebElement time;
    @FindBy(name = "proc")
    private WebElement percent;
    @FindBy(id = "recalc")
    private WebElement recalc;
    @FindBy(id = "calc_result")
    private WebElement calcresult;

    @FindBy(id = "pi1")
    private WebElement pi1;
    @FindBy(id = "pi")
    private WebElement pi;
    @FindBy(name = "summa_cred1")
    private WebElement summa_cred1;
    @FindBy(name = "valuta1")
    private WebElement valuta1;
    @FindBy(name = "valuta")
    private WebElement valuta;
    @FindBy(name = "summa")
    private WebElement summa;
    @FindBy(name = "summa_first")
    private WebElement summa_first;
    @FindBy(name = "summa_dop")
    private WebElement summa_dop;
    @FindBy(name = "type_proc1")
    private WebElement type_proc1;
    @FindBy(name = "srok1")
    private WebElement srok1;
    @FindBy(name = "proc1")
    private WebElement proc1;
    @FindBy(name = "sum_dop1")
    private WebElement sum_dop1;
    @FindBy(css = "td.calc-fbt-left")
    private WebElement css_1;


    public Calc(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void calc(String summa,String publ)
    {
        summacred.click();
        summacred.clear();
        summacred.sendKeys(summa);
        time.click();
        time.clear();
        time.sendKeys(publ);
        percent.clear();
        percent.sendKeys(publ);
        recalc.click();
    }

    public boolean iscalc(){
        return calcresult.getText().contains(everymounthpayment);
    }


    public void comparisondeposits(String sum,String USD,String payments,String year,String supplement)
    {
        summa_cred1.clear();
        summa_cred1.sendKeys(sum);
        new Select(valuta1).selectByVisibleText(USD);
        new Select(type_proc1).selectByVisibleText(payments);
        pi1.clear();
        pi1.sendKeys(procent);
        srok1.clear();
        srok1.sendKeys(year);
        proc1.clear();
        proc1.sendKeys(year);
        sum_dop1.clear();
        sum_dop1.sendKeys(supplement);
        recalc.click();
    }

    public boolean iscomparisondeposits(){
        return  css_1.isDisplayed();
    }


    public void calcmillion(String sum,String USD,String year,String supplement)
    {

        new Select(valuta).selectByVisibleText(USD);
        summa.clear();
        summa.sendKeys(sum);
        summa_first.clear();
        summa_first.sendKeys(supplement);
        summa_dop.clear();
        summa_dop.sendKeys(year);
        percent.clear();
        percent.sendKeys(year);
        pi.clear();
        pi.sendKeys(year);
        recalc.click();


    }

    public boolean iscalcmillion(){
        return  calcresult.isDisplayed();
    }
}