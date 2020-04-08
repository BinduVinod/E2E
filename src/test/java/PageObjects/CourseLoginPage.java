package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CourseLoginPage {
    public WebDriver driver;

    public CourseLoginPage(WebDriver driver) {
        this.driver = driver;
    }
   By loginIcon = By.xpath("//span[@class=\'icon fa fa-lock\']");
    public WebElement getLoginIcon(){
        return (driver.findElement(loginIcon));
    }
}
