package test;
import java.util.Scanner;
public class ForDemo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int numOfStudents;
		
		System.out.println("학생 수를 입력하세요 :");
		numOfStudents = scanner.nextInt();
		
		int[] score = new int[numOfStudents];
		
		for(int i = 0; i<score.length; i++) {
			System.out.println(i+1+"번째 학생 점수 :");
			score[i] = scanner.nextInt();
		}
		
		for(int i = 0; i<score.length; i++) {
			System.out.println(i+1+"번째 학생 점수 :"+score[i]);
		}
		
		int winnerScore = score[0];
		
		for(int i = 1; i<score.length; i++) {
			if(winnerScore < score[i]) {
				winnerScore = score[i];
			}
		}
		
		System.out.println("1등의 점수는 :" + winnerScore);
	}
}
