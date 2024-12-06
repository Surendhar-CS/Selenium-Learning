package seleniumQA;

import java.util.ArrayList;

public class arraylistex {
public static void main(String[] args) {
	ArrayList<String> a=new ArrayList<String>();
	a.add("Sura");
	a.add("meow");
	a.add("Cat");
	System.out.println(a.size());
	a.add("Category");
	System.out.println(a.size());
	for(String name:a)
	{
		System.out.println(name);
	}
	System.out.println("************");
	for(int i=0;i<a.size();i++)
	{
		System.out.println(a.get(i));
	}
	System.out.println(a.contains("Sura"));
	
	int[] numArray=new int[5];
	numArray[0]=0;
//	for(int i=0;i<numArray.length;i++) {
//		numArray[i]=i+3;
////		System.out.println(numArray[i]);
//	}
	for(int i:numArray) {
	numArray[i]=i+1;
//	System.out.println(numArray[i]);
}

	for(int i:numArray)
		System.out.println(i);
	
	
}
}
