package matrix;

public class Teams {
	public static void main(String[] args) {
		String[][] teams= {{"세영","민석","아영","초코"}
							, {"가인","별이","봉이","보리"}
							, {"보경","원영","하늘","예슬"}
							, {"승아","효원","미선","종숙"}};
		
		for(int i = 0; i < teams.length; i++) {
			System.out.printf("%d팀\t",i+1);
			for(int j = 0; j < teams[i].length; j++) {
				System.out.printf("%s\t",teams[i][j]);
			}
			System.out.println("");
		}
	}
}