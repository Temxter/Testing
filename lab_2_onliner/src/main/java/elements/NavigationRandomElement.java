package elements;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class NavigationRandomElement {

    private String name;
    private By locator;
    private WebElement randomWebElement;

    public NavigationRandomElement(String name, String xpathElements) {
        this.name = name;
        this.locator = By.xpath(xpathElements);
        initRandomWebElement();
    }

    private boolean  initRandomWebElement(){
        try {
            randomWebElement = getRandomElement();
            return true;
        } catch (Exception e){
            System.err.println("NavigationRandomElement had not initialized WebElement");
            return false;
        }
    }

    public String getText(){
        if (randomWebElement != null || initRandomWebElement())
            return randomWebElement.getText();
        return "";
    }

    public void click(){
        if (randomWebElement != null || initRandomWebElement())
            randomWebElement.click();
    }

    private WebElement getRandomElement(){
        List<WebElement> navigationList = Browser.getDriver().findElements(locator);
        WebElement pageElement = getRandomPage(navigationList);
        return pageElement;
    }

    private WebElement getRandomPage(List<WebElement> navigationList){
        Random random = new Random();
        int pageNumber = random.nextInt(navigationList.size());
        return navigationList.get(pageNumber);
    }
}
