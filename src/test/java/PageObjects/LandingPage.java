package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;
    //constructor
    public LandingPage(WebDriver driver) {
       this.driver = driver;
    }
    By search = By.className("search-keyword");
    By searchButton = By.className("search-button");
    By productName =By.xpath("//h4[@class='product-name']");
    By incrementButton = By.xpath("//a[@class=\"increment\"]");
    By addCartButton = By.xpath("//button[text()='ADD TO CART']");

    public WebElement getSearch(){
        return(driver.findElement(search));
    }

    public WebElement getIncrementButton(){
        return(driver.findElement(incrementButton));
    }

    public WebElement getAddCartButton(){
        return(driver.findElement(addCartButton));
    }


    public WebElement getSearchButton(){
        return(driver.findElement(searchButton));
    }
    public WebElement getProductName(){
        return(driver.findElement(productName));
    }

}
