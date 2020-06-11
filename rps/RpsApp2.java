package rps;
import java.util.Scanner;
import java.util.Random;
public class RpsApp2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		while(true) {
			System.out.println("메뉴 : 0.종료  1.게임");
			switch (scanner.nextInt()) {
			case 0 : System.out.println("종료"); return;
			case 1 : game(scanner, random); break;
			}
		}
		
		
		
		
	}

	private static void game(Scanner scanner, Random random) {
		String setPSelec = "";
		String setCSelec = "";
		String result = "";
		int pSelec = 0;
		int cSelec = 0;
		
		System.out.println("가위, 바위, 보를 고르세요.");
		setPSelec = scanner.next();
		if(setPSelec.equals("가위")
			||setPSelec.equals("바위")
			||setPSelec.equals("보")) {
				switch(setPSelec) {
				case "가위" : pSelec = 0; break;
				case "바위" : pSelec = 1; break;
				case "보" : pSelec = 2; break;
				}
		}
		else {
			pSelec = 99;
			System.out.println("<<오류!! 정확한 값을 입력하세요.>>");
		}
		
		System.out.println("******************");
		
		cSelec = random.nextInt(3);
		
		setCSelec = cpurps(setCSelec, cSelec);
		
		System.out.println("플레이어의 선택 : "+setPSelec);
		System.out.println("컴퓨터의 선택 : "+setCSelec);
		
		if(pSelec == 0) {
			switch(cSelec) {
			case 0 : result = "무승부"; break;
			case 1 : result = "플레이어 패배"; break;
			case 2 : result = "플레이어 승리"; break;
			}
		}
		else if(pSelec == 1) {
			switch(cSelec) {
			case 0 : result = "플레이어 승리"; break;
			case 1 : result = "무승부"; break;
			case 2 : result = "플레이어 패배"; break;
			}
		}
		else if(pSelec == 2) {
			switch(cSelec) {
			case 0 : result = "플레이어 패배"; break;
			case 1 : result = "플레이어 승리"; break;
			case 2 : result = "무승부"; break;
			}
		}
		else {
			result = "오류!!!";
		}
		
		System.out.println(result);
	}

	private static String cpurps(String setCSelec, int cSelec) {
		switch(cSelec) {
		case 0 : setCSelec = "가위"; break;
		case 1 : setCSelec = "바위"; break;
		case 2 : setCSelec = "보"; break;
		}
		return setCSelec;
	}
}
