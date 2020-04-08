package Steps;

import Model.Base;
import Model.UserLogin;
import PageObjects.CourseLandingPage;
import PageObjects.CourseLoginPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginSteps extends Base {
    CourseLoginPage cLoginPage;
    CourseLandingPage cLandingPage;


    @And("^I enter the login button$")
    public void iEnterTheLoginButton() {
        cLandingPage = new CourseLandingPage(driver);
        cLandingPage.getLogin().click();
    }

    @When("^I enter the login details$")
    public void iEnterTheLoginDetails(DataTable table) {
        cLandingPage = new CourseLandingPage(driver);
       /* List<UserLogin> Users = new ArrayList<UserLogin>();
         Users = table.asList(UserLogin.class);
        for (UserLogin u:Users
             ) {
            cLandingPage.getemailID().sendKeys(u.getEmailid());
            cLandingPage.getPassword().sendKeys(u.getPassword());
        }   */
        List<List<String>> us =table.raw();
        cLandingPage.getemailID().sendKeys(us.get(1).get(0));
        cLandingPage.getPassword().sendKeys(us.get(1).get(1));
    }

    @Given("^I am in the login page$")
    public void iAmInTheLoginPage() throws IOException {
        driver = Base.getDriver();
        cLoginPage = new CourseLoginPage(driver);
        cLoginPage.getLoginIcon().click();
    }

    @Then("^I should see the course page$")
    public void iShouldSeeTheCoursePage() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://courses.rahulshettyacademy.com/");

    }
}


