package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.TransactionPage;
import pages.UserPage;
import utilities.Config;
import utilities.Driver;

public class UserRulesStepDefs {
    WebDriver driver;
    HomePage homePage;
    UserPage userPage;
    TransactionPage transactionPage;

    @Given("user on the homepage")
    public void user_on_the_homepage() {
        driver= Driver.getDriver();
        homePage=new HomePage();
        userPage = new UserPage();
        driver.manage().window().maximize();
        driver.get(Config.getProperties("homepageURL"));
    }

    @When("user write correct username")
    public void user_write_correct_username() {
        homePage.userName.sendKeys(Config.getProperties("validUserName"));
    }

    @When("user write correct password")
    public void user_write_correct_password() {
        homePage.password.sendKeys(Config.getProperties("validPassword"));
    }

    @When("user write correct company code")
    public void user_write_correct_company_code() {
        homePage.comCode.sendKeys("validCompanyCode");
    }

    @When("user click the button")
    public void user_click_the_button() {
        homePage.loginButton.click();
    }

    @Then("user enter the app")
    public void user_enter_the_app() {
        String actualTagName=userPage.userPageTag.getText();
        String expectedTagName=Config.getProperties("userPageTagName");
        Assert.assertEquals("User DOES NOT login correctly with him/her credentials",expectedTagName,actualTagName);
    }

    @Given("user on the user page")
    public void user_on_the_user_page() {
        driver.get(Config.getProperties("userPageURL"));
    }

    @When("user select a sub agent")
    public void user_select_a_sub_agent() {
        Select select = new Select(userPage.subAgentsDropDown);
        select.selectByIndex(1);
    }

    @Then("user should see the transaction page")
    public void user_should_see_the_transaction_page() {
        String actualTagName=transactionPage.transactionPageTag.getText();
        String expectedTagName=Config.getProperties("transactionPageTagName");
        Assert.assertEquals("User DOES NOT enter the transaction page",expectedTagName,actualTagName);

    }
}
