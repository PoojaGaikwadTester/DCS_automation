package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //Locators
    private  WebDriver driver;


By loc_username=By.xpath("//form/div[@class='form_group']/input[@id='user-name']");//user-name
By loc_password=By.xpath("//form/div[@class='form_group']/input[@id='password']");//password
By loc_btnLogin=By.xpath("//form//input[@id='login-button']");//password
    String username="standard_user";//later take from properties
    String password="secret_sauce";

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    //methods regarding this page
public void login(){
    driver.findElement(loc_username).sendKeys(username);
    driver.findElement(loc_password).clear();
    driver.findElement(loc_password).sendKeys(password);
    driver.findElement(loc_btnLogin).click();
}
}
