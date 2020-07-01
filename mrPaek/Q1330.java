package mrPaek;

import java.util.Scanner;

public class Q1330 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		String result ="";
		if(x>y) result = ">";
		if(x<y) result = "<";
		if(x==y) result = "==";
		System.out.println(result);
	}

}
