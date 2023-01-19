package techproed.tests.reservationtests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Day19_ReservationTest {

    BlueRentalHomePage blueRentalHomePage=new BlueRentalHomePage();
    Faker faker;
    BlueRentalLoginPage blueRentalLoginPage=new BlueRentalLoginPage();

    @Test
    public void reservationTest() {
//    Given user is on the home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //LOGIN THE APP
        ReusableMethods.waitFor(3);
        blueRentalHomePage.homePageLoginLink.click();
        //sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
        blueRentalLoginPage.userName.sendKeys("jack@gmail.com");
        ReusableMethods.waitFor(3);
        blueRentalLoginPage.password.sendKeys("12345");
        ReusableMethods.waitFor(3);
        blueRentalLoginPage.loginButton.click();
        ReusableMethods.waitFor(3);

        //verify login successful
        ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);

        //NOW that u logged in the application, we can enter the required fields

//    And select a car
        Select carSelect= new Select(blueRentalHomePage.selectACar);
        carSelect.selectByIndex(3);

//    And enter pick up field
        faker=new Faker();
        blueRentalHomePage.pickUpLocation.sendKeys(Faker.instance(Locale.US).address().cityName());

//    And enter drop off field
        blueRentalHomePage.dropOfLocation.sendKeys(Faker.instance(Locale.US).address().cityName());

        //Pick up Date

        //Pick Up Time

        //DropOf Date

        //DropOf Time

        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("hhmmaa");
        Calendar calendar=Calendar.getInstance();

        //enter pick up date
        blueRentalHomePage.pickUpDate.sendKeys("10/10/2023");

        //enter pick up hour
        blueRentalHomePage.pickUpTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));

        //enter drop of date
        blueRentalHomePage.dropOffDate.sendKeys("12/11/2023");

        //enter drop of hour
        blueRentalHomePage.dropOffTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));


 //=====================================================

//    And click continue reservation
        blueRentalHomePage.continueReservationButton.click();


        //CAR IS  NOT RESERVED There is a BLOCKER.....


//    And verify complete reservation screen pops up
//    And enter card number
//    And enter name on the card
//    And enter expire date and CVC
//    And checks the agreement
//    And click complete reservation
//    Then verify ‘Reservation created successfully’ pop up
//    And naviaged to Reservations screen
//    And verify the last reservation is created
//    When you click on the last reservation
//    Then verify reservation detail page is displayed
//    And verify the table has the following fields: Model, Doors, Seats, Luggage, Transmission, Air Conditioning, Fuel Type, Age
//    And click on back to reservations
//    And verify Reservations page is displayed
//    And click on Home link
//    Then verify the home page is displayed
    }
}
