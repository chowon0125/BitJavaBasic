package p20200701;
import java.util.HashSet;
import java.util.Random;


public class P0701_7 {
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println(random.nextDouble());
		System.out.println(random.nextBoolean());
		System.out.println(random.nextInt());
		System.out.println(random.nextInt(10));
		System.out.println(random.nextInt(10)+5);
		
		Random random2 = new Random();
		System.out.println((int)(random2.nextDouble()*10));
		System.out.println((int)(random2.nextDouble()*10));
		System.out.println((int)(random2.nextDouble()*10));
		
		HashSet hs = new HashSet();
		Random ro = new Random();
		int cnt = 0;
		while(true) {
			int value = ro.nextInt(46);
			if(hs.add(new Integer(value))) {cnt++;}
			if(cnt==5) break;
		}
		System.out.println(hs);
	}
}
