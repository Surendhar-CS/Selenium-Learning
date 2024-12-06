package seleniumQA;

public class StringEx {
public static void main(String[] args) {
	String s="This is Sura";
	System.out.println(s);
	String[] splitedStrings=s.split(" ");
	for(String str:splitedStrings)
		System.out.println(str);
	System.out.println("*****************");
	String str2="   SURA   ";
	System.out.println(str2.trim());
	String str3="meow";
	String str4="meow";
	System.out.println(str4.hashCode());
	str4="category";
	System.out.println(str3.hashCode());
	System.out.println(str4.hashCode());
	System.out.println(str4.charAt(3));
			
}
}
