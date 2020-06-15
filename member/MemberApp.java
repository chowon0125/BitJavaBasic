package member;

/*
 * 요구사항 (기능정의)
 * <사용자기능>
 * 1. 회원가입
 * 2. 로그인
 * 3. 비번 수정
 * 4. 회원 탈퇴
 * 5. 아이디 존재 체크
 * 6. 마이페이지
 * **********************
 * <관리자기능>
 * 7. 회원목록
 * 8. 아이디검색
 * 9. 이름검색
 * 10. 전체 회원수
 */

import java.util.Scanner;

public class MemberApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Member member = null;
		MemberService memberService = new MemberServiceImpl();
		while(true) {
			System.out.println("< < 메 뉴 > >");
			System.out.println("0. 종료   1. 회원가입   2. 로그인 "
					+ "5. 아이디존재  7. 회원목록");
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
				member = new Member();
				System.out.println("로그인");
				System.out.println("아이디 :");
				member.setUserid(scanner.next());
				System.out.println("비밀번호 :");
				member.setPassword(scanner.next());
				String result = memberService.login(member);
				System.out.println(result);
				break;
				
			/*case 3 :
				member = new Member(); // member라는 인스턴스 변수 생성
				System.out.println("비밀번호 변경");
				System.out.println("아이디 :");
				member.setUserid(scanner.next()); //방금 생성한 member변수에 셋유저아이디 메소드 호출(매개변수는 스캐너로 받는 형태)
				System.out.println("비밀번호 :");
				member.setPassword(scanner.next()); // 상동
				String logic = memberService.modifyPassword(member); // 방금 값이 채워진 member 인스턴스 변수를 매개변수로 사용하여 패스워드변경 메소드 호출
				if(logic.equals("T")) { //패스워드 변경 메소드 사용 결과 : logic 문자열 변수에 맞았으면 T, 틀렸으면 오류 메세지가 저장됨. 그걸 리턴으로 받아왔음.
					// 해야 할일 : 만약, 로직 문자열이 T이면, member 변수에게 셋 패스워드 메소드 호출
					 * 
				}
				break;
			*/
				
				
				
			case 5 :
				member = new Member();
				System.out.println("아이디 체크");
				System.out.println("아이디 :");
				member.setUserid(scanner.next());
				result = memberService.idCheck(member);
				System.out.println(result);
				break;
				
			case 7 : 
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
