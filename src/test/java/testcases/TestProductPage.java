package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import uitilities.DriverSetup;

public class TestProductPage extends DriverSetup {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    @Test
    public void testProductDetails(){
        loginPage.doLogin("standard_user", "secret_sauce");
        productPage.clickOnElement(productPage.bikeLight);
        Assert.assertEquals(productPage.getElementText(productPage.productTitle), "Sauce Labs Bike Light");
    }

    @Test
    public void testAddCart(){
        loginPage.doLogin("standard_user", "secret_sauce");
        productPage.clickOnElement(productPage.bikeLight);
        productPage.clickOnElement(productPage.addToChatButton);
        Assert.assertTrue(productPage.getElement(productPage.removeButton).isDisplayed());
        Assert.assertEquals(productPage.getElementText(productPage.cartCount), "1");
    }

}
