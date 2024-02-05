package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.HashMap;

public class CheckoutOverviewPage {
    private  WebDriver driver;

    By loc_addedproductIncart= By.xpath("//div[@class='cart_list']/div[@class='cart_item']/div[@class='cart_item_label']");//put in string and then concat
By loc_name_productDisplayed=By.xpath("//div[@class='cart_list']/div[@class='cart_item']/div[@class='cart_item_label']/a/div");
By loc_description=By.xpath("//div[@class='cart_list']/div[@class='cart_item']/div[@class='cart_item_label']/div[@class='inventory_item_desc']");
By loc_price=By.xpath("//div[@class='cart_list']/div[@class='cart_item']/div[@class='cart_item_label']/div[@class='item_pricebar']/div");
By loc_finishbtn=By.xpath("//button[@id='finish']");
    private  ProductsPage objProductsPage;
    HashMap<String,String> details;
    public CheckoutOverviewPage(WebDriver driver) {
        this.driver=driver;
    }

    public void verifyItem(ProductsPage objProductsPage) throws InterruptedException {

//Thread.sleep(1500);
    Assert.assertEquals(driver.findElement(loc_name_productDisplayed).getText(),objProductsPage.details.get("name_SecondProduct"));
    Assert.assertEquals(driver.findElement(loc_description).getText(),objProductsPage.details.get("desc_SecondProduct"));
    Assert.assertEquals(driver.findElement(loc_price).getText().replace("$",""),objProductsPage.details.get("price_SecondProduct"));
    driver.findElement(loc_finishbtn).click();
}








}
