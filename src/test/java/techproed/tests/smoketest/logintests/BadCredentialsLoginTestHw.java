package techproed.tests.smoketest.logintests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class BadCredentialsLoginTestHw {
    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;

    /*
    Name:
Login screen error messages
Description:
User should see error message when user tries to login with incorrect credentials
Acceptance Criteria:
As admin or customer, I should be able to see error message,
when I provide a correct email address BUT incorrect password in a pop up window
Error Message: Bad credentials
     */

    @Test
    public void badCredentialTest() {
        //going home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //click login link
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        ReusableMethods.waitFor(3);
        blueRentalHomePage.homePageLoginLink.click();
        //sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
        blueRentalLoginPage.userName.sendKeys(" jack@gmail.com ");
        ReusableMethods.waitFor(3);
        blueRentalLoginPage.password.sendKeys("123456");
        ReusableMethods.waitFor(3);
        blueRentalLoginPage.loginButton.click();
        ReusableMethods.waitFor(3);

        //verify login successful
        ReusableMethods.verifyElementDisplayed(blueRentalLoginPage.badCredentialAlert);


        //ReusableMethods.verifyElementDisplayed(homePage.userID);

    }
    @Test
    public void invalidEmailTest() {
        //going home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //click login link
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        ReusableMethods.waitFor(3);
        blueRentalHomePage.homePageLoginLink.click();
        //sending credentials and clicking on login button
        ReusableMethods.waitFor(3);

        Faker faker= new Faker();
        blueRentalLoginPage.userName.sendKeys(faker.name().firstName());
        ReusableMethods.waitFor(3);
        //verify invalid email feedback
        ReusableMethods.verifyElementDisplayed(blueRentalLoginPage.invalidEmailFeedBack);

    }
    @Test
            public void validEmailTest(){
        //going home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //click login link
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        ReusableMethods.waitFor(3);
        blueRentalHomePage.homePageLoginLink.click();
        //sending credentials and clicking on login button
        ReusableMethods.waitFor(3);

        Faker faker=new Faker();

        blueRentalLoginPage.userName.sendKeys(faker.internet().emailAddress());
        ReusableMethods.waitFor(3);
        ReusableMethods.verifyElementNotDisplayed(blueRentalLoginPage.invalidEmailFeedBack);



        Driver.closeDriver();
    }


}
