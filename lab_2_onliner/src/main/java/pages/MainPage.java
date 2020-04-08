package pages;

import elements.*;


import java.util.logging.Level;
import java.util.logging.Logger;

public class MainPage {

    Logger logger = Logger.getLogger(getClass().getSimpleName());

    public void clickLogIn(){
        Button loginButton = new Button("Login button on main page", "//div[@class='auth-bar__item auth-bar__item--text']");
        loginButton.click();
    }

    public boolean navigateToPage(){
        Background backgroundLoginPage = new Background("Login page background", "//div[contains(@class, 'auth-entry')]");
        backgroundLoginPage.waitForInvisibility(20);

        NavigationRandomElement randomElement = new NavigationRandomElement("Navigation panel", "//li[contains(@class,'project-navigation__item')]//a");

        String nameOnPane = randomElement.getText();

        logger.log(Level.INFO, String.format("nameOnPane = %s", nameOnPane));

        randomElement.click();

        Text titleText = new Text("Title of page", "//h1[contains(@class, 'schema-header__title')]");
        String nameOnTitle = titleText.getText();

        return nameOnPane.equals(nameOnTitle);
    }

    public void returnToMainPage(){
        Picture onlinerLogo = new Picture("Onliner logo", "//img[contains(@class, 'onliner_logo')]");
        onlinerLogo.click();
    }



}
