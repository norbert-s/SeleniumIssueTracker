package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdatamanipulation.Data;
import utility.Prop;

import java.io.IOException;



public class SubmitIssue  extends Data {
//    public WebDriver d;
    Prop p;

    public SubmitIssue() throws IOException {
    }


//    public SubmitIssue(WebDriver d) throws IOException {
//        this.d = d;
//    }

    @FindBy(css = "form[method='post'] input[name='issue_title']")
    WebElement title;

    @FindBy(css = "form[method='post'] textarea[name='issue_text']")
    WebElement text;

    @FindBy(css = "form[method='post'] input[name='created_by']")
    WebElement createdBy;

    @FindBy(css = "form[method='post'] input[name='assigned_to']")
    WebElement assignedTo;

    @FindBy(css = "form[method='post'] input[name='status_text']")
    WebElement statusText;

    @FindBy(css = "form[method='post'] button[type='submit']")
    WebElement submit;

    @FindBy(id = "jsonResult")
    WebElement json;



    public void sendTitle(WebDriver d){
        System.out.println("valid title submit issuebol"+validTitle());
        getTitle().sendKeys(validTitle());

    }

//    public void validValuesForTheAPI_C1() throws InterruptedException {
//
//        title.sendKeys();
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getSubmit().click();
//
//        base.callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
//        boolean containsSuccess=false;
//        if(jsonText.contains(getSuccess())){
//            containsSuccess=true;
//        }
//
//        Assert.assertTrue(containsSuccess);
//    }
//
    public WebElement getTitle(){
        return title;
    }
//
//    public WebElement getText(){
//        return  text;
//
//    }
//
//    public WebElement getCreatedBy(){
//        return createdBy;
//
//    }
//
//    public WebElement getAssignedTo(){
//        return assignedTo;
//
//    }
//
//    public WebElement getStatus(){
//        return statusText;
//
//    }
//
//    public WebElement getSubmit() {
//        return submit;
//    }
//
//    public WebElement getJson(){
//       return json;
//
//    }
}
