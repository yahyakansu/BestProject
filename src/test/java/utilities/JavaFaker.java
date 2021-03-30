package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaFaker {
    WebDriver driver;
//    HomePage homePage = new HomePage();
//    AccountPage accountPage = new AccountPage();
//    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();

    @BeforeTest
    public void setUp(){
        driver= Driver.getDriver();
        driver.get(Config.getProperties(Config.getProperties("dataBaseUrl")));
//        homePage.login.click();
    }

    @Test
    public void createAccount(){
//        accountPage.createAccount.click();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.bothify("?????##@gmail.com");
        String password = faker.bothify("??#??####");

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(password);

//        registerPage.firstName.sendKeys(firstName);
//        registerPage.lastName.sendKeys(lastName);
//        registerPage.email.sendKeys(email);
//        registerPage.password.sendKeys(password);
//        registerPage.submitButton.click();

//        Shane
//        Mann
//        isdfw01@gmail.com
//        wp4kt6301
    }

    @Test
    public void accountVerification(){
//        accountPage.email.sendKeys("isdfw01@gmail.com");
//        accountPage.password.sendKeys("wp4kt6301");
//        accountPage.signIn.click();

        String actualTitle = driver.getTitle();
        String expectedTitle ="Account – Uenjoy";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
