package coreJavaPractice.Inheritance;

import org.testng.annotations.Test;

public class Childclass1  extends ParentClass1{

	int a;
	
	
	@Test
	public void childTest()
	{
		a=3;
		Childclass2 Obj=new Childclass2(a);//parameterised constructor
		printGreeting();
		
		System.out.println(Obj.increment());
		System.out.println(Obj.decrement());
	}
	
	
	
}
