package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.Properties;

public class CheckoutCompletePage {
    private WebDriver driver;
    private Properties properties;
    By loc_header=By.xpath("//h2");
    By loc_desc=By.xpath("//h2/following::div[@class='complete-text']");

    public CheckoutCompletePage(WebDriver driver,Properties properties) {
        this.driver = driver;
        this.properties = properties;
    }

    public void verifyConfirmationmsg(){
        Assert.assertEquals(driver.findElement(loc_header).getText(),properties.getProperty("headermsg"));
        Assert.assertEquals(driver.findElement(loc_desc).getText(),properties.getProperty("descmsg"));
        System.out.println("Verified Confirmation message");

    }
}
