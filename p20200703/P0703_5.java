package p20200703;

import java.util.HashMap;
import java.util.Scanner;

public class P0703_5 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("myId","1234");
		map.put("asdf","1111");
		map.put("asdf","1234");
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("ID와 PW 입력");
			System.out.println("id:");
			String id = s.nextLine().trim();
			
			System.out.println("password:");
			String password = s.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) {
				System.out.println("정확한 id 입력");
			}
			else {
				if(!(map.get(id)).equals(password)) {
					System.out.println("정확한 pw 입력");
				}
				else {System.out.println("로그인 성공");}
				break;
			}
		}
	}
}
