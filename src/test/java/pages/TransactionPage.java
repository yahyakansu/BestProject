package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TransactionPage {
    public TransactionPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "transaction_page")
    public WebElement transactionPageTag;

}
