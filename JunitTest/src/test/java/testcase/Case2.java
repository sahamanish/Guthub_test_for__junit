package testcase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import BaseClass.baseclass;

public class Case2 extends baseclass{
	
	@Test
	public void scroll() throws InterruptedException {
		WebElement ele= driver.findElement(By.xpath("//h3[contains(text(),'Business')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		System.out.println("Scrolled");
		Thread.sleep(2000);
		
	}

}
