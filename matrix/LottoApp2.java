package matrix;

import java.util.Random;
import java.util.Scanner;

class Lotto2{
	
	private int countLimit; 
	private int lottoCount;
	private int[] lotto;
	private int[][] lottos;
	
	public void setCountLimit(int countLimit) {
		this.countLimit = countLimit;
	}
	public int getCountLimit() {
		return countLimit;
	}
	
	public void setLottos() {
		lotto = new int[6];
		lottos = new int[lottoCount][6];
		for(int i=0; i<lottoCount; i++) {
			for(int j=0; j<6; j++) {
				int num = (int)(Math.random()*45)+1;
				while(!isDuplication(num)) {
					lotto[j] = num;
					break;
				}
			}
			sort(lotto);
			System.arraycopy(lotto, 0, lottos[i], 0, lotto.length);
			//array를 matrix에 한 줄씩 입력하는 방법.
		}
	}
	public int[][] getLottos() {
		setLottos();
		return lottos;
	}
	
	public void sort(int[] arr) {
		int temp;
		for(int i=0; i<arr.length-1; i++) {
			for(int j = i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	this.lotto = arr;
	}
	
	public int lottoCount(int money) {
		int lottoCount;
		if(money<1000) {System.out.println("금액이 부족합니다."); lottoCount = 0;}
		else {
			if(money > countLimit * 1000) lottoCount = countLimit;
			else lottoCount = money / 1000;
		}
		this.lottoCount = lottoCount;
		return lottoCount;
	}
	
	
	public boolean isDuplication(int num) {
		boolean ok = false;
		for(int i = 0; i< lotto.length; i++) {
			if(lotto[i] == num) ok = true;
		}
		return ok;
	}
	/*public void lottoSelect(Random random, int[] lotto, Lotto2 instance) {
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
	*/
	 public void buyLotto(Scanner scanner, Lotto2 instance) {
		System.out.println("얼마치를 구입합니까?");
		System.out.printf("로또 %d장을 구매합니다.%n",instance.lottoCount(scanner.nextInt()));
		int[][] lottos = instance.getLottos();
		for(int i=0; i<lottos.length;i++) {
			System.out.print((i+1)+"번째 결과 :   ");
			for(int j=0; j<lottos[i].length; j++) {
				System.out.print(lottos[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
}
public class LottoApp2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Lotto2 instance = new Lotto2();
		System.out.println("구매한도 설정");
		instance.setCountLimit(scanner.nextInt());
		System.out.printf("설정된 구매한도  %d장%n",instance.getCountLimit());
		while(true) {
			System.out.println("0. EXIT  1. BUY");
			switch(scanner.nextInt()) {
			case 0 : System.out.println("종료"); return;
			case 1 : System.out.println("로또 구입");
			instance.buyLotto(scanner, instance);
			break;
			}
		}
	}


}
