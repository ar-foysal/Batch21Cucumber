package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductPage;

import static uitilities.DriverSetup.getBrowser;

public class LoginStep {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @Given("User should be on the login page")
    public void userShouldBeOnTheLoginPage() {
        getBrowser().get(loginPage.loginPageURL);
    }

    @When("User click on the login button")
    public void userClickOnTheLoginButton() {
        loginPage.clickOnElement(loginPage.loginButton);
    }

    @Then("User should navigate to product page")
    public void userShouldNavigateToProductPage() {
        Assert.assertEquals(getBrowser().getCurrentUrl(), productPage.productPageURL);
    }

    @And("User enter {string} on the username filed")
    public void userEnterOnTheUsernameFiled(String arg0) {
        loginPage.writeOnAElement(loginPage.emailInputBox, arg0);
    }

    @And("User enter {string} on the password filed")
    public void userEnterOnThePasswordFiled(String arg0) {
        loginPage.writeOnAElement(loginPage.passwordInputBox, arg0);
    }

    @Then("User should see {string} error message")
    public void userShouldSeeErrorMessage(String arg0) {
        Assert.assertTrue(loginPage.getElement(loginPage.errorMsg).isDisplayed());
        Assert.assertEquals(loginPage.getElementText(loginPage.errorMsg), arg0);
    }
}
