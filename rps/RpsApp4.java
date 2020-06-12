package rps;
import java.util.Scanner;
import java.util.Random;
public class RpsApp4 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		while(true) {
			System.out.println("< < 메   뉴 > >");
			System.out.println("0.종료   1.게임");
			switch(scanner.nextInt()) {
			case 0 : System.out.println("*****종료*****"); return;
			case 1 : game(scanner, random); break;
			}
		}
	}

	private static void game(Scanner scanner, Random random) {
		int playerI = 0;
		int cpuI = 0;
		String playerS = "";
		String cpuS = "";
		String result = "";
		
		System.out.println("가위, 바위, 보를 선택하십시오.");
		System.out.println("1.가위   2.바위   3.보");
		
		playerI = scanner.nextInt();
		cpuI = random.nextInt(3);
		cpuI++;
		
		switch(playerI) {
		case 1 : playerS = "가위"; break;
		case 2 : playerS = "바위"; break;
		case 3 : playerS = "보"; break;
		default : playerS = "오류"; System.out.println("오류! 올바른 숫자를 선택하십시오."); break;
		}
		
		switch(cpuI) {
		case 1 : cpuS = "가위"; break;
		case 2 : cpuS = "바위"; break;
		case 3 : cpuS = "보"; break;
		}
		
		System.out.println("플레이어의 선택 : "+playerS);
		System.out.println("컴퓨터의 선택 : "+cpuS);
		
		if(playerI == 1) {
			switch(cpuI) {
			case 1 : result = "무승부"; break;
			case 2 : result = "플레이어 패배"; break;
			case 3 : result = "플레이어 승리"; break;
			}
		}
		else if(playerI == 2) {
			switch(cpuI) {
			case 1 : result = "플레이어 승리"; break;
			case 2 : result = "무승부"; break;
			case 3 : result = "플레이어 패배"; break;
			}
		}
		else if(playerI == 3) {
			switch(cpuI) {
			case 1 : result = "플레이어 패배"; break;
			case 2 : result = "플레이어 승리"; break;
			case 3 : result = "무승부"; break;
			}
		}
		else {
			result = "오류";
		}
		
		System.out.println(result);
	}

}
