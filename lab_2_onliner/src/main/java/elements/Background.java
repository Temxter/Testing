package elements;

import driver.Browser;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Background extends BaseElement {
    public Background(String name, String locator) {
        super(name, locator);
    }

    public void waitForInvisibility(int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), timeOutInSeconds); //here, wait time is 'time'
        wait.until(ExpectedConditions.invisibilityOf(getElement())); //this will wait for element to be visible for 20 seconds
    }
}
