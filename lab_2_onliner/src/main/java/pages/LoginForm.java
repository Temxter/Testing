package pages;

import elements.Button;
import elements.TextField;

public class LoginForm {

    public LoginForm() {
    }

    public void login(String login, String password){
        TextField loginTextField = new TextField("login", "//input[contains(@class, 'auth-input') and @type='text']");
        TextField passwordTextField = new TextField("password", "//input[contains(@class, 'auth-input') and @type='password']");
        Button loginButton = new Button("login button", "//button[contains(@class, 'auth-button')]");

        loginTextField.sendKeys(login);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

}
