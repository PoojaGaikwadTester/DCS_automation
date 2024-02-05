package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseTest{
    private  WebDriver driver;
    Properties properties;


    public void initializeBroswer(String strBrowser){
        if (strBrowser.equalsIgnoreCase("Chrome")){
            driver=new ChromeDriver();
        } else if (strBrowser.equalsIgnoreCase("Firefox")) {
            driver=new FirefoxDriver();
        }
        setDriver(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(properties.getProperty("implicitwaitseconds"))));
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();

    }

    public Properties loadProperty(String propertyName) {
        properties= new Properties();
        try(InputStream fis= getClass().getClassLoader().getResourceAsStream(propertyName))  {
            properties.load(fis);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }
    public Properties loadproperties(String propertyFileName){
        return loadProperty(propertyFileName);
    }
    public void terminatebrowser(){
        driver.quit();
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public  WebDriver getDriver() {
        return driver;
    }

}
