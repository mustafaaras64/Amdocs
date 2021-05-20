package Project.Amdocs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class TestAmdocs4SQLConnection extends Base{

	public WebDriver driver;
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;
	private static Logger log =LogManager.getLogger(TestAmdocs4SQLConnection.class.getName());

	@BeforeTest
	public void initialize() throws IOException, SQLException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));	
		driver.manage().window().maximize();
		
		connection=null;
		String url = "jdbc:mysql://localhost:3306/amdocs";
		String username = "root";
		String password = "/////";
		connection = DriverManager.getConnection(url, username, password);
		
		if(connection !=null)
			System.out.println("Successfully connected to SQL DataBase...");
			log.info("Successfully connected to SQL DataBase...");
	}
	
	@Test
	public void testCase7() throws SQLException {
		statement = connection.createStatement();
		resultset = connection.createStatement().executeQuery("SELECT*FROM amdocs.tablle1");
		
		while(resultset.next()) {
			String values = resultset.getString("Name");
			System.out.println(values);
			log.info(values);
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		if(connection !=null)
			System.out.println("Closing the SQL DataBase...");
			log.info("Closing the SQL DataBase...");
	}
	
	
	
	
	
	
	
	
	
	
	
}
