package elements;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

abstract public class BaseElement {

    private String name;
    private By locator;

    public BaseElement(String name, String xpath) {
        this.name = name;
        this.locator = By.xpath(xpath);
    }

    protected WebElement getElement(){
        return Browser.getDriver().findElement(locator);
    }

    public void click(){
        getElement().click();
    }

    public String getText(){
        return getElement().getText();
    }
}
