package Steps;

import Model.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Hooks extends Base  {

 /*@Before("@Login")
 public void SetUp() throws IOException {
     prop = new Properties();
     FileInputStream fis = new FileInputStream("C:\\Users\\bindu.sekhar\\OneDrive - Accenture\\Desktop\\BINDU\\MyTech\\E2E\\src\\test\\java\\Model\\global.properties");
     prop.load(fis);
     driver.get(prop.getProperty("url2"));

     driver.manage().window().maximize();

 }*/
      @After
    public void Teardown(){
        System.out.println("this is printed  after executing the scenario");
        //driver.close();
    }
}
