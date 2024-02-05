package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class BaseTest{
    private  WebDriver driver;
   // WebDriverWait wait;
    public void initializeBroswer(String strBrowser){
        if (strBrowser.equalsIgnoreCase("Chrome")){
            driver=new ChromeDriver();
        } else if (strBrowser.equalsIgnoreCase("Firefox")) {
driver=new FirefoxDriver();
        }
        setDriver(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //  wait= new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();


    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public  WebDriver getDriver() {
        return driver;
    }

}
