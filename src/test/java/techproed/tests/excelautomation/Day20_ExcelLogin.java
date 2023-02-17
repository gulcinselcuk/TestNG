package techproed.tests.excelautomation;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class Day20_ExcelLogin {

    BlueRentalHomePage homePage;
    BlueRentalLoginPage loginPage;
    ExcelUtils excelUtils;
    //will store excel data
    List<Map<String,String>> allTestData;


    //create a login method
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        homePage=new BlueRentalHomePage();
        loginPage=new BlueRentalLoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();
        ReusableMethods.waitFor(3);


        //I am on the login page
        //send username
        //send password
        //click on login link
        //I am on the home page
        //********************
        //click on userId
        //click on logout
        //click on ok
        //I am on home page again
        //********************

    }
    @Test
    public void customerLoginTest(){
        String path="./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName="customer_info";
        excelUtils=new ExcelUtils(path,sheetName);
        //getDataList() returns all excel data we stored that data in allTestData variable
        allTestData=excelUtils.getDataList();
//        System.out.println(allTestData);
//        System.out.println(excelUtils.getColumnsNames());
//        System.out.println(excelUtils.getCellData(2,1));
        //using loop get the values from the map and send in the ui
        for (Map<String,String > eachData:allTestData){
            //takes us to the login page
            login();
            loginPage.userName.sendKeys(eachData.get("username"));
            ReusableMethods.waitFor(1);
            loginPage.password.sendKeys("password");
            ReusableMethods.waitFor(1);
            loginPage.loginButton.click();
            ReusableMethods.waitFor(1);
            //verify if login is successful

        }



    }
}
