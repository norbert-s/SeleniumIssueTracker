package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import testdatamanipulation.Data;
import utility.GetWaits;
import utility.Prop;

import java.io.IOException;



public class SubmitIssue  extends Data {
    private WebDriver d;
    Prop p;
    GetWaits getWaits;



    public SubmitIssue(WebDriver d) throws IOException {
        this.d = d;
        PageFactory.initElements(d,this);
        getWaits = new GetWaits();
    }

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

    public void validValuesForTheAPI_C1() throws InterruptedException {
        title.sendKeys(getValidTitle());
        text.sendKeys(getValidText());
        createdBy.sendKeys(getValidCreatedBy());
        submit.click();
        getWaits.callWait(json,d);
        String jsonText = json.getText();
        //System.out.println(jsonText);
        boolean containsSuccess=false;
        if(jsonText.contains(getSuccess())){
            containsSuccess=true;
        }

        Assert.assertTrue(containsSuccess);
    }
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
