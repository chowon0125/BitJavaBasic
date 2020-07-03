package mrPaek;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int blk = 0;
		if (n == 1) {
			System.out.println("*");
		} else {
			for (int i = 0; i < n; i++) {
				int x = (2 * n) - 1 - (i * 2);
				for (int j = 0; j < blk; j++) {
					System.out.print(" ");
				}
				for (int k = x; k > 0; k--) {
					System.out.print("*");
				}
				System.out.println("");
				blk++;
			}
			blk -= 2;

			for (int i = 1; i < n - 1; i++) {
				int x = 1 + (i * 2);
				for (int j = 0; j < blk; j++) {
					System.out.print(" ");
				}
				for (int k = x; k > 0; k--) {
					System.out.print("*");
				}
				System.out.println("");
				blk--;
			}
			for (int i = 0; i < (n * 2) - 1; i++) {
				System.out.print("*");
			}
		}
	}
}