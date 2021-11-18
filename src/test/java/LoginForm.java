import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends PageObject{

    private final String USERNAME = "standard_user";
    private final String PASSWORD = "secret_sauce";
    private final String NON_EXISTENT_USERNAME = "n_e_username";
    private final String INVALID_PASSWORD = "invalid_password";

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement login_button;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement error_button;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(){
        this.username.sendKeys(USERNAME);
    }

    public void enterPassword(){
        this.password.sendKeys(PASSWORD);
    }

    public void pressLoginButton(){
        this.login_button.click();
    }

    public void enterNonExistentUsername(){
        this.username.sendKeys(NON_EXISTENT_USERNAME);
    }

    public void enterInvalidPassword(){
        this.password.sendKeys(INVALID_PASSWORD);
    }

    public String getErrorMessage(){
        return this.error_button.getText();
    }

    public String getLoginButtonMessage(){
        return this.login_button.getAttribute("value");
    }
}