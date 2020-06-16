package matrix;

public class Gugudan3 {
	
	public static void main(String[] args) {
		
		String[][] gugu = new String[8][9];
		
		for(int i = 0; i<gugu.length; i++) {
			for(int j = 0; j<gugu[i].length; j++) {
				gugu[i][j] = (i+2) + " X " + (j+1) + " = " + ((i+2)*(j+1));
			}
		}
		
		for(int i = 0; i<4; i++) {
			System.out.print("    "+(i+2)+"단"+"\t"+"\t");
		}
		
		System.out.println();
		for(int j = 0;j<9;j++) {
			System.out.println();
			for(int i = 0; i<4; i++) {
				System.out.print(gugu[i][j]+"\t");
			}
		}
		
		System.out.println();
		for(int i = 0; i<4; i++) {
			System.out.print("    "+(i+6)+"단"+"\t"+"\t");
		}
		
		for(int j = 0;j<9;j++) {
			System.out.println();
			for(int i = 4; i<8; i++) {
				System.out.print(gugu[i][j]+"\t");
			}
		}
		
		
	}

}
