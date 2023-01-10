package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TestCenterPage {

    public TestCenterPage(){
        //used to initiate the page objects
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //driver.findElement(By.name("username)); TRADITIONAL
    @FindBy(name="username")
    public WebElement userName;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement submitButton;
}
