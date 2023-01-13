package techproed.tests.smoketest.logintests;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day18_PositiveLoginTest {

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;

    @Test
    public void US100201_Admin_Login(){
        //going home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //click login link
        blueRentalHomePage =new BlueRentalHomePage();
        blueRentalLoginPage =new BlueRentalLoginPage();
        ReusableMethods.waitFor(3);
        blueRentalHomePage.homePageLoginLink.click();
        //sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
        blueRentalLoginPage.userName.sendKeys(" jack@gmail.com ");
        ReusableMethods.waitFor(3);
        blueRentalLoginPage.password.sendKeys("12345");
        ReusableMethods.waitFor(3);
        blueRentalLoginPage.loginButton.click();
        ReusableMethods.waitFor(3);

        //verify login successful
        ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);

        Driver.closeDriver();
    }
}
