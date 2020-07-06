package mrPaek;

import java.util.Scanner;

public class Memo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int c = scanner.nextInt();
		int n;
		int[][] score = new int[c][];
		int[] sum = new int[c];
		double[] avg = new double[c];
		int[] cnt = new int[c];
		double[] result = new double[c];
		
		for(int i=0; i<c; i++) {
			n = scanner.nextInt();
			for(int j=0; j<n; j++) {
				score[i][j] = scanner.nextInt();
				sum[i] += score[i][j];
			}
		}	
		
		
	}
}
