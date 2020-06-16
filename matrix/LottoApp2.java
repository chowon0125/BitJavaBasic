package matrix;

import java.util.Random;

class Lotto2{
	
	int lotto[];
	public boolean isDuplication(int[] lotto, int num) {
		boolean ok = false;
		for(int i = 0; i< lotto.length; i++) {
			if(lotto[i] == num) ok = true;
		}
		return ok;
	}
}
public class LottoApp2 {
	
	public static void main(String[] args) {
		Random random = new Random();
		int[] lotto = new int[6];
		Lotto2 instance = new Lotto2();
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
}
