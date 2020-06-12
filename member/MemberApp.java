package member;

import java.util.Scanner;

public class MemberApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Member member = null;
		MemberService memberService = new MemberServiceImpl();
		while(true) {
			System.out.println("< < 메 뉴 > >");
			System.out.println("0. 종료   1. 회원가입   2. 로그인   3. 회원목록");
			switch(scanner.nextInt()) {
			case 0 : 
				System.out.println("시스템 종료"); return; 
				
			case 1 : 
				member = new Member();
				
				System.out.println("회원가입");
				System.out.println("아이디 :");
				member.setUserid(scanner.next());
				System.out.println("비밀번호 :");
				member.setPassword(scanner.next());
				System.out.println("이름 :");
				member.setName(scanner.next());
				
				System.out.println(member.toString());
				
				memberService.join(member);
				break;
				
			case 2 :  
				break;
				
			case 3 : 
				System.out.println("목록보기");
				Member[] list = memberService.list();
				for(int i = 0; i < 3; i++) {
					System.out.println(list[i]);
				}
				break;
				
			default : System.out.println("메뉴 선택 오류"); break;
			}
		}
	}
}
