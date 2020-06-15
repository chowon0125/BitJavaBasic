package sequence;

import java.util.Scanner;

public class InputSequence {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int number;
		
		System.out.println("숫자 입력");
		number = scanner.nextInt();
		
		int sum = 0;
		
		for(int i = 0; i<number; i++) {
			if( (i+1) % 2 != 0) {
				sum += (i+1);
			}
		}
		
		
		System.out.println(sum);
		
		
	}
}
