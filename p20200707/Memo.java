package p20200707;

class A{
	
	private int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	
}

class B extends A{
	
	
	
}

public class Memo {
	public static void main(String[] args) {
		
		B b = new B();
		b.setA(1);
		System.out.println(b.getA());
		
	}
}
