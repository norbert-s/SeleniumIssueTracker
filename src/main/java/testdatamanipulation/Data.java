package testdatamanipulation;

import utility.Prop;

import java.io.*;
import java.util.*;

public class Data {
    public  Map<String,String> map = new HashMap<>();
    public Data() throws IOException {
        getDataFromExcel();
    }
    public void getDataFromExcel2() throws IOException {
        String excelPath = "D:\\Idea_Selenium\\Selenium_now\\SeleniumIssueTrackerSecond\\src\\main\\java\\sourcefiles\\data.xlsx";

        BufferedReader br = new BufferedReader(new FileReader(excelPath));
        String[] stringArray ;

        while (br.ready()) {
            String check = br.readLine();
            stringArray = check.split(";");
            System.out.println(stringArray.length);
//            map.put(stringArray[0],stringArray[1]);
//            System.out.println(stringArray[0]+stringArray[1]);
        }
        br.close();
    }
    public void getDataFromExcel() throws FileNotFoundException {
        File f = new File("D:\\Idea_Selenium\\Selenium_now\\SeleniumIssueTrackerSecond\\src\\main\\java\\sourcefiles\\data.csv");
        Scanner scanner = new Scanner (f,"ISO-8859-2");
        String[] stringArray ;

        while (scanner.hasNextLine()) {
            String check = scanner.nextLine();
            stringArray = check.split(";");
            map.put(stringArray[0],stringArray[1]);
            System.out.println(stringArray[0]+stringArray[1]);
        }
        scanner.close();

    }


    public  String getIt(String v){
        return  map.get(v);
    }
    public  String validTitle() {
        return getIt("validTitle");
    }

//    public String getValidText() {
//        return prop.getProperty("validText");
//    }
//
//    public String getValidCreatedBy() {
//        return prop.getProperty("validCreatedBy");
//    }
//
//    public String getAssignedTo(){
//        return prop.getProperty("assignedTo");
//    }
//
//    public String getStatus(){
//        return prop.getProperty("status");
//    }
//
//    public String getInvalidShortTitle() {
//        return prop.getProperty("invalidShortTitle");
//    }
//
//    public String getInvalidShortText() {
//        return prop.getProperty("invalidShortText");
//    }
//
//    public String getInvalidShortCreatedBy() {
//        return prop.getProperty("invalidShortCreatedBy");
//    }
//
//    public String getUpdateErrId(){
//        return prop.getProperty("errIdShort");
//    }
//
//    public String getErrTitleShort(){
//        return prop.getProperty("errTitleShort");
//    }
//
//    public String getErrTextShort(){
//        return prop.getProperty("errTextShort");
//    }
//
//    public String getErrCreatedByShort(){
//        return prop.getProperty("errCreatedByShort");
//    }
//
//    public String getErrDeleteId(){
//        return prop.getProperty("errDeleteId");
//    }
//
//    public String getSuccess(){
//        return prop.getProperty("success");
//    }
//
//    public String getSuccessUpdate(){
//        return prop.getProperty("successUpdate");
//    }
//
//    public void getTxtLocation(){
//        txtLocation= prop.getProperty("txtLocation");
//    }
//
//    public String getErrWhenDbEmptyAndStatusActive(){
//        return prop.getProperty("QueryStatusActiveWhenDbIsEmpty");
//    }
//    public String getAssignedTo2(){
//        return prop.getProperty("assignedTo2");
//    }
//    public String getInvalidAssignedTo(){
//        return prop.getProperty("invalidAssignedTo");
//    }
//
//    public String getInvalidStatusText(){
//        return prop.getProperty("invalidStatus");
//    }
}
