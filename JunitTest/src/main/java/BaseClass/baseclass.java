package BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {

	public  WebDriver driver;
	public  String currentHandle;
	@Before
	public void setup() {

		WebDriverManager.chromedriver().setup();

		//to seperate the download files directory path
		Map<String, Object> prefs=new HashMap<String, Object>();
		prefs.put("download.default_directory", System.getProperty("user.dir")+File.separator+"externalFiles"+ File.separator+"ChromeFileDownloads");
		ChromeOptions option=new ChromeOptions();
		option.setExperimentalOption("prefs", prefs);

		//to open in incognito mode
		option.addArguments("--incognito");
		driver=new ChromeDriver(option);

		driver.get("https://www.rediff.com/");
		//		driver.navigate().to("https://www.rediff.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		currentHandle= driver.getWindowHandle();
		System.out.println("Page title: " + driver.getTitle());
		System.out.println("Parenthandler: "+currentHandle);


	}

	@Rule
	public TestWatcher watchman = new TestWatcher() {
		@Override
		protected void failed(Throwable e, Description description) {
			// Handle logging of failing tests
			System.out.println("Fail!");
		}

		@Override
		protected void succeeded(Description description) {
			// Handle logging of succeeding tests
			System.out.println("Success!");
		}
	};
	
	@After
	public void endup() {
		
		driver.quit();
		System.out.println("Browser Closing Successfully");
	}
}
