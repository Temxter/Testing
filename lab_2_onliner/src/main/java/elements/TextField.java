package elements;

public class TextField extends BaseElement {
    public TextField(String name, String locator) {
        super(name, locator);
    }

    public void sendKeys(String keys){
        getElement().sendKeys(keys);
    }
}
