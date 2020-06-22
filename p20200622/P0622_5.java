package p20200622;

import java.util.Scanner;

public class P0622_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어 : ");
		int kor = Integer.parseInt(scanner.nextLine());
		System.out.print("영어 : ");
		int eng = Integer.parseInt(scanner.nextLine());
		System.out.print("수학 : ");
		int math = Integer.parseInt(scanner.nextLine());
		
		int sum = kor + eng + math;
		float avg = sum/3.0f + sum%3.0f;
		System.out.printf("총점: %d점%n",sum);
		System.out.printf("평균 : %.2f점%n",avg);
		
		String grade;
		
		if(avg>90) grade = "A";
		else if(avg>80) grade = "B";
		else if(avg>70) grade = "C";
		else if(avg>60) grade = "D";
		else grade = "E";
		
		System.out.printf("당신의 성적은 %s입니다.%n",grade);
	}
}
