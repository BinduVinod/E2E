package Steps;


import Model.Base;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class E2ESteps extends Base {
    public WebDriver driver;
    public String optionText;

    @Given("^I navigated to the AutomationPractice page$")
    public void iNavigatedToTheAutomationPracticePage() throws IOException {
        driver = Base.getDriver();
    }

    @When("^I select \"([^\"]*)\" from checkbox example$")
    public void iSelectFromCheckboxExample(String option) {
        List<WebElement> options = driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label"));
        for (int i = 0; i < options.size(); i++) {
            optionText = options.get(i).getText();
            if (optionText.equals(option)) {
                driver.findElement(By.xpath("(//*[@id='checkbox-example']/fieldset/label/input)[" +(i+1)+ "]")).click();
                break;
            }
            }
        }


    @Then("^same option is selected in the dropdown example$")
    public void iShouldSeeSelectedInTheDropdownExample() throws Throwable {
       Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
       s.selectByVisibleText(optionText);
    }

    @And("^same option is entered in the switch to alert example$")
    public void sameOptionIsEnteredInTheSwitchToAlertExample() throws InterruptedException {
        driver.findElement(By.id("name")).sendKeys(optionText);
        Thread.sleep(3000);
    }

    @And("^same option is displayed on alert message on clicking the alert button$")
    public void sameOptionIsDisplayedOnAlertMessageOnClickingTheAlertButton() {
        driver.findElement(By.id("alertbtn")).click();
        String alertText =driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains(optionText));
        driver.switchTo().alert().accept();
    }

    @When("^I select Radio(\\d+) from radiobutton example$")
    public void iSelectRadioFromRadiobuttonExample(String index) throws InterruptedException {
        String radioOption;
        List<WebElement> radio = driver.findElements(By.xpath("//*[@id='radio-btn-example']/fieldset/label"));
        for(int i=0;i<radio.size();i++) {
            radioOption=radio.get(i).getText();
            if (radioOption.contains(index)) {
                driver.findElement(By.xpath("(//*[@id='radio-btn-example']/fieldset/label/input)[" +(i+1)+ "]")).click();
                break;
            }
        }
        Thread.sleep(3000);
    }

    @And("^I type the words on the suggestionclass example to select country$")
    public void iTypeTheWordsOnTheSuggestionclassExampleToSelectCountry(DataTable table) throws InterruptedException {
        List<List<String>> autoentry = table.raw();
        String word =autoentry.get(0).get(0);
        String country =autoentry.get(0).get(1);

        driver.findElement(By.id("autocomplete")).sendKeys(word);
        Thread.sleep(3000);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String script =  "return document.getElementById(\"autocomplete\").value;";
        String text= (String)js.executeScript(script);
        while(!text.equals(country))
        {
            driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
            text=(String)js.executeScript(script);
        }
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    @And("^I hoover over the Mouse Hover and select reload$")
    public void iHooverOverTheMouseHoverAndSelectReload() throws InterruptedException {
        Actions act = new Actions(driver);
        WebElement mouseOver1 = driver.findElement(By.id("mousehover"));
        WebElement mouseOver2 = driver.findElement(By.xpath("//a[text()='Reload']"));

        act.moveToElement(mouseOver1).build().perform();
        act.moveToElement(mouseOver2).click().build().perform();
        Thread.sleep(1000);

    }


    @And("^I click on the newWindow button to see a new window loaded$")
    public void iClickOnTheNewWindowButtonToSeeANewWindowLoaded() throws InterruptedException {
        driver.findElement(By.id("openwindow")).click();
        Set<String> windowId = driver.getWindowHandles();
        Iterator<String> it=windowId.iterator();
        String parentID =it.next();
        String childID =it.next();
        String childURL =driver.switchTo().window(childID).getCurrentUrl();
        Assert.assertEquals(childURL,"http://www.qaclickacademy.com/");
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(parentID);
        Thread.sleep(1000);
        
    }

    @And("^I click the openTab button to see a new tab opened$")
    public void iClickTheOpenTabButtonToSeeANewTabOpened() throws InterruptedException {
        driver.findElement(By.id("opentab")).click();
        Set<String> tabId = driver.getWindowHandles();
        Iterator<String> it=tabId.iterator();
        String parentID =it.next();
        String childID =it.next();
        String childURL =driver.switchTo().window(childID).getCurrentUrl();
        Assert.assertEquals(childURL,"https://www.rahulshettyacademy.com/#/index");
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(parentID);

    }

    @And("^I click the hide button to hide the text box$")
    public void iClickTheHideButtonToHideTheTextBox() throws InterruptedException {
        WebElement text=driver.findElement(By.id("displayed-text"));
        WebElement hideButton =driver.findElement(By.id("hide-textbox"));
        WebElement showButton =driver.findElement(By.id("show-textbox"));
        hideButton.click();
        Thread.sleep(1000);
        Assert.assertFalse(text.isDisplayed());
        showButton.click();
        Assert.assertTrue(text.isDisplayed());
    }

    @And("^I click the practice projects link inside the frame$")
    public void iClickThePracticeProjectsLinkInsideTheFrame() throws InterruptedException {
        WebElement frameId = driver.findElement(By.id("courses-iframe"));
        driver.switchTo().frame(frameId);
        //Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' contact@rahulshettyacademy.com']")).isDisplayed());
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//a[@href='#/mentorship']"))).click().build().perform();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()='Home']")).click();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.rahulshettyacademy.com/#/index"));

    }
}
