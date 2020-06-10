package race;
import java.util.Scanner;
public class PlayerApp {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		Player[] players = new Player[3];
		
		for(int i=0; i<players.length; i++) {
			
			Player player = new Player();
			System.out.println("이름 :");
			player.setName(scanner.next());
			System.out.println("기록 :");
			player.setRec(scanner.nextInt());
		
			players[i] = player;
	
		}
		for(int i=0; i<players.length; i++) {
			players[i].result();
		}
		
		Player[] ranking = new Player[3];
		if(players[0].getRec() < players[1].getRec()) {
			if(players[0].getRec()<players[2].getRec()) {
				ranking[0] = players[0];
			}
			else {
				ranking[0] = players[2];
			}
		}
		else {
			if(players[1].getRec() < players[2].getRec()) {
				ranking[0] = players[1];
			}
			else {
				ranking[0] = players[2];
			}
		}
		
		System.out.println("1등은 " + ranking[0].getName());
		
	}		
}
