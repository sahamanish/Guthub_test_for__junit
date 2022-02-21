package Simple;

import static org.junit.Assert.*;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class JUnitTest {
	public static WebDriver driver;
	
	@BeforeClass
	public static void initDriver() {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		driver.get("https://mail.aqmtechnologies.com/action/login/aqmtechnologies.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.println("Page title: " + driver.getTitle());
		
	}
	@Test
	public void titleTest() {
		System.out.println("In title test case");
		String title = driver.getTitle();
		assertTrue(title.contains("Welcome"));
	}
	
	@Test
	public void userSpaceTest() {
		System.out.println("In userSpaceTest case");
		boolean userName = driver.findElement(By.name("custom_input")).isDisplayed();
		assertEquals(userName, true);
	}

	
	@AfterClass
	public static void tearDown() {
		System.out.println("Browser Closing Successfully");
//		driver.close();
		driver.quit();	
	}
}

