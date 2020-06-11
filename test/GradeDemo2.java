package test;
import java.util.Scanner;
public class GradeDemo2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
			
		String name = "";
		int score = 0;
		final String ENG = "영어";
		String grade = "";
		
		System.out.println("이름을 입력하세요 : ");
		name = scanner.next();
		
		System.out.println("점수를 입력하세요 : ");
		score = scanner.nextInt();
		
		if(score >= 90) {
			grade = "A";
		}
		else if(score >= 80) {
			grade = "B";
		}
		else if(score >= 70) {
			grade = "C";
		}
		else if(score >= 60) {
			grade = "D";
		}
		else if(score >= 50) {
			grade = "E";
		}
		else {
			grade = "F";
		}
		System.out.println("********************************");
		System.out.println("   이름      영어      점수      등급");
		System.out.println("-----------------------------------");
		System.out.println("| "+name+" | "+ENG+" | "+score+"점 | "+grade+" |");
		System.out.println("********************************");
	}
}
