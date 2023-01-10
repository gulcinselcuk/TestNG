package techproed.tests;

import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.pages.TestCenterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class TestCenterLogIn {
    @Test
    public void TestCenterLogInTest(){
        TestCenterPage testCenterPage=new TestCenterPage();
        Driver.getDriver().get(ConfigReader.getProperty("test_center_url"));
        testCenterPage.userName.sendKeys("JohnDoe");
        testCenterPage.password.sendKeys("123456");
        testCenterPage.submitButton.click();

    }

}
