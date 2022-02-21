package testcase;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import BaseClass.baseclass;

public class Case3 extends baseclass{

	@Test
	public void titleTest() {
		System.out.println("In title test case");
		String title = driver.getTitle();
		assertTrue(title.contains("News"));
	}

}
