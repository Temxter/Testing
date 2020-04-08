package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
    private static WebDriver driver = null;
    private static Driver driverType;

    public enum Driver{
        Chrome, Firefox, IE
    }

    private Browser(){
    }

    public static void setBrowser(Driver browser){
        driverType = browser;
    }

    public static WebDriver getDriver(){
        switch (driverType){
            case Firefox:
                if (driver == null) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
            break;
            case IE:
                if (driver == null) {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                }

                break;
            default:
                if (driver == null) {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
        }

        return driver;
    }
}
