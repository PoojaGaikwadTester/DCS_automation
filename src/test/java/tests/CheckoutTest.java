package tests;

import generic.BaseTest;
import org.testng.annotations.*;
import pageFactory.*;
import pageFactory.CheckoutPage;
import java.util.Properties;


public class CheckoutTest extends BaseTest {
private LoginPage objLoginPage;
private  ProductsPage objProductsPage;
private CheckoutPage objCheckoutPage;
private  CheckoutCompletePage objCheckoutCompletePage;
private CheckoutOverviewPage objCheckoutOverviewPage;
private Properties properties;


    @BeforeClass
    public void startBrowser(){
        properties=loadproperties("property.properties");
        initializeBroswer(properties.getProperty("browsertoopen"));
        objLoginPage=new LoginPage(this.getDriver(),properties);
        objProductsPage=new ProductsPage(this.getDriver(),properties);
        objCheckoutPage=new CheckoutPage(this.getDriver(),properties);
        objCheckoutCompletePage=new CheckoutCompletePage(getDriver(),properties);
        objCheckoutOverviewPage=new CheckoutOverviewPage(getDriver(),properties);
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

    @AfterClass
    public void terminate(){
        terminatebrowser();
    }
}
