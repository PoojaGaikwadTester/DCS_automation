package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.Properties;

public class CheckoutOverviewPage {
    private  WebDriver driver;
    private Properties properties;
    private String xpath="//div[@class='cart_list']/div[@class='cart_item']/div[@class='cart_item_label']";

By loc_name_productDisplayed=By.xpath(xpath+"/a/div");
By loc_description=By.xpath(xpath+"/div[@class='inventory_item_desc']");
By loc_price=By.xpath(xpath+"/div[@class='item_pricebar']/div");
By loc_finishbtn=By.xpath("//button[@id='finish']");

    public CheckoutOverviewPage(WebDriver driver,Properties properties) {
        this.driver=driver;
        this.properties = properties;
    }

    public void verifyItem(ProductsPage objProductsPage){
    Assert.assertEquals(driver.findElement(loc_name_productDisplayed).getText(),objProductsPage.details.get("name_SecondProduct"));
    Assert.assertEquals(driver.findElement(loc_description).getText(),objProductsPage.details.get("desc_SecondProduct"));
    Assert.assertEquals(driver.findElement(loc_price).getText().replace(properties.getProperty("dollar"), ""),objProductsPage.details.get("price_SecondProduct"));
    driver.findElement(loc_finishbtn).click();
}








}
