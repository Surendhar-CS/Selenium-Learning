package coreJavaPractice.Inheritance;

public class Childclass3 {
	int a;
	public Childclass3(int a) {
		this.a=a;
		System.out.println("Childclass 3 invoked by super() call");
	}

	
	public int multiplyTwo() {
		a*=2;
		return a;
	}

	public int multiplyThree() {
		a*=3;
		return a;
	}
}
