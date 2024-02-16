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

    @And("User enter username on the username filed")
    public void userEnterUsernameOnTheUsernameFiled() {
        loginPage.writeOnAElement(loginPage.emailInputBox, "standard_user");
    }

    @And("User enter password on the password filed")
    public void userEnterPasswordOnThePasswordFiled() {
        loginPage.writeOnAElement(loginPage.passwordInputBox, "secret_sauce");
    }

    @When("User click on the login button")
    public void userClickOnTheLoginButton() {
        loginPage.clickOnElement(loginPage.loginButton);
    }

    @Then("User should navigate to product page")
    public void userShouldNavigateToProductPage() {
        Assert.assertEquals(getBrowser().getCurrentUrl(), productPage.productPageURL);
    }
}
