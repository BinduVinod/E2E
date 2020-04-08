package Steps;

import Model.Base;
import POJO.PrCode;
import POJO.Vegetable;
import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.Country;
import PageObjects.LandingPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SearchSteps extends Base {
    LandingPage lp ;
    CartPage cp ;
    CheckoutPage cop ;
    Country ctry;
    Properties prop = new Properties();
    WebDriverWait wait ;

    @Given("^User is in Greencart landing page$")
    public void userIsInGreencartLandingPage() throws IOException {
        driver = Base.getDriver();
    }

    @When("^user searched for ([^\"]*) vegetable$")
    public void userSearchedForVegetable(String vegetable) throws Throwable {
        lp=new LandingPage(driver);
        lp.getSearch().sendKeys(vegetable);
        lp.getSearchButton().click();
        //Thread.sleep(3000);
    }

    @Then("^\"([^\"]*)\" results are displayed$")
    public void resultsAreDisplayed(String vegetable) throws Throwable {
        Assert.assertTrue(lp.getProductName().getText().contains(vegetable));
    }

    @And("^add vegetable to cart$")
    public void addVegetableToCart() {
        lp.getIncrementButton().click();
        lp.getAddCartButton().click();
    }

    @And("^user proceeded to checkout page to purchase$")
    public void userProceededToCheckoutPageToPurchase() throws Throwable {
        cp=new CartPage(driver);
        cp.getCartIcon().click();
        cp.getProceedToCheckoutButton().click();
        //Thread.sleep(3000);
    }

    @Then("^selected ([^\"]*) vegetable are displayed in check out page$")
    public void selectedVegetableAreDisplayedInCheckOutPage(String vegetable) throws Throwable {
        cop = new CheckoutPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://rahulshettyacademy.com/seleniumPractise/#/cart"));
        Assert.assertTrue(cop.getProductName().getText().contains(vegetable));
        throw new PendingException();
    }

    @And("^user applied the promocode and verify$")
    public void userAppliedThePromocode(DataTable table) throws InterruptedException {
        wait = new WebDriverWait(driver,6);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        cop = new CheckoutPage(driver);
        List<List<String>> promo1 = table.raw();
        cop.getPrcode().sendKeys(promo1.get(1).get(0));
        cop.getPromoButton().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoinfo")));
        Assert.assertTrue(driver.findElement(By.cssSelector("span.promoinfo")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector("span.discountperc")).getText(),"10%");
    }

    @And("^user placed the order and navigated to country page$")
    public void userPlacedTheOrderAndNavigatedToCountryPage() throws InterruptedException, IOException {
        prop = Base.getProperty();
        cop.getPlaceOrderButton().click();
        Assert.assertTrue(driver.getCurrentUrl().equals(prop.getProperty("countryUrl")));
    }


    @And("^user selected \"([^\"]*)\" from the dropdown and accept the terms and conditions$")
    public void userSelectedFromTheDropdownAndAcceptTheTermsAndConditions(String country) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ctry = new Country(driver);
        Select dropCountry = new Select(ctry.getDropCountry());
        dropCountry.selectByVisibleText(country);
        Thread.sleep(3000);
        ctry.getcheckBox().click();
        ctry.getProceedBtn().click();
    }

    @Then("^I should be redirected to the home page$")
    public void iShouldGetTheSuccessMessage() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(prop.getProperty("url1"),driver.getCurrentUrl());

    }

    @When("^user added the vegetables in cart$")
    public void userAddedTheVegetablesInCart(DataTable table) throws InterruptedException {
        // get the datatable to an arraylist  'veggies' of type Vegetable
        List<Vegetable> veggies = new ArrayList<Vegetable>();
        veggies =table.asList(Vegetable.class);
       //add the veggies to another String arraylist "veggiesList"
        List<String> veggiesList = new ArrayList<String>();
        for(Vegetable v : veggies) {
            veggiesList.add(v.getVegetable());
        }
        //get the locator for the product name and store to a list
        List<WebElement> vegInSite = driver.findElements(By.cssSelector("h4.product-name"));
        for(int i=0;i<vegInSite.size();i++)
        {
            //splitting the vegetable name to extract the veg name and trim to get rid of space
            String[] veg = vegInSite.get(i).getText().split("-");
            String vegg = veg[0].trim();

            if(veggiesList.contains(vegg)) {
                driver.findElements(By.cssSelector("div.product-action")).get(i).click();
              }
        }
        }


}

