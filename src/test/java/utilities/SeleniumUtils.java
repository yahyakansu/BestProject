package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SeleniumUtils {

    public static List<String> getAllSelectedOptions(WebElement element){
        Select select = new Select(element);
        List<String> options = new ArrayList<>();

        for (WebElement each:select.getOptions()){
            options.add(each.getText());
        }
        return options;
    }

    public static void waitForVisibility(WebElement element,int seconds){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickable(WebElement element,int seconds){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void switchTab(String url) {
        String defaultTab=Driver.getDriver().getWindowHandle();
        for(String windowHandle:Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle);
            if(Driver.getDriver().getCurrentUrl().contains(url)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(defaultTab);
    }
}
