package pageFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class ProductsPage {
    //Locators
    private  WebDriver driver;


By loc_productlist=By.xpath("//div[@class='inventory_item_description']");
    By loc_product1=By.xpath("//div[@class='inventory_item_description']//a[@id='item_4_title_link']/div");
    By loc_product2=By.xpath("//div[@class='inventory_item_description']//a[@id='item_0_title_link']/div");
    By loc_price_FirstProduct=By.xpath("//div[@class='inventory_item_description']//a[@id='item_4_title_link']/div/ancestor::a/parent::div/parent::div/div[@class='pricebar']/div");
    By loc_price_SecondProduct=By.xpath("//div[@class='inventory_item_description']//a[@id='item_0_title_link']/div/ancestor::a/parent::div/parent::div/div[@class='pricebar']/div");

    By loc_addFirstProduct=By.xpath("//div[@class='inventory_item_description']//a[@id='item_4_title_link']/div/ancestor::a/parent::div/parent::div/div[@class='pricebar']/button");
    By loc_addSecondProduct=By.xpath("//div[@class='inventory_item_description']//a[@id='item_0_title_link']/div/ancestor::a/parent::div/parent::div/div[@class='pricebar']/button");

    By loc_desc_FirstProduct=By.xpath("//div[@class='inventory_item_description']//a[@id='item_4_title_link']/div/parent::a/following-sibling::div");
    By loc_desc_SecondProduct=By.xpath("//div[@class='inventory_item_description']//a[@id='item_0_title_link']/div/parent::a/following-sibling::div");
    By loc_cart=By.xpath("//div[@id='shopping_cart_container']/a/span");
    By loc_cartLogo=By.xpath("//div[@id='shopping_cart_container']/a");

Map<String,String> details;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        details=new HashMap<>();

    }

    //methods regarding this page
public void addProductstoCart() throws InterruptedException {

    details.put("name_FirstProduct",driver.findElement(loc_product1).getText());
    details.put("name_SecondProduct",driver.findElement(loc_product2).getText());

   // By loc_FirstProductPrice=By.xpath("//div[@class='inventory_item_description']//a[@id='item_4_title_link']/div/ancestor::a/parent::div/parent::div/div[@class='pricebar']/div");
//    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//    WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
Thread.sleep(1000);
    String strvalue=driver.findElement(loc_price_FirstProduct).getText().replace("$","");//$29.99
    details.put("price_FirstProduct",strvalue);
    strvalue=driver.findElement(loc_price_SecondProduct).getText().replace("$","");//$29.99
    details.put("price_SecondProduct",strvalue);
    strvalue=driver.findElement(loc_desc_FirstProduct).getText();
    details.put("desc_FirstProduct",strvalue);
    strvalue=driver.findElement(loc_desc_SecondProduct).getText();
    details.put("desc_SecondProduct",strvalue);
    //click add to cart

    driver.findElement(loc_addFirstProduct).click();
    driver.findElement(loc_addSecondProduct).click();
Thread.sleep(1000);
    Assert.assertEquals("2",driver.findElement(loc_cart).getText()); //step 4
    System.out.println("addProductstoCart is success");

}


public void removingProduct(){
    driver.findElement(loc_addFirstProduct).click();
    Assert.assertEquals("1",driver.findElement(loc_cart).getText()); //step 5
    driver.findElement(loc_cartLogo).click();
    System.out.println("Verified cart number=1 After removing Product");
}

public void clickCartAfterRemovingProduct(){
    System.out.println(driver.getTitle());
    System.out.println("clicked cart after removing product");
}

}
