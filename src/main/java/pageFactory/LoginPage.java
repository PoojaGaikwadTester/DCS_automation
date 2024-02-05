package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class LoginPage {
    //Locators
private  WebDriver driver;
private Properties properties;


By loc_username=By.xpath("//form/div[@class='form_group']/input[@id='user-name']");//user-name
By loc_password=By.xpath("//form/div[@class='form_group']/input[@id='password']");//password
By loc_btnLogin=By.xpath("//form//input[@id='login-button']");//password

public LoginPage(WebDriver driver,Properties properties) {
    this.driver=driver;
    this.properties = properties;
}

public void login(){
    driver.findElement(loc_username).sendKeys(properties.getProperty("username"));
    driver.findElement(loc_password).clear();
    driver.findElement(loc_password).sendKeys(properties.getProperty("password"));
    driver.findElement(loc_btnLogin).click();
}
}
