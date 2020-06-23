package p20200623;

class A{
	private int x = 100;
	private int y = 200;
}

class B extends A {
	private int r = 300;
}

class A1 {
	protected int x = 100;
	protected void disp() {}
}

class B1 extends A1{
	//private int x = 200;
	public int x = 200;
	public int y = 100;
	public void disp() {
		System.out.println("A1클래스의 x = "+super.x);
		System.out.println("B1클래스의 x = "+this.x);
	}
	
	public void disp2() {}
}

public class P0623_4 {
	public static void main(String[] args) {
		B bp = new B();
		// System.out.println(bp.r); // private라서 접근 불가
		B1 bp1 = new B1();
		System.out.println(bp1.x);
		System.out.println(bp1.y);
		bp1.disp();
		
		A1 ap = new B1();
		System.out.println(ap.x);
		ap.disp();
		
	}
}
