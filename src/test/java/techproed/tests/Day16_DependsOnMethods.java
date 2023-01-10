package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day16_DependsOnMethods {
    @Test
    public void homePage(){
        System.out.println("I am on the home page");
    }
    @Test(dependsOnMethods = "homePage")
    public void searchPage(){
        System.out.println("I am on the search page");
        Assert.assertTrue(false);
    }

    /*
    dependsOnMethods = "searchPage" ->connecting checkOutPage to searchPage
    searchPage will execute right before checkOutPage
    if searchPage pass->execute checkoutPage
    if searchPage fail->SKIP checkoutPage

     */
    @Test(dependsOnMethods = "searchPage")
    public void checkOutPage(){
        System.out.println("I am on the checkout page");
    }
}
