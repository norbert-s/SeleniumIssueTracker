package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Prop;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver d;
//    Properties prop = new Properties();
    String driverPath;
    String url;
    Prop p;


    public WebDriverWait  wait;

    public Base() throws IOException {

    }

    public void ChromeInit() throws IOException {
        p=new Prop();
        driverPath = p.prop.getProperty("chrome");
        url = p.prop.getProperty("url");

        System.setProperty("webdriver.chrome.driver",driverPath);
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        options.addArguments("window.size=1200*600");
//        d = new ChromeDriver(options);
        d = new ChromeDriver();
        d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        d.navigate().to(url);

    }

    public WebDriverWait callWait(WebElement getJsonLocation, WebDriver d){
        wait= new WebDriverWait(d,30);
        wait.until(ExpectedConditions.visibilityOf(getJsonLocation));
        return wait;
    }

//    public void callWait(WebElement x,WebDriver d){
//
//    }


}
