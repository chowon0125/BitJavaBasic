package race;
import java.util.Scanner;
public class PlayerApp {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		Player[] players = new Player[3];
		
		for(int i=0; i<players.length; i++) {
			
			Player player = new Player();
			System.out.println("�̸� :");
			player.setName(scanner.next());
			System.out.println("��� :");
			player.setRec(scanner.nextInt());
		
			players[i] = player;
	
		}
		
		for(int i=0; i<players.length; i++) {
			
			players[i].result();
		}
		
}
}
