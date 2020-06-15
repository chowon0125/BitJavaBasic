package matrix;

public class MatrixBasic {
	public static void main(String[] args) {
		
		
		int[][] mtx2 = new int[3][];
		
		int count2 = 1;
		
		mtx2[0] = new int[3];
		mtx2[1] = new int[2];
		mtx2[2] = new int[5];
		
		for(int i = 0;i<mtx2.length;i++) {
			for(int j = 0;j<mtx2[i].length;j++) {
				mtx2[i][j] = count2++;
			}
		}
		
		for(int i = 0;i < mtx2.length;i++) {
			System.out.println("");
			for(int j = 0;j < mtx2[i].length;j++) {
				System.out.printf(mtx2[i][j]+"\t");
			}	
		}
	}
}
