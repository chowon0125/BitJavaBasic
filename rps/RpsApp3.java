package rps;
import java.util.Scanner;
import java.util.Random;
public class RpsApp3 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		while(true) {
			System.out.println("<<메뉴>>");
			System.out.println("0. 종료   1. 게임   2. 통계");
			switch(scanner.nextInt()){
			case 0 : System.out.println("종료"); return;
			case 1 : game(scanner, random);	break;
			case 2 : System.out.println(
						Calculate.playerWin+"승 "
						+Calculate.draw+"무 "
						+Calculate.cpuWin+"패"); break;
			}	
		}
	}

	private static void game(Scanner scanner, Random random) {
		int playerI = 0;
		int cpuI = 0;
		String playerS = "";
		String cpuS = "";
		String result = "";
		
		System.out.println("가위, 바위, 보를 고르세요.");
		System.out.println("1.가위, 2.바위, 3.보");
		
		playerI = scanner.nextInt();
		cpuI = random.nextInt(3);
		cpuI++;
		
		if(playerI == 1 || playerI == 2 || playerI == 3) {
			playerS = translate(playerI, playerS);
		}	
		else {
			System.out.println("오류 !! 올바른 숫자를 골라주십시오.");
			playerS = "오류";
		}
		
		cpuS = translate(cpuI, cpuS);
		
		System.out.println("플레이어의 선택 : "+playerS);
		System.out.println("컴퓨터의 선택 : "+cpuS);
		
		if(playerI == 1) {
			switch(cpuI){
			case 1 : result = "무승부"; Calculate.draw++; break;
			case 2 : result = "패배"; Calculate.cpuWin++; break;
			case 3 : result = "승리"; Calculate.playerWin++; break;
			}
		}
		else if(playerI == 2) {
			switch(cpuI){
			case 1 : result = "승리"; Calculate.playerWin++; break;
			case 2 : result = "무승부"; Calculate.draw++; break;
			case 3 : result = "패배"; Calculate.cpuWin++; break;
			}
		}
		else if(playerI == 3) {
			switch(cpuI){
			case 1 : result = "패배"; Calculate.cpuWin++; break;
			case 2 : result = "승리"; Calculate.playerWin++; break;
			case 3 : result = "무승부"; Calculate.draw++; break;
			}
		}
		else {
			result = "오류!!!";
		}
		
		System.out.println(result);
	}

	private static String translate(int playerI, String playerS) {
		switch(playerI) {
		case 1 : playerS = "가위"; break;
		case 2 : playerS = "바위"; break;
		case 3 : playerS = "보"; break;
		}
		return playerS;
	}
}
