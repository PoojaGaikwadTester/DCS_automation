package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutCompletePage {
    private WebDriver driver;
    By loc_header=By.xpath("//h2");//.gettext
    By loc_desc=By.xpath("//h2/following::div[1]");//gettext
String headermsg="Thank you for your order!",descmsg="Your order has been dispatched, and will arrive just as fast as the pony can get there!";

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyConfirmationmsg(){
        Assert.assertEquals(driver.findElement(loc_header).getText(),headermsg);
        Assert.assertEquals(driver.findElement(loc_desc).getText(),descmsg);
        System.out.println("Verified Confirmation message");

    }
}
