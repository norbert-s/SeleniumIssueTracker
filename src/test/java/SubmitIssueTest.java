import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.SubmitIssue;
import testdatamanipulation.Data;
import testdatamanipulation.getData;

import utility.Prop;


import java.io.IOException;


public class SubmitIssueTest   {
    public SubmitIssue s;
    private WebDriverWait wait;
    getData file;
    Base base;
//    WebDriver d;

    SubmitIssueTest() throws IOException {

    }

    @BeforeTest
    public void setup() throws IOException {
        base = new Base();
    }
    @BeforeMethod
    public void setupMethod() throws IOException {
        base.ChromeInit();
        s = new SubmitIssue(base.d);
        file = new getData();
    }

    @Test
    public void validValuesForTheAPI_C1() throws InterruptedException {
        Assert.assertTrue(s.validValuesForTheAPI_C1());
    }

    @Test
    public void nonValidTitle_C2()  {
        Assert.assertTrue(s.nonValidTitle_C2());
    }

    @Test
    public void nothingIsEnteredToBested_C3() throws InterruptedException {
        Assert.assertTrue(s.nothingIsEntered_C3());
    }

    @Test
    public void mandatoryFieldsAreEnteredExceptTitle_C4() throws InterruptedException {
        Assert.assertTrue(s.mandatoryFieldsAreEnteredExceptTitle_C4());
    }
    @Test
    public void titleIsProvidedButNoTextField_C5() throws InterruptedException {

        Assert.assertTrue(s.titleIsProvidedButNoTextField_C5());
    }
    @Test
    public void noTextisEntered_C6() throws InterruptedException {
        Assert.assertTrue(s.noTextisEntered_C6());
    }
    @Test
    public void firstTwoButNotThird_C7() throws InterruptedException {

        Assert.assertTrue(s.firstTwoButNotThird_C7());
    }
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
//
    @AfterMethod

    public void tearDown(){
        base.d.quit();

    }
    @AfterTest
    public void tearDownAll(){
        base=null;

    }
}
