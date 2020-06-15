package matrix;

/*5	10	15	20	25	
30	35	40	45	50	
55	60	65	70	75	
80	85	90	95	100	
105	110	115	120	125
 */

public class Matrix {
	public static void main(String[] args) {
		
		int[][] mtx = new int[5][5];
		int k = 1;
		for(int i = 0;i < mtx.length;i++) {
			for(int j = 0;j < mtx[i].length;j++) {
				mtx[i][j] = k++*5;
						 
			}
		}
		for(int i = 0;i < mtx.length;i++) {
			System.out.println("");
			for(int j = 0;j < mtx[i].length;j++) {
				System.out.printf(mtx[i][j]+"\t");
			}	
		}
	}
}
