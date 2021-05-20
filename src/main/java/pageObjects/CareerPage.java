package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareerPage {
	public WebDriver driver;

	public CareerPage(WebDriver driver) {		
		this.driver=driver;	
	}
	
	private By search = By.id("keywordsearch-q");
	private By submitSearch = By.xpath("//div[@class='search_area']//button[@type='submit']");
	private By cookie = By.id("cookie-acknowledge");
	private By location = By.name("locationsearch");
	private By searchJob = By.cssSelector("input[value='Search Jobs']");
	
	
	public WebElement getSearch() {
		return driver.findElement(search);
	}
	public WebElement getSubmitSearch() {
		return driver.findElement(submitSearch);
	}
	public WebElement getCookie() {
		return driver.findElement(cookie);
	}
	public WebElement getLocation() {
		return driver.findElement(location);
	}
	public WebElement getSearchJob() {
		return driver.findElement(searchJob);
	}
}
