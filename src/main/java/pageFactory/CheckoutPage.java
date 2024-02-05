package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.Properties;

public class CheckoutPage {
    private  WebDriver driver;
    private Properties properties;
   private String xpath="//div[@class='cart_list']/div[@class='cart_item']/div[@class='cart_item_label']";

By loc_name_productDisplayed=By.xpath(xpath+"/a/div");
By loc_description=By.xpath(xpath+"/div[@class='inventory_item_desc']");
By loc_price=By.xpath(xpath+"/div[@class='item_pricebar']/div");
By loc_checkoutbtn=By.xpath("//button[@id='checkout']");
By loc_firtname=By.xpath("//form/div/child::div/input[@id='first-name']");
By loc_lastname=By.xpath("//form/div/child::div/input[@id='last-name']");
By loc_zipcode=By.xpath("//form/div/child::div/input[@id='postal-code']");
By loc_continuebtn=By.xpath("//form/div//input[@id='continue']");


    public CheckoutPage(WebDriver driver,Properties properties) {
        this.driver=driver;
        this.properties = properties;
    }

    public void verifyDetailsOfProductAdded(ProductsPage objProductsPage) throws InterruptedException {
//Thread.sleep(1500);
    Assert.assertEquals(driver.findElement(loc_name_productDisplayed).getText(),objProductsPage.details.get("name_SecondProduct"));
    Assert.assertEquals(driver.findElement(loc_description).getText(),objProductsPage.details.get("desc_SecondProduct"));
    Assert.assertEquals(driver.findElement(loc_price).getText().replace(properties.getProperty("dollar"),""),objProductsPage.details.get("price_SecondProduct"));
    System.out.println("DetailsVerified");//step 6
}

public void checkout(ProductsPage objProductsPage){
    driver.findElement(loc_checkoutbtn).click();
    driver.findElement(loc_firtname).sendKeys(properties.getProperty("firstname"));
    driver.findElement(loc_lastname).sendKeys(properties.getProperty("lastname"));
    driver.findElement(loc_zipcode).sendKeys(properties.getProperty("pincode"));
    objProductsPage.details.put("firstname",properties.getProperty("firstname"));
    objProductsPage.details.put("lastname",properties.getProperty("lastname"));
    objProductsPage.details.put("pincode",properties.getProperty("pincode"));
    driver.findElement(loc_continuebtn).click();
}




}
