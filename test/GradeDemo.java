package test;
import java.util.Scanner;
public class GradeDemo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("A학생 점수:");
		int a = scanner.nextInt();
		System.out.println("B학생 점수:");
		int b = scanner.nextInt();
		System.out.println("C학생 점수:");
		int c = scanner.nextInt();
		
		String winner = "";
		
		if(a > b && a > c) {
			winner = "a win";
		}
		else if (a < b && b > c) {
			winner = "b win";
		}
		else {
			winner = "c win";
		}
		
		System.out.println(winner);
	}
	
}
