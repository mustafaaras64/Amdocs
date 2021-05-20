package Project.Amdocs;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.ContactPage;
import pageObjects.HomePage;
import resources.Base;

public class TestAmdocs3 extends Base{
	public WebDriver driver;
	private static Logger log =LogManager.getLogger(TestAmdocs3.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));	
		driver.manage().window().maximize();
	}
	
	@Test(groups= {"Smoke"})
	public void testCase4() {
		HomePage hp = new HomePage(driver);
		hp.getAcceptCookies().click();
		hp.getContact().click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.amdocs.com/contact");
		System.out.println("Contact Page url successfully validated");
		log.info("Contact Page url successfully validated");
		
		ContactPage cop = new ContactPage(driver);
		cop.getFirstName().sendKeys("Mustafa");
		cop.getLastName().sendKeys("Aras");
		cop.getEmail().sendKeys("///@gmail.com");
		cop.getJobTitle().sendKeys("SDET");
		cop.getCompany().sendKeys("Amdocs");
		
		String part1 = "//select[@id='Industry']//option[";
		String part2 = "]";
	
		int i=1;
		while(true) {
			WebElement element = driver.findElement(By.xpath(part1 + i + part2));
			String value =element.getText();
			String expected="Information Technology";
			if(value.equals(expected)) {
				element.click();
				break;
			}
			i++;
		}
		
		cop.getPhoneNo().sendKeys("+11111111111");
	}
	
	@Test
	public void testCase5() throws IOException, InterruptedException {
		ContactPage cop = new ContactPage(driver);
		cop.getWorldWide().click();
		Thread.sleep(2000);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Coding\\Ss\\WorldWide.png"));
	}
	
	@Test(dataProvider="getData")
	public void testCase6(String firstName, String lastName) {
		ContactPage cop = new ContactPage(driver);
		driver.navigate().refresh();
		cop.getFirstName().sendKeys(firstName);
		cop.getLastName().sendKeys(lastName);	
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[1][2];
		data[0][0]="Mustafa";
		data[0][1]="Aras";
		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
