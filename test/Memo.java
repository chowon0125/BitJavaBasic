package test;

import java.util.Scanner;

public class Memo {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int count = 0;
		int number;

		System.out.println("숫자를 입력하시오");
		number = scanner.nextInt();
		System.out.println("숫자 "+number+"는 소수인가?");
		
		for(int i = 1;i<=number;i++) {
			if(number%i == 0) {
				count++;
			}
		}
		
		switch(count) {
		case 1 : System.out.println(number+"은 1이다."); break;
		case 2 : System.out.println(number+"은 소수이다."); break;
		default : System.out.println(number+"은 소수가 아니다."); break;
		}
	}	
}
