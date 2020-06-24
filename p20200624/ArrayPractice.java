package p20200624;

public class ArrayPractice {
	public static void main(String[] args) {
		int sum = 0;
		float average = 0f;
		
		int[] score = {100, 88, 100, 100, 90};
		//int[] score = new int[]{100, 88, 100, 100, 90};
		//int[] score = new int[5];
		//score[0] = 100; score[1] = 88; score[2] = 100; score[3] = 100; score[4] = 90;
		
		for(int p : score) sum += p;
		
		average = sum / (float)score.length;
		
		System.out.printf("총점 : %d%n", sum);
		System.out.printf("평균 : %.1f%n", average);
		
		int max = score[0];
		int min = score[0];
		
		for(int p : score) {
			if(p>max) max = p;
			if(p<min) min = p;
		}
		
		System.out.printf("최대값 : %s, 최소값 : %s%n", max, min);
		
		
	}
}
