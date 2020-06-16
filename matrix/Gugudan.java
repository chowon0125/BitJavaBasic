package matrix;

public class Gugudan {
	public static void main(String[] args) {
		String [][] mtx = new String [8][9];
		//할당
		for(int i = 0;  i < mtx.length; i++) {
			for(int j = 0; j < mtx[i].length; j++) {
				mtx[i][j] = (i+2) +" x " + (j+1) + " = " + (i+2)*(j+1);
				//System.out.printf("%s\t",mtx[i][j]);
			}
		}		
		//출력
		for(int i = 0; i < mtx.length/2; i++) {
			System.out.print("["+(i+2)+"단]\t\t");
		}
		System.out.println("");
		
		for(int j = 0; j < mtx[0].length; j++) {
			for(int i = 0; i < mtx.length/2; i++) {
				System.out.printf("%s\t", mtx[i][j]);
			}
			System.out.println();
		}
		System.out.println("");
		
		for(int i = 4; i < mtx.length; i++) {
			System.out.print("["+(i+2)+"단]\t\t");
		}
		System.out.println("");
		
		for(int j = 0; j < mtx[0].length; j++) {
			for(int i = 4; i < mtx.length; i++) {
				System.out.printf("%s\t", mtx[i][j]);
			}
			System.out.println();
		}
		
	}

}
// i=단수 2,3,4,5 / 6, 7, 8 , 9
// j 는 곱하는 숫자.
// i x j = .. / i+1 x j = 0 ... 
// i x j+1 = ... 