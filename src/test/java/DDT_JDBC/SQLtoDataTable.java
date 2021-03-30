package DDT_JDBC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Config;
import utilities.DBUtils;
import utilities.Driver;

import java.util.List;

public class SQLtoDataTable {
    WebDriver driver = Driver.getDriver();

    @BeforeTest
    public void setUp() {
        driver.get("https://editor.datatables.net/examples/simple/simple.html");
    }

    @Test
    public void transferData() {
        // connect to database
        DBUtils.getConnection(DBUtils.DbType.MySQl);

        // run sql query and store into a list
        List<String[]> queryResultList = DBUtils.runQuery(Config.getProperties("sampleQuery"));

        // close all connections
        DBUtils.closeConnection();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        for (int rowNum = 0; rowNum < queryResultList.size(); rowNum++) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".buttons-create")));
            driver.findElement(By.cssSelector(".buttons-create")).click();

            // get data from SQL return list
            String[] rowData = queryResultList.get(rowNum);
            String firstName = rowData[0];
            String lastName = rowData[1];
            String phoneNumber = rowData[2];


            // enter data into front end
            driver.findElement(By.id("DTE_Field_first_name")).sendKeys(firstName);
            driver.findElement(By.id("DTE_Field_last_name")).sendKeys(lastName);
            driver.findElement(By.id("DTE_Field_phoneNumber")).sendKeys(phoneNumber);


            WebElement create = driver.findElement(By.xpath("//button[.='Create']"));
            create.click();

            wait.until(ExpectedConditions.invisibilityOf(create));
        }
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
