package p20200623;

public class P0623_1 {
	int m = 0;
	class InstanceInner{
		int iv = 100;
		int t = m;
		// 		static int cv = 100;
		final static int CONST = 100;
	}
	static class StaticInner{
		int iv = 200;
		//int t = m;
		static int cv = 200;
	}
	void myMethod() {
		class Locallnner{
			int iv = 300;
			int t = m;
		//		static int cv = 300;		
			final static int CONST = 300;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);
	}
}
