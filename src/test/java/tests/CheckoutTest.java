package tests;

import generic.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageFactory.CartPage;
import pageFactory.LoginPage;
import pageFactory.ProductsPage;

import java.util.Random;
import java.util.random.RandomGenerator;


public class CheckoutTest extends BaseTest {
   private LoginPage objLoginPage;
  private  ProductsPage objProductsPage;
  private  CartPage objCartPage;


    @BeforeClass
    public void startBrowser(){
      //  WebDriver driver = this.getDriver();
        initializeBroswer("chrome");
        objLoginPage=new LoginPage(this.getDriver());
        objProductsPage=new ProductsPage(this.getDriver());
        objCartPage=new CartPage(this.getDriver());
        objLoginPage.login();
    }
   @Test()
    public void checkoutFlow() throws InterruptedException {
       objProductsPage.addProductstoCart();
       objProductsPage.removingProduct();
       objProductsPage.clickCartAfterRemovingProduct();
       objCartPage.verifyDetailsOfProductAdded(objProductsPage);//step 6 completed

    }


//    @AfterClass
//    public void terminate(){
//
//    }
}
