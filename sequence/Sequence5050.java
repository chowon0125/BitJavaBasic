package sequence;

public class Sequence5050 {
	public static void main(String[] args) {
		/*
		
		1 ~ 3의 합
		
		*/
		int sum = 0;
		
		for(int i = 1 ; i<=5 ; i++) {
			
			sum += i;
		}
		
		System.out.println(sum);
	
		
	
		int[] arr = {1, 2, 3, 4, 5};
		
		int sum2 = 0;
		
		int j = 0;
		
		for(;;) {
			if(j<arr.length) {
				sum2 += arr[j];
				j++;
				continue;
			}
			else {
				break;
			}
			
		}
		
		System.out.println(sum2);
		
		int sum3 = 0;
		int k = 0;
		
		while(k<arr.length) {
			sum3 += arr[k];
			k++;
		}
		
		System.out.println(sum3);
		
		int sum4 = 0;
		int x = 0;
		
		while(true) {
			if(x<arr.length) {
				sum4 += arr[x];
				x++;
			}
			else {
				break;
			}
		}
		System.out.println(sum4);
		
		int oddSum = 0;
		int y = 0;
		while(true) {
			if(y<arr.length) {
				oddSum += arr[y];
				y+=2;
			}
			else {
				break;
			}
		}
		
		System.out.println(oddSum);
		
		int evenSum = 0;
		int z = 1;
		while(true) {
			if(z<arr.length) {
				evenSum += arr[z];
				z+=2;
			}
			else {
				break;
			}
		}
		System.out.println(evenSum);
			
		
	}	
}
