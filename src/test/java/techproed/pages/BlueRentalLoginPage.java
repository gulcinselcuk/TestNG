package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalLoginPage {

    public BlueRentalLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "email")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[.='Bad credentials']")
    public  WebElement badCredentialAlert;

    @FindBy(xpath = "(//*[@class='invalid-feedback'])[1]")
    public  WebElement invalidEmailFeedBack;
}
