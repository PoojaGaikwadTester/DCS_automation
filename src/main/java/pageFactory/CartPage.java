package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;

public class CartPage {
    private  WebDriver driver;
    By loc_addedproductIncart= By.xpath("//div[@class='cart_list']/div[@class='cart_item']/div[@class='cart_item_label']");//put in string and then concat
By loc_name_productDisplayed=By.xpath("//div[@class='cart_list']/div[@class='cart_item']/div[@class='cart_item_label']/a/div");
//By loc_name_productDisplayed=By.xpath(loc_addedproductIncart+"/a/div");
By loc_description=By.xpath("//div[@class='cart_list']/div[@class='cart_item']/div[@class='cart_item_label']/div[@class='inventory_item_desc']");
By loc_price=By.xpath("//div[@class='cart_list']/div[@class='cart_item']/div[@class='cart_item_label']/div[@class='item_pricebar']/div");
By loc_checkoutbtn=By.xpath("//button[@id='checkout']");
By loc_firtname=By.xpath("//form/div/child::div/input[@id='first-name']");//can makeit odula functn for form
By loc_lastname=By.xpath("//form/div/child::div/input[@id='last-name']");
By loc_zipcode=By.xpath("//form/div/child::div/input[@id='postal-code']");
By loc_continuebtn=By.xpath("//form/div//input[@id='continue']");
String strusername="abc",lastname="xyz",pincode="411555";

    public CartPage(WebDriver driver) {
        this.driver=driver;
    }

    public void verifyDetailsOfProductAdded(ProductsPage objProductsPage) throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//
//        // Wait for the element to be present in the DOM
//        WebElement productNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(loc_name_productDisplayed));
Thread.sleep(1500);
    Assert.assertEquals(driver.findElement(loc_name_productDisplayed).getText(),objProductsPage.details.get("name_SecondProduct"));//error here invocation
    Assert.assertEquals(driver.findElement(loc_description).getText(),objProductsPage.details.get("desc_SecondProduct"));
    Assert.assertEquals(driver.findElement(loc_price).getText().replace("$",""),objProductsPage.details.get("price_SecondProduct"));
    System.out.println("DetailsVerified");//step 6
}

public void checkout(ProductsPage objProductsPage){
        driver.findElement(loc_checkoutbtn).click();
        driver.findElement(loc_firtname).sendKeys(strusername);
        driver.findElement(loc_lastname).sendKeys(lastname);
        driver.findElement(loc_zipcode).sendKeys(pincode);
    objProductsPage.details.put("firstname",strusername);
    objProductsPage.details.put("lastname",lastname);
    objProductsPage.details.put("pincode",pincode);
        driver.findElement(loc_continuebtn).click();

}


}
