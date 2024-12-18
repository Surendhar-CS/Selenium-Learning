package coreJavaPractice.Inheritance;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParentClass1 {

	
	
	public  void printGreeting()
	{
		System.out.println("greeting from parentClass1");
	}

	@BeforeTest
	public void beforeRun()
	{
		System.out.println("Before run from ParentClass1");
	}
	
	
	@AfterTest
	public void afterRun()
	{
		System.out.println("after run from ParentClass1");
	}
	
}
