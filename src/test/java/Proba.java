import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.SubmitIssue;
import testdatamanipulation.CreateFile;

import utility.Prop;

import java.io.IOException;

public class Proba extends Prop {
    String value,jsonText;
    boolean errOk=false;
    boolean success=false;

    public SubmitIssue s;

    private WebDriverWait wait;


    CreateFile file;
    Base base;
    WebDriver d;

    Proba() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        base = new Base(prop);
        base.ChromeInit();
        this.d = base.d;

    }
    @BeforeMethod
    public void setupMethod(){
        d.navigate().refresh();
    }

//    @Test
//    public void probe(){
//
//        titleSend(getValidTitle());
//        titleSend(getValidTitle());
//
//    }

    @Test
    public void validValuesForTheAPI_C1() throws InterruptedException {
        try {
            String line = file.createData(255,prop);
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
