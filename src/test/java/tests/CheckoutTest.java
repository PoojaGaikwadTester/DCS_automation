package tests;

import generic.BaseTest;
import org.testng.annotations.*;
import pageFactory.*;
import pageFactory.CheckoutPage;


public class CheckoutTest extends BaseTest {
   private LoginPage objLoginPage;
  private  ProductsPage objProductsPage;
  private CheckoutPage objCheckoutPage;
private  CheckoutCompletePage objCheckoutCompletePage;
private CheckoutOverviewPage objCheckoutOverviewPage;

    @BeforeClass
    public void startBrowser(){
      //  WebDriver driver = this.getDriver();
        initializeBroswer("chrome");
        objLoginPage=new LoginPage(this.getDriver());
        objProductsPage=new ProductsPage(this.getDriver());
        objCheckoutPage=new CheckoutPage(this.getDriver());
        objCheckoutCompletePage=new CheckoutCompletePage(getDriver());
        objCheckoutOverviewPage=new CheckoutOverviewPage(getDriver());
        objLoginPage.login();

    }
   @Test()
    public void checkoutFlow() throws InterruptedException {
       objProductsPage.addProductstoCart();
       objProductsPage.removingProduct();
       objProductsPage.clickCartAfterRemovingProduct();
       objCheckoutPage.verifyDetailsOfProductAdded(objProductsPage);//step 6
       objCheckoutPage.checkout(objProductsPage);
       objCheckoutOverviewPage.verifyItem(objProductsPage);
       objCheckoutCompletePage.verifyConfirmationmsg();//step 8
    }



//    @AfterClass
//    public void terminate(){
//
//    }
}
