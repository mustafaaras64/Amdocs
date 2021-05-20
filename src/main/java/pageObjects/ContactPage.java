package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {
	public WebDriver driver;

	public ContactPage(WebDriver driver) {		
		this.driver=driver;	
	}
	
	private By firstName = By.id("FirstName");
	private By lastName = By.name("LastName");
	private By email = By.xpath("//input[@placeholder='Email Address']");
	private By jobTitle = By.cssSelector("input[name='Title']");
	private By company = By.id("Company");
	private By industry = By.id("Industry");
	private By phone = By.name("Phone");
	private By country = By.id("Country");
	private By worldWide = By.id("divAbout2Link");

	
	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}
	public WebElement getLastName() {
		return driver.findElement(lastName);
	}
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getJobTitle() {
		return driver.findElement(jobTitle);
	}
	public WebElement getCompany() {
		return driver.findElement(company);
	}
	public WebElement getIndustry() {
		return driver.findElement(industry);
	}
	public WebElement getPhoneNo() {
		return driver.findElement(phone);
	}
	public WebElement getCountry() {
		return driver.findElement(country);
	}
	public WebElement getWorldWide() {
		return driver.findElement(worldWide);
	}
	
}
