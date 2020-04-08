import driver.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginForm;
import pages.MainPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class OnlinerTest {

    private String login;
    private String password;

    @BeforeMethod
    public void setUp() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/test_settings.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String browser = properties.getProperty("browser"); //Chrome, Firefox, IE
        login = properties.getProperty("login");
        password = properties.getProperty("password");

        Browser.setBrowser(Browser.Driver.valueOf(browser));

        WebDriver driver = Browser.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.onliner.by/");
    }


    @Test
    public void onlinerTest(){
        MainPage mainPage = new MainPage();

        mainPage.clickLogIn();

        LoginForm loginForm = new LoginForm();

        loginForm.login(login, password);

        mainPage.navigateToPage();

        mainPage.returnToMainPage();
    }
}
