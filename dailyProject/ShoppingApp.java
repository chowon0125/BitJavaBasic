package dailyProject;

import java.util.Scanner;

public class ShoppingApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ShoppingService ss = new ShoppingServiceImpl();
		while(true) {
			System.out.println("1:아이템추가 2:아이템목록확인 3:아이템삭제 4:인기순정렬 5:재고추가");
			int input = scanner.nextInt();
			switch (input) {
			case 1:	ss.addItem();break;
			case 2: ss.showList(0); break;
			case 3: ss.eliminateItem(); break;
			case 4: ss.showSalesRate(); break;
			case 5: ss.addStock(); break;
			default:
				break;
			}
		}

	
		
	}

}
