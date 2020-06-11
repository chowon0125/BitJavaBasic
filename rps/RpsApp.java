package rps;
import java.util.Scanner;
import java.util.Random;
/*
 * "플레이어 1 가위"
 * "컴퓨터1 보"
 * 
 * "플레이어 승리"
 * "플레이어 무승부"
 * "플에이어 패배"
 */
public class RpsApp {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		String setPSelec = "";
		String setCSelec = "";
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
			System.out.println("정확한 값을 입력하세요.");
		}
		
		cSelec = random.nextInt(2);
		
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
			System.out.println("무승부");
		}
		else if(pSelec == 0 && cSelec == 1) {
			System.out.println("플레이어 패배");
		}
		else if(pSelec == 0 && cSelec == 2) {
			System.out.println("플레이어 승리");
		}
		else if(pSelec == 1 && cSelec == 0) {
			System.out.println("플레이어 승리");
		}
		
		else if(pSelec == 1 && cSelec == 2) {
			System.out.println("플레이어 패배");
		}
		else if(pSelec == 2 && cSelec == 0) {
			System.out.println("플레이어 패배");
		}
		else if(pSelec == 2 && cSelec == 1){
			System.out.println("플레이어 승리");
		}
		else {
			System.out.println("오류");
		}
		
		
		
		

		
		
		
		
	}
}
