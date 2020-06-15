package sequence;

import java.util.Scanner;

public class ScoreExample {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int sum = 0;
		float avg = 0;
		int[] arr = new int[5];
		int max = 0, min = 100;
		for(int i = 0; i < arr.length; i++) {
			System.out.println("점수 :");
			arr[i] = scanner.nextInt();
			if(max < arr[i]) max = arr[i];
			if(min > arr[i]) min = arr[i];
			sum += arr[i];
		}
		
		sum -= max;
		sum -= min;
		avg = sum / (arr.length - 2);
		
		System.out.println(sum);
		System.out.println(avg);
		
	}
	
}
