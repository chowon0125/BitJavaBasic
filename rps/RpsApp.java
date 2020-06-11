package rps;
import java.util.Scanner;
import java.util.Random;
public class RpsApp {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		
		String setPSelec = "";
		String setCSelec = "";
		String result = "";
		int pSelec = 0;
		int cSelec = 0;
		
		System.out.println("가위, 바위, 보를 고르세요.");
		setPSelec = scanner.next();
		
		if(setPSelec.equals("가위")) {
			pSelec = 0;
		}
		else if(setPSelec.equals("바위")) {
			pSelec = 1;
		}
		else if(setPSelec.equals("보")){
			pSelec = 2;
		}
		else {
			pSelec = 99;
			System.out.println("<<오류!! 정확한 값을 입력하세요.>>");
		}
		
		System.out.println("******************");
		
		cSelec = random.nextInt(3);
		
		if(cSelec == 0) {
			setCSelec = "가위";
		}
		else if(cSelec == 1) {
			setCSelec = "바위";
		}
		else if(cSelec == 2){
			setCSelec = "보";
		}
		
		System.out.println("플레이어의 선택 : "+setPSelec);
		System.out.println("컴퓨터의 선택 : "+setCSelec);
		
		if(cSelec == pSelec) {
			result = "무승부";
		}
		else if(pSelec == 0 && cSelec == 1) {
			result = "플레이어 패배";
		}
		else if(pSelec == 0 && cSelec == 2) {
			result = "플레이어 승리";
		}
		else if(pSelec == 1 && cSelec == 0) {
			result = "플레이어 승리";
		}
		else if(pSelec == 1 && cSelec == 2) {
			result = "플레이어 패배";
		}
		else if(pSelec == 2 && cSelec == 0) {
			result = "플레이어 패배";
		}
		else if(pSelec == 2 && cSelec == 1) {
			result = "플레이어 승리";
		}
		else {
			result = "오류!! 플레이어 패배";
		}
		
		System.out.println(result);
		
	}
}
