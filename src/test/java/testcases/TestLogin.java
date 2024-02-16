package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import uitilities.DataSet;
import uitilities.DriverSetup;

public class TestLogin extends DriverSetup {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    @Test(description = "Test with valid user credentials")
    public void testLoginWithValidCredentials(){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.writeOnAElement(loginPage.emailInputBox, "standard_user");
        loginPage.writeOnAElement(loginPage.passwordInputBox, "secret_sauce");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertEquals(getBrowser().getCurrentUrl(), productPage.productPageURL);
    }

    @Test
    public void testLoginWithInvalidPassword(){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.writeOnAElement(loginPage.emailInputBox, "standard_user");
        loginPage.writeOnAElement(loginPage.passwordInputBox, "secret_");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMsg).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), "Epic sadface: Username and password do not match any user in this service");
    }


    @Test
    public void testLoginWithInvalidUsername(){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.writeOnAElement(loginPage.emailInputBox, "standard_");
        loginPage.writeOnAElement(loginPage.passwordInputBox, "secret_sauce");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMsg).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void testLoginWithInvalidUsernamePassword(){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.writeOnAElement(loginPage.emailInputBox, "standard_");
        loginPage.writeOnAElement(loginPage.passwordInputBox, "secret_s");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMsg).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void testLoginWithoutPassword(){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.writeOnAElement(loginPage.emailInputBox, "standard_user");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMsg).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), "Epic sadface: Password is required");
    }

    @Test
    public void testLoginWithoutUsername(){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.writeOnAElement(loginPage.emailInputBox, "");
        loginPage.writeOnAElement(loginPage.passwordInputBox, "secret_sauce");
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMsg).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), "Epic sadface: Username is required");
    }

    @Test
    public void testLoginWithoutUsernamePassword(){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMsg).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), "Epic sadface: Username is required");
    }


    @Test(dataProvider = "invalidUserData", dataProviderClass = DataSet.class)
    public void testLoginWithInvalidCredentials(String username, String password, String errorMsg){
        getBrowser().get(loginPage.loginPageURL);
        loginPage.writeOnAElement(loginPage.emailInputBox, username);
        loginPage.writeOnAElement(loginPage.passwordInputBox, password);
        loginPage.clickOnElement(loginPage.loginButton);
        Assert.assertTrue(loginPage.getElement(loginPage.errorMsg).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), errorMsg);
    }


}
