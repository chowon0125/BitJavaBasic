package p20200623;
import p20200622.Hyunchul;
public class P0623_2 {
	
	private int a = 70;
	int b = 70;
	protected int c = 70;
	public int d = 70;
	
	public static void main(String[] args) {
		P0623_2 dj = new P0623_2();
		System.out.println(dj.a);		
		System.out.println(dj.b);		
		System.out.println(dj.c);		
		System.out.println(dj.d);
		
		dj.test();
		dj.test2();
		
		P0623_3 ys = new P0623_3();
		//System.out.println(ys.a);		
		System.out.println(ys.b);		
		System.out.println(ys.c);		
		System.out.println(ys.d);
		
		Hyunchul hc = new Hyunchul();
		//System.out.println(hc.a);		
		//System.out.println(hc.b);		
		System.out.println(hc.c);		
		System.out.println(hc.d);
		System.out.println(hc.dd);
	}
	public void test() {}
	public void test2() {}
}


