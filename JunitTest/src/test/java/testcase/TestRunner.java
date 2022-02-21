package testcase;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runners.AllTests;

import junit.framework.TestSuite;

public class TestRunner {
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(testcase.AllTests.class);
		
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println("Total test runs "+result.getRunCount());
		System.out.println("Total test failed "+result.getFailureCount());
		System.out.println("Total ignored test cases "+result.getIgnoreCount());
		System.out.println("Is all tests run successfully :->"+result.wasSuccessful());
		System.out.println("Total time to run test cases "+result.getRunTime());
	}
}
