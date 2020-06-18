package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Memo2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> demo = new ArrayList<String>();
			
		String result = "";
		demo.add("1");
		demo.add("2");
		demo.add("3");
		demo.add("4");
		System.out.println("숫자입력");
		result = (demo.contains(scanner.next()))?"존재함":"존재하지 않음";
		System.out.println(result);
		
	
	}

}
