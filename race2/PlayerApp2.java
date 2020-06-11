package race2;

import java.util.Scanner;

public class PlayerApp2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Player2[] list = new Player2[3];
		
		for(int i=0; i<list.length; i++) {
			
			Player2 racer = new Player2();
			
			System.out.println("이름 : ");
			racer.setName(scanner.next());
			System.out.println("기록 : ");
			racer.setRecord(scanner.nextInt());
			
			list[i] = racer;
		}
		
		for(int i=0; i<list.length; i++) {
			list[i].result();
		}
		
		Player2 winner = new Player2();
		winner = list[0];
		for(int i = 1; i<list.length; i++) {
			if(list[i].getRecord() < winner.getRecord()) {
				winner = list[i];
			}
		}
		
		System.out.println("우승자는 "+winner.getName()+"입니다.");
		
	}
}
