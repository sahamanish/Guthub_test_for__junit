package testcase;

import java.util.ArrayList;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.baseclass;

public class Case1 extends baseclass{
		   
//		private String TestCase;
//		private String Search;
	//	
//		public Test1(String TestCase,String Search) {
//			this.TestCase=TestCase;
//			this.Search=Search;
//		}
		@Test
		public void initilize() throws InterruptedException {
			System.out.println();
			System.out.println("currentHandle:" +currentHandle);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='moneyiframe']")));

			driver.findElement(By.xpath("//input[@id='query']")).click();
			driver.findElement(By.xpath("//input[@id='query']")).clear();
			driver.findElement(By.xpath("//input[@id='query']")).sendKeys("Yes Bank");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@class='getqbtn']")).click();

			WebDriverWait wait = new WebDriverWait(driver,20);
			//to handle the  the multiples tabs
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			System.out.println("Page title of new tab: " + driver.getTitle());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='srchword']")));

			//		driver.findElement(By.xpath("//span[@id='Volume']")).getAttribute("value");
			String Volume=driver.findElement(By.xpath("//span[@id='Volume']")).getText();
			System.out.println("Volume: "+Volume);
			//span[@id='Volume']
			driver.close();

			driver.switchTo().window(tabs2.get(0));
			System.out.println("1_tab: "+tabs2.get(0)+ ", 2_tab: "+tabs2.get(1));
//			driver.close();
		}
}
