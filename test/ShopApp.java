package test;
import java.util.Scanner;
public class ShopApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Shop[] ctms = new Shop[3];
		
		for(int i=0; i<3; i++) {
			Shop ctm = new Shop();
			System.out.println("�̸� :");
			ctm.setName(scanner.next());
			System.out.println("������ :");
			ctm.setPV(scanner.nextInt());
			System.out.println("TV���� :");
			ctm.setTV(scanner.nextInt());
			System.out.println("��ǻ�Ͱ��� :");
			ctm.setCV(scanner.nextInt());
			ctm.sum();
			ctms[i] = ctm;
		}
		
		for(int i=0; i<3; i++) {
			ctms[i].result();
		}
		
	}

}
