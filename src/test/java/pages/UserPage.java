package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserPage {
    public UserPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "user_page")
    public WebElement userPageTag;

    @FindBy(id="something")
    public WebElement subAgentsDropDown;
}
