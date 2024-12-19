package coreJavaPractice.Inheritance;

public class Childclass2 extends Childclass3{
	int a;

	public Childclass2(int a) {
		super(a);
		this.a = a;
	}

	public int increment() {
		a++;
		return a;
	}

	public int decrement() {
		a--;
		return a;
	}

}
