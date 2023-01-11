package techproed.tests.smoketest.logintests;

import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day18_PositiveLoginTest {

    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void US100201_Admin_Login(){
        //going home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //click login link
        homePage=new HomePage();
        loginPage=new LoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();
        //sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
        loginPage.userName.sendKeys(" jack@gmail.com ");
        ReusableMethods.waitFor(3);
        loginPage.password.sendKeys("12345");
        ReusableMethods.waitFor(3);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);

        //verify login successful
        ReusableMethods.verifyElementDisplayed(homePage.userID);
    }
}
