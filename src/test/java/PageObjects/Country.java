package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Country {
    public WebDriver driver;

    public Country(WebDriver driver) {
        this.driver = driver;
    }

    By dropCountry = By.xpath("//*[@id='root']/div/div/div/div/div/select");
    By checkBox = By.xpath("//input[@class='chkAgree']");
    By proceedBtn = By.xpath("//button[contains(text(),'Proceed')]");
    public WebElement getDropCountry()
    {
        return(driver.findElement(dropCountry));
    }
    public WebElement getcheckBox()
    {
        return(driver.findElement(checkBox));
    }
    public WebElement getProceedBtn()
    {
        return(driver.findElement(proceedBtn));
    }
}
