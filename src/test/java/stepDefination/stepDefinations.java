package stepDefination;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.ContactPage;
import pageObjects.HomePage;
import resources.Base;

public class stepDefinations extends Base {

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	 driver =initializeDriver();
    }

    @And("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	driver.get(strArg1);
    	driver.manage().window().maximize();
    }
    
    @And("^User accept cookies$")
    public void user_accept_cookies() throws Throwable {
    	HomePage hp = new HomePage(driver);
    	hp.getAcceptCookies().click();
    }
    
    @When("^Click on Contact page$")
    public void click_on_contact_page() throws Throwable {
    	HomePage hp = new HomePage(driver);
    	hp.getContact().click();
    }

    @Then("^User enters firstname as \"([^\"]*)\" and lastname as \"([^\"]*)\"$")
    public void user_enters_firstname_as_something_and_lastname_as_something(String firstname1, String lastname1) throws Throwable {
    	ContactPage cop = new ContactPage(driver);
    	cop.getFirstName().sendKeys(firstname1);
    	cop.getLastName().sendKeys(lastname1);
    }

    @And("^close browsers$")
    public void close_browsers() throws Throwable {
    	driver.quit();
    }
	
}
