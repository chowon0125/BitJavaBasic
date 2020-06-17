package matrix;

import java.util.Random;
import java.util.Scanner;

class Lotto2{
	
	private int countLimit;
	
	public void setCountLimit(int countLimit) {
		this.countLimit = countLimit;
	}
	public int getCountLimit() {
		return countLimit;
	}
	public int lottoCount(int money) {
		int count;
		if(money<1000) {System.out.println("금액이 부족합니다."); count = 0;}
		else {
			if(money > countLimit * 1000) count = countLimit;
			else count = money / 1000;
		}
		return count;
	}
	
	
	public boolean isDuplication(int[] lotto, int num) {
		boolean ok = false;
		for(int i = 0; i< lotto.length; i++) {
			if(lotto[i] == num) ok = true;
		}
		return ok;
	}
	public void lottoSelect(Random random, int[] lotto, Lotto2 instance) {
		for(int i = 0; i< lotto.length; i++) {
			int temp = random.nextInt(45)+1;
			System.out.printf("뽑힌 값: %d\n", temp);
			if(instance.isDuplication(lotto, temp)) {
				i--;
				continue;
			}
			lotto[i] = temp;
		}
	}
	public void buyLotto(Random random, Scanner scanner, Lotto2 instance, int[] lotto) {
		System.out.println("얼마치를 구입합니까?");
		System.out.printf("로또 %d장을 구매합니다.%n",instance.lottoCount(scanner.nextInt()));
		instance.lottoSelect(random, lotto, instance);
	}
}
public class LottoApp2 {
	
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		Lotto2 instance = new Lotto2();
		int[] lotto = new int[6];
		System.out.println("구매한도 설정");
		instance.setCountLimit(scanner.nextInt());
		System.out.printf("설정된 구매한도  %d장%n",instance.getCountLimit());
		while(true) {
			System.out.println("0. EXIT  1. BUY");
			switch(scanner.nextInt()) {
			case 0 : System.out.println("종료"); return;
			case 1 : System.out.println("로또 구입");
			instance.buyLotto(random, scanner, instance, lotto);
			break;
			}
		}
	}


}
