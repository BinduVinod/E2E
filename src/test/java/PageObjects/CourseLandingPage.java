package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CourseLandingPage {
    public WebDriver driver;

    public CourseLandingPage(WebDriver driver) {
        this.driver = driver;
    }
    By emailID = By.xpath("//input[@id='user_email']");
    By password = By.xpath("//input[@id='user_password']");
    By login = By.name("commit");

    public WebElement getemailID(){
        return (driver.findElement(emailID));
    }
    public WebElement getPassword(){
        return (driver.findElement(password));
    }
    public  WebElement getLogin(){
        return(driver.findElement(login));
    }

}
