package test;
import java.util.Scanner;
public class ShopApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Shop[] ctms = new Shop[3];
		
		for(int i=0; i<3; i++) {
			Shop ctm = new Shop();
			System.out.println("이름 :");
			ctm.setName(scanner.next());
			System.out.println("폰가격 :");
			ctm.setPV(scanner.nextInt());
			System.out.println("TV가격 :");
			ctm.setTV(scanner.nextInt());
			System.out.println("컴퓨터가격 :");
			ctm.setCV(scanner.nextInt());
			ctm.sum();
			ctms[i] = ctm;
		}
		
		for(int i=0; i<3; i++) {
			ctms[i].result();
		}
		
	}

}
