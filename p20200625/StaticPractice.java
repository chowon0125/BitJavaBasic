package p20200625;

public class StaticPractice {
	public static void main(String[] args) {
		Customer1 c = new Customer1(100, "홍길동");
		Customer1 c2 = new Customer1(101, "김길동");
		
		EnterAdm.entrance(c);
		EnterAdm.entrance(c2);
		
		System.out.println(EnterAdm.getCount());
	}
}

class EnterAdm{
	static int count;
	static final int maxCnt = 100;
	static Customer1[] custs = new Customer1[maxCnt];
	
	public static void entrance(Customer1 c) {
		if(c != null) custs[count++] = c;
	}
	
	public static int getCount() {
		return count;
	}
}

class Customer1{
	int number;
	String name;
	
	public Customer1(int number, String name) {
		this.number = number;
		this.name = name;
	}
}
