package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    public WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    By productName = By.xpath("//p[@class='product-name']");
    By promocode = By.xpath("//input[@class='promoCode']");
    By promoButton = By.xpath("//button[@class='promoBtn']");
    By placeOrderBtn = By.xpath("//button[contains(text(),'Place Order')]");

    public WebElement getProductName(){
        return(driver.findElement(productName));
    }
    public WebElement getPrcode(){ return(driver.findElement(promocode));}
    public WebElement getPromoButton(){ return(driver.findElement(promoButton));}
    public WebElement getPlaceOrderButton(){ return(driver.findElement(placeOrderBtn));}
}
