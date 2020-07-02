package p20200702;

import java.util.ArrayList;
import java.util.Iterator;

public class P0702_5 {
	public static void main(String[] args) {
		ArrayList original = new ArrayList();
		ArrayList copy1 = new ArrayList();
		ArrayList copy2 = new ArrayList();
		
		for(int i=0; i<10; i++) {
			original.add(i);
		}
		
		Iterator it = original.iterator();
		
		while(it.hasNext()) {
			copy1.add(it.next());
		}
		
		System.out.println("original:"+original);
		System.out.println("copy1:"+copy1);
		
		it = original.iterator();
		
		while(it.hasNext()) {
			copy2.add(it.next());
			it.remove();
		}
		
		System.out.println("original:"+original);
		System.out.println("copy2:"+copy2);
		
		
	}
}
