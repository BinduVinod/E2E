package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    public WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartIcon = By.xpath("//a[@class='cart-icon']");
    By proceedToCheckoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");

    public WebElement getCartIcon(){
        return(driver.findElement(cartIcon));
    }
    public WebElement getProceedToCheckoutButton(){
        return(driver.findElement(proceedToCheckoutButton));
    }

}
