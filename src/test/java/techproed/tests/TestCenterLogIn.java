package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.pages.TestCenterPage;
import techproed.pages.TestHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class TestCenterLogIn {
    @Test
    public void TestCenterLogInTest(){
        TestCenterPage testCenterPage=new TestCenterPage();
        TestHomePage testHomePage = new TestHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("test_center_url"));
        testCenterPage.userName.sendKeys("techproed");
        testCenterPage.password.sendKeys("SuperSecretPassword");
        testCenterPage.submitButton.click();

        //        verifying login is successful
        Assert.assertTrue(testHomePage.loginMessage.isDisplayed());



    }

}
