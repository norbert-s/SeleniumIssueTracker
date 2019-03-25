package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver d;
//    Properties prop = new Properties();

    String driverPath;

    String url;
    Properties properties;

    public WebDriverWait  wait;

    public Base(Properties prop) throws IOException {
        this.properties = prop;
    }

    public void ChromeInit() throws IOException {

        driverPath = properties.getProperty("chrome");
        url = properties.getProperty("url");

        System.setProperty("webdriver.chrome.driver",driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window.size=1200*600");
        d = new ChromeDriver(options);
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
