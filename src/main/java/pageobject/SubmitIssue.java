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
    public WebElement jsonResult;

    public Boolean success(String value){
        String jsonText = jsonResult.getText();
        //System.out.println(jsonText);
        boolean containsSuccess=false;
        if(jsonText.contains(value)){
            containsSuccess=true;
        }
        return containsSuccess;
    }
    public Boolean fail(String value){
        String jsonText = jsonResult.getText();
        //System.out.println(jsonText);
        boolean err=false;
        if(jsonText.contains(value)){
            err=true;
        }

        return err;
    }

    public void sendValidTitle(){
        title.sendKeys(getValidTitle());
    }

    public Boolean validValuesForTheAPI_C1() throws InterruptedException {

        title.sendKeys(getValidTitle());
        text.sendKeys(getValidText());
        createdBy.sendKeys(getValidCreatedBy());
        submit.click();
        getWaits.callWait(jsonResult,d);
        return success(getSuccess());
    }
    public Boolean nonValidTitle_C2(){
        title.sendKeys(getInvalidShortTitle());
        submit.click();
        getWaits.callWait(jsonResult,d);
        return fail(getErrTitle());
    }

    public Boolean nothingIsEntered_C3() throws InterruptedException {
        submit.click();
        getWaits.callWait(jsonResult,d);
        return fail(getErrTitle());
    }

    public Boolean mandatoryFieldsAreEnteredExceptTitle_C4() throws InterruptedException {
        text.sendKeys(getValidText());
        createdBy.sendKeys(getValidCreatedBy());
        submit.click();
        getWaits.callWait(jsonResult,d);
        return fail(getErrTitle());
    }

    public void titleIsProvidedButNoTextField_C5() throws InterruptedException {
        s.getTitle().sendKeys(getValidTitle());
        s.getSubmit().click();
        base.callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTextShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
    }
//    @Test
//    public void noTextisEntered_C6() throws InterruptedException {
//        s.getTitle().sendKeys(getValidTitle());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getSubmit().click();
//        base.callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
//        boolean errOk=false;
//        if(jsonText.contains(getErrTextShort())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//    @Test
//    public void firstTwoButNotThird_C7() throws InterruptedException {
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(getValidText());
//        s.getSubmit().click();
//        base.callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
//        boolean errOk=false;
//        if(jsonText.contains(getErrCreatedByShort())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//    @Test
//    public void firstIsTwoChars_C9() throws InterruptedException {
//        s.getTitle().sendKeys(getInvalidShortTitle());
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getSubmit().click();
//        base.callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
//        boolean errOk=false;
//        if(jsonText.contains(getErrTitleShort())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//    @Test
//    public void secondIsTwoChars_C10() throws InterruptedException {
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(getInvalidShortText());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getSubmit().click();
//        base.callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//       // //System.out.println(jsonText);
//        boolean errOk=false;
//        if(jsonText.contains(getErrTextShort())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//
//    @Test
//    public void thirdIsTwoChars_C11() throws InterruptedException {
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(getInvalidShortCreatedBy());
//        s.getSubmit().click();
//        base.callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
//        boolean errOk=false;
//        if(jsonText.contains(getErrCreatedByShort())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//    @Test
//    public void FourEntered_C12() throws InterruptedException {
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getAssignedTo().sendKeys(getAssignedTo());
//        s.getSubmit().click();
//        base.callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getSuccess())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//    @Test
//    public void allFiveEntered_C14() throws InterruptedException, IOException {
//
//
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getAssignedTo().sendKeys(getAssignedTo());
//        s.getStatus().sendKeys(getStatus());
//        s.getSubmit().click();
//        base.callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getSuccess())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//
//    }
//    @Test
//    public void title256Chars_C15() throws InterruptedException, IOException {
//        String chars256 = file.createData(256,prop);
//        s.getTitle().sendKeys(chars256);
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getAssignedTo().sendKeys(getAssignedTo());
//        s.getStatus().sendKeys(getStatus());
//        s.getSubmit().click();
//        base.callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getErrTitleShort())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//    @Test
//    public void text3001Chars_C16() throws InterruptedException, IOException {
//        String data = file.createData(3001,prop);
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(data);
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getSubmit().click();
//        base.callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getErrTextShort())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//    @Test
//    public void text3000Chars_C17() throws InterruptedException, IOException {
//        String data = file.createData(3000,prop);
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(data);
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getSubmit().click();
//        base.callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getSuccess())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//    @Test
//    public void title255Chars_C18() throws InterruptedException, IOException {
//        String chars256 = file.createData(255,prop);
//        s.getTitle().sendKeys(chars256);
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getAssignedTo().sendKeys(getAssignedTo());
//        s.getStatus().sendKeys(getStatus());
//        s.getSubmit().click();
//        base.callWait(s.getJson(),d);
////        wait = callWait(s.getJson());
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getSuccess())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//    @Test
//    public void createdBy256Chars_C20() throws InterruptedException, IOException {
//        String data = file.createData(256,prop);
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(data);
//        s.getSubmit().click();
//        base.callWait(s.getJson(),d);
////        wait = callWait(s.getJson());
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getErrCreatedByShort())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//    @Test
//    public void createdBy255Chars_C21() throws InterruptedException, IOException {
//
//        file = new getData();
//        String data = file.createData(255,prop);
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(data);
//        s.getSubmit().click();
//        base.callWait(s.getJson(),d);
//
////        wait = callWait(s.getJson());
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getSuccess())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }


}
