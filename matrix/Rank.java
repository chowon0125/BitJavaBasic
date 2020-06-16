package matrix;

import java.util.Scanner;

/*
 * 5명의 점수를 입력받아서 1등 90점 2등 86, 3등 70, 4등 66점, 5등 40점으로 출력하시오.
 * 출력시 행렬을 사용.
 * */

class Student{
	int score;
	String name;
}

public class Rank {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student[] score = new Student[5];
		
		
		// Input
		for(int i = 0; i < score.length; i++) {
			score[i] = new Student();
			System.out.printf("[%d번째 학생 정보]\n", i+1);
			System.out.println("이름: ");
			score[i].name = scan.next();
			System.out.println("점수: ");
			score[i].score = scan.nextInt();
		}
		
		// Sorting
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; i > j; j++) {
				if(score[i].score > score[j].score) {					
					Student temp = score[i]; 
					score[i] = score[j];
					score[j] = temp;
				}
			}
		}
		
		// Print		
		for(int i = 0; i < score.length; i++) {
			System.out.printf("%d등\t%s\t%d점\n", i+1, score[i].name, score[i].score);
		}
				
	}
}