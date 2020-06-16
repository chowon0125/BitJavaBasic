package matrix;

import java.util.Random;

class LottoCheck{
	
	public boolean trueOrFalse(int lotto[], int number) {
		boolean result = false;
			for(int i = 0; i<lotto.length; i++) {
				if(lotto[i] == number) {
					result = true;
				}
			}
			return result;
	}
}

public class LottoPractice {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		LottoCheck instance = new LottoCheck();
		
		int temp;
		int[] lotto = new int[6];
		
		for(int i = 0; i<lotto.length; i++) {
			temp = random.nextInt(45)+1;
			if(instance.trueOrFalse(lotto, temp)) {
				i--;
				continue;
			}
			lotto[i] = temp;
		}
		
		for(int i = 0; i<lotto.length; i++) {
			System.out.println((i+1)+"번째 숫자 : "+lotto[i]);
		}
		
	}
	
}
