import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginForm;
import pages.MainPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class main {
    static public void main(String[] args) throws Exception {

    }

    static void testProperties() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/test_settings.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        System.out.println(properties.getProperty("login"));
        System.out.println(properties.getProperty("password"));
        System.out.println(properties.getProperty("browser"));
    }

    static void testSelenium(){
        Browser.setBrowser(Browser.Driver.Chrome);
        WebDriver driver = Browser.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.onliner.by/");

        MainPage mainPage = new MainPage();

        mainPage.clickLogIn();

        String login = "";
        String password = "";

        LoginForm loginForm = new LoginForm();

        loginForm.login(login, password);

//        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 10);

        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 20); //here, wait time is 20 seconds
        WebElement backgroundLogin = Browser.getDriver().findElement(By.xpath("//div[contains(@class, 'auth-entry')]"));
        wait.until(ExpectedConditions.invisibilityOf(backgroundLogin)); //this will wait for element to be visible for 20 seconds

        List<WebElement> navigationList = Browser.getDriver().findElements(By.xpath("//li[contains(@class,'project-navigation__item')]//a"));
        System.out.println("navigationList.size(): " + navigationList.size());



        for (WebElement webElement : navigationList){
            System.out.println("webElement : " + " | " + webElement.getText() + " | " + webElement.getTagName());
        }
    }
}
