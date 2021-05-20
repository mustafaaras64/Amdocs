package Project.Amdocs;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CareerPage;
import pageObjects.HomePage;
import resources.Base;

public class TestAmdocs2 extends Base{
	public WebDriver driver;
	private static Logger log =LogManager.getLogger(TestAmdocs2.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));	
		driver.manage().window().maximize();
	}
	
	@Test(groups= {"Smoke"})
	public void testCase3() {
		HomePage hp = new HomePage(driver);
		hp.getAcceptCookies().click();
		hp.getCareer().click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.amdocs.com/careers/home");
		System.out.println("Career Page url successfully validated");
		log.info("Career Page url successfully validated");
		
		CareerPage cp = new CareerPage(driver);
		cp.getSearch().sendKeys("SDET");
		cp.getSubmitSearch().click();
		cp.getCookie().click();
		cp.getLocation().sendKeys("Dallas");
		cp.getSearchJob().click();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
