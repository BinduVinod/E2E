package Model;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public  static Properties prop;

    public static  WebDriver getDriver() throws IOException  {


        //get the properties from the global.properties file
        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\bindu.sekhar\\OneDrive - Accenture\\Desktop\\BINDU\\MyTech\\E2E\\src\\test\\java\\Model\\global.properties");
        prop.load(fis);

        //Initialise chrome driver
        if(prop.getProperty("browser").equals("chrome"))
        {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "C:\\FILE\\chromedriver.exe");
        driver= new ChromeDriver();}

        //go to the url mentioned in the global properties
        driver.get(prop.getProperty("AutomationPracticeUrl"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

         return driver;
    }
    public static Properties getProperty() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\bindu.sekhar\\OneDrive - Accenture\\Desktop\\BINDU\\MyTech\\E2E\\src\\test\\java\\Model\\global.properties");
        prop.load(fis);
        return prop;
    }

}

