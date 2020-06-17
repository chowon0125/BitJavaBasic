package matrix;

import java.util.Scanner;
class LottoTemp4{
	private int limit;
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getLimit() {
		return this.limit;
	}
	
	public int buy(int money) {
		int count;
		if(money<1000) {
			count = 0;
			System.out.println("금액이 모자랍니다.");
		}
		else {
			if(money>limit * 1000) {
				count = limit;
				System.out.printf("총 구매량 %d장%n", count); 
			}
			else {
				count = money / 1000;
				System.out.printf("총 구매량 %d장%n", count); 
			}
		}
		return count;
	}
}

public class LottoTemp3 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		LottoTemp4 instance = new LottoTemp4();
		System.out.println("구매한도 입력");
		instance.setLimit(scanner.nextInt());
		
		while(true) {
			System.out.println("0. EXIT   1. BUY");
			switch(scanner.nextInt()) {
			case 0 : System.out.println("시스템 종료"); return;
			case 1 : buy(scanner, instance); break;
			}
		}
	}

	private static void buy(Scanner scanner, LottoTemp4 instance) {
		System.out.println("로또 구매");
		System.out.println("구매금액 입력");
		instance.buy(scanner.nextInt());
	}

}
