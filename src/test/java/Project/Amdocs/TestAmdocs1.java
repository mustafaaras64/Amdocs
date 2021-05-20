package Project.Amdocs;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.Base;

public class TestAmdocs1 extends Base {
	public WebDriver driver;
	private static Logger log =LogManager.getLogger(TestAmdocs1.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));	
		driver.manage().window().maximize();
	}
	
	@Test(groups= {"Smoke"})
	public void testCase1() {
		HomePage hp = new HomePage(driver);
		hp.getAcceptCookies().click();
		hp.getAbout().click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.amdocs.com/about");
		System.out.println("About Page url successfully validated");
		log.info("About Page url successfully validated");
	}
	
	@Test(priority=1)
	public void testCase2() {
		HomePage hp = new HomePage(driver);
		hp.getNews().click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.amdocs.com/news-media");
		System.out.println("News & Media Page url successfully validated");
		log.info("News & Media Page url successfully validated");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}

