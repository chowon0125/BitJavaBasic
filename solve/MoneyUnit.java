package solve;

import java.util.Scanner;
/*
 * * 금액을 입력받은 후 우리나라 화폐종류별로 해당 갯수를 표기하는 프로그램
  * [요구사항] 금융업을 하는 고객사로부터 프로그램 개발요청이 들어왔습니다.
  * 금액을 입력받은 후 우리나라 화폐종류별로 해당 갯수를 표기하는 프로그램입니다.
  * 예를들어, 125,520 원을 입력하면 화면에 이렇게 보이게 하면 됩니다.
  * 표시하고 10원미만은 절삭
   ******************************************************
     요청금액 : 126520 원
     5만원 : 2매
     1만원 : 2매
     5천원 : 1매
     1천원 : 1매
     5백원 : 1개
     백원 : 0개
     오십원 : 0개
     십원 : 2개
   ********************************************************
 */
class Money{
	private int temp, money;
	int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	int[] result = new int[8];
		
	public void calculate(int money) {
		this.money = money;
		temp = money;
		for(int i=0; i<arr.length; i++) {
			result[i] = temp / arr[i];
			temp = temp - (arr[i]*result[i]);
		}
	}
	
	public void print() {
		System.out.printf("****************************%n요청금액 : %d원%n5만원: %d매%n1만원: %d매%n5천원: %d매%n1천원: %d매%n"
				+ "5백원: %d개%n백원: %d개%n오십원: %d개%n십원: %d개%n****************************%n"
				,money, result[0], result[1], result[2], result[3], result[4], result[5], result[6], result[7]);
	}
}

public class MoneyUnit {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Money instance = new Money();
		while(true) {
			System.out.println("0. 종료    1. 입력");
			switch(scanner.nextInt()) {
			case 0 : System.out.println("종료");return;
			case 1 : 
				System.out.println("금액을 입력하세요.");
				instance.calculate(scanner.nextInt());
				instance.print(); break;
			}
		}
	}
}

/*m50k = money / 50000;
		
		temp = money - (m50k*50000);
		
		m10k = temp / 10000;
		
		temp = temp - (m10k*10000);
		
		m5k = temp / 5000;
		
		temp = temp - (m5k*5000);
		
		m1k = temp / 1000;
		
		temp = temp - (m1k*1000);
		
		m500 = temp / 500;
		
		temp = temp - (m500*500);
		
		m100 = temp / 100;
		
		temp = temp - (m100*100);
		
		m50 = temp / 50;
		
		temp = temp - (m50*50);
		
		m10 = temp / 10;
		
		temp = temp - (m10*10);
		
		
		
		System.out.printf("****************************%n요청금액 : %d원%n5만원: %d매%n1만원: %d매%n5천원: %d매%n1천원: %d매%n"
				+ "500원: %d개%n백원: %d개%n오십원: %d개%n십원: %d개%n****************************%n"
							,money, m50k, m10k, m5k, m1k, m500, m100, m50, m10);
							
 */



