package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "something")
    public WebElement userName;

    @FindBy(css = "something")
    public WebElement password;

    @FindBy(className = "something")
    public WebElement comCode;

    @FindBy(id = "something")
    public WebElement loginButton;

}
