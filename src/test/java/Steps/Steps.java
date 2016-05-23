package Steps;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;




public class Steps {
    private WebDriver driver;
    private final String TUT = "https://tut.by";
    public void initBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    public void closeDriver()
    {
        driver.close();
    }

    public void logintut(String username, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(TUT);
        loginPage.login(username, password);
    }
    public boolean isloggedin()
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.islogin());
    }
    public void logouttut(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage(TUT);
        loginPage.logout(username,password);
    }
    public boolean isloggedout()
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.islogout());
    }

    public void searchtut(String searcword){
        Search search = new Search(driver);
        search.openPage(TUT);
        search.search(searcword);
    }
    public boolean issearched()
    {
        Search search = new Search(driver);
        return (search.issearch());
    }

    public void quiztut(){
        Quiz quiz = new Quiz(driver);
        quiz.openPage(TUT);
        quiz.quiz();
    }
    public boolean isquized()
    {
        Quiz quiz = new Quiz(driver);
        return (quiz.isquiz());
    }


    public void calctut(String summa,String publ){
        Calc calc = new Calc(driver);
        calc.openPage("http://finance.tut.by/calcs/kredit");
        calc.calc(summa,publ);
    }
    public boolean iscalc()
    {
        Calc calc = new Calc(driver);
        return (calc.iscalc());
    }

    public void recalltut(String username,String password,String text){
        Recall recall = new Recall(driver);
        recall.openPage("http://finance.tut.by/banks/alfa");
        recall.recall(username,password,text);
    }
    public boolean isrecall()
    {
        Recall recall = new Recall(driver);
        return (recall.isrecall());
    }

    public void sendnewstut(String name,String call,String email,String text) throws InterruptedException {
        SendNews sendNews = new SendNews(driver);
        sendNews.openPage("http://auto.tut.by/tell_news");
        sendNews.sendnews(name,call,email,text);
    }
    public boolean issendnews()
    {
        SendNews sendNews = new SendNews(driver);
        return (sendNews.issendnews());
    }

    public void comparisondepositstut(String sum,String USD,String payments,String year,String supplement){
        Calc comparisondeposits = new Calc(driver);
        comparisondeposits.openPage("http://finance.tut.by/calcs/sravnenie_depozitov/");
        comparisondeposits.comparisondeposits(sum,USD,payments,year,supplement);
    }
    public boolean iscomparisondeposits()
    {
        Calc comparisondeposits = new Calc(driver);
        return (comparisondeposits.iscomparisondeposits());
    }

    public void searchautotut(String mark,String model,String year){
        Search searchauto = new Search(driver);
        searchauto.openPage(TUT);
        searchauto.searchauto(mark,model,year);
    }
    public boolean issearchauto()
    {
        Search searchauto = new Search(driver);
        return (searchauto.issearchauto());
    }

    public void calcmilliontut(String sum,String USD,String year,String supplement){
        Calc calcmillion = new Calc(driver);
        calcmillion.openPage("http://finance.tut.by/calcs/stat_millionerom/");
        calcmillion.calcmillion(sum,USD,year,supplement);
    }
    public boolean iscalcmillion()
    {
        Calc calcmillion = new Calc(driver);
        return (calcmillion.iscalcmillion());
    }

}


