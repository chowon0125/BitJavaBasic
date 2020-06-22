package p20200622;

class PassingValueType{
	
	void test01(int param) {
		param = 2;
	}
	void test02(Box box) {
		box = new Box();
		box.x = 1;
	}
	void test03(Box box) {
		box.x=1;
	}
}

class Box{
	public int x;
}

public class P0622 {
	public static void main(String[] args) {
		
	PassingValueType test = new PassingValueType();
	int iValue = 1;
	System.out.printf("Test01 before : %d\n" ,iValue);
	test.test01(iValue);
	System.out.printf("Test01 after : %d\n" ,iValue);
	
	Box box = new Box();
	System.out.printf("Test02 before : %d\n", box.x);
	test.test02(box);
	System.out.printf("Test02 after : %d\n", box.x);
	
	Box box2 = new Box();
	System.out.printf("test03 before : %d\n", box2.x);
	test.test03(box2);
	System.out.printf("test03 after : %d\n", box2.x);
	
	
	 
	}	
}
