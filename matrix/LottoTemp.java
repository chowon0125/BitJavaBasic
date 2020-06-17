package matrix;

import java.util.Scanner;
class LottoTemp2{
	private int limit;
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getLimit() {
		return limit;
	}
	public int buy(int money) {
		int count = 0;
		if(money < 1000) {
			System.out.println("잘못된 금액");
		}
		else {
			if(limit > money/1000) {count = money/1000;}
			else {count = limit;}
		}
		return count;
	}
	
	
}
public class LottoTemp {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("구매한도 설정");
		LottoTemp2 instance = new LottoTemp2();
		instance.setLimit(scanner.nextInt());
		
		while(true) {
			System.out.println("0. EXIT  1. BUY");
			switch(scanner.nextInt()) {
			case 0 : System.out.println("시스템 종료");return;
			case 1 : buy(scanner, instance);break;
			}
		}
	}

	private static void buy(Scanner scanner, LottoTemp2 instance) {
		System.out.println("구입");
			System.out.println("금액입력");
			System.out.printf("구입로또 %d장%n",instance.buy(scanner.nextInt()));
	}

}
