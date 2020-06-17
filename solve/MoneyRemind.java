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

class MoneyLogic{
	
	private int money, temp;
	private int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	private int[] result = new int[8];
	public void calculate(int money) {
		this.money = money;
		temp = money;
		for(int i=0; i<arr.length; i++) {
			result[i] = temp / arr[i];
			temp = temp - (arr[i]*result[i]);
		}
	}
	public void print() {
		System.out.printf("******************%n요청금액 : %d원%n5만원 : %d매%n1만원 : %d매%n5천원 : %d매%n"
				+ "1천원 : %d매%n5백원 : %d개%n백원 : %d매%n오십원 : %d매%n십원 : %d매%n******************%n"
				,money,result[0],result[1],result[2],result[3],result[4],result[5],result[6],result[7]);
	}
}

public class MoneyRemind {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MoneyLogic instance = new MoneyLogic();
		System.out.println("금액을 입력하세요");
		instance.calculate(scanner.nextInt());
		instance.print();
	}
}
