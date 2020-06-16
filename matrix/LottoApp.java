package matrix;

import java.util.Random;

public class LottoApp {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		int[] lotto = new int[6];
		
		int temp;
		
		lotto[0] = random.nextInt(45)+1;
		for(int i = 1; i<lotto.length; i++) {
			temp = random.nextInt(45)+1;
			if(lotto[i-1]!= temp) {
				lotto[i] = temp;
			}
			else {
				System.out.println((i+1)+"번째 숫자 중복발생 : 재추첨");
				i--;
			}
		}
		
		for(int i = 0 ; i<lotto.length; i++ ) {
			
			System.out.println(lotto[i]);
			
		}	
		
		
		
		
		
		
		
	}

}
