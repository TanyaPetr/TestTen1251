package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Steps.Steps;

public class AutoTests {
    private Steps steps;
    private final String USERNAME = "automation_test";
    private final String PASSWORD = "automation_test1";
    private final String SEARCHWORLD = "�������";
    private final String SUMMA = "10000000";
    private final String PUBL = "12";
    private final String TEXT = "TEST NG";
    private final String CALL = "+375251111111";
    private final String EMAIL = "automation_test@tut.by";
    private final String MARK = "Nissan";
    private final String MODEL = "Teana";
    private final String YEAR = "�� 4 ���";
    private final String USD = "USD";
    private final String PAYMENTS = "��������������";
    private final String SUPPLEMENT = "1000";

    @BeforeMethod(description = "Init Browser")
    public void setup(){
        steps=new Steps();
        steps.initBrowser();
    }

    //����
    @Test(description = "Login to TUT.BY")
    public void logintut() {
        steps.logintut(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isloggedin());
    }
    //�����
    @Test(description = "LogOut to TUT.BY")
    public void logouttut(){
        steps.logouttut(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isloggedout());
    }
    //�����
    @Test(description = "Search TUT.BY")
    public void searchtut(){
        steps.searchtut(SEARCHWORLD);
        Assert.assertTrue(steps.issearched());
    }
    //�����
    @Test(description = "Quiz TUT.BY")
    public void quiztut(){
        steps.quiztut();
        Assert.assertTrue(steps.isquized());
    }

    //��������� �����������
    @Test(description = "Calc TUT.BY")
    public void calctut(){
        steps.calctut(SUMMA,PUBL);
        Assert.assertTrue(steps.iscalc());
    }

    //�����
    @Test(description = "Recall TUT.BY")
    public void recalltut(){
        steps.recalltut(USERNAME,PASSWORD,TEXT);
        Assert.assertTrue(steps.isrecall());
    }
    //��������� ������� � ��������
    @Test(description = "SendNews TUT.BY")
    public void sendnews() throws InterruptedException {
        steps.sendnewstut(USERNAME,CALL,EMAIL,TEXT);
        Assert.assertTrue(steps.issendnews());
    }
    //����� ����
    @Test(description = "SearchAuto TUT.BY")
    public void searchautotut(){
        steps.searchautotut(MARK,MODEL,YEAR);
        Assert.assertTrue(steps.issearchauto());
    }

    //��������� ���������
    @Test(description = "ComparisonDeposits TUT.BY")
    public void comparisondepositstut(){
        steps.comparisondepositstut(SUMMA,USD,PAYMENTS,PUBL,SUPPLEMENT);
        Assert.assertTrue(steps.iscomparisondeposits());
    }
    //����������� ����� � ����� �����������
    @Test(description = "CalcMillion TUT.BY")
    public void calcmilliontut(){
        steps.calcmilliontut(SUMMA,USD,PUBL,SUPPLEMENT);
        Assert.assertTrue(steps.iscalcmillion());
    }

}
