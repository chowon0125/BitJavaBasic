package sequence;

import java.util.Scanner;

public class Score {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		int[] score = new int[5];
		
		int sum = 0;
		float avg = 0;
		
		for(int i = 0; i<score.length; i++) {
			System.out.println((i+1)+"번째 심사위원 점수를 입력하세요");
			score[i]= scanner.nextInt();
		}
		
		int highscore = score[0];
		int lowscore = score[0];
		
		for(int j = 1; j<score.length; j++) {
			if(score[j]>highscore) {
				highscore = score[j];
			}
		}
		
		for(int k = 1; k<score.length; k++) {
			if(score[k]<lowscore) {
				lowscore = score[k];
			}
		}
		
		for(int x = 0; x<score.length; x++) {
			sum += score[x];
		}
		
		sum -= highscore;
		sum -= lowscore;
		avg = sum / (score.length-2);
		
		System.out.println("[최고점수 : "+highscore+"점 , 최저점수 : "+lowscore+"점, 평균점수 : "+avg+"점]");
		
		
		
	}
}

