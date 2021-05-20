package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {		
		this.driver=driver;	
	}

	private By cookies = By.id("onetrust-accept-btn-handler");
	private By about = By.cssSelector("div[class='region region-navigation']>nav>ul>li:nth-of-type(1)");
	private By news = By.cssSelector("div[class='region region-navigation']>nav>ul>li:nth-of-type(2)");
	private By costumers = By.cssSelector("div[class='region region-navigation']>nav>ul>li:nth-of-type(3)");
	private By career = By.cssSelector("div[class='region region-navigation']>nav>ul>li:nth-of-type(4)");
	private By blogs = By.cssSelector("div[class='region region-navigation']>nav>ul>li:nth-of-type(5)");
	private By contact = By.cssSelector("div[class='region region-navigation']>nav>ul>li:nth-of-type(6)");
	
	
	public WebElement getAcceptCookies() {
		return driver.findElement(cookies);
	}
	public WebElement getAbout() {
		return driver.findElement(about);
	}
	public WebElement getNews() {
		return driver.findElement(news);
	}
	public WebElement getcostumer() {
		return driver.findElement(costumers);
	}
	public WebElement getCareer() {
		return driver.findElement(career);
	}
	public WebElement getBlogs() {
		return driver.findElement(blogs);
	}
	public WebElement getContact() {
		return driver.findElement(contact);
	}
}
