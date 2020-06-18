package member;

import java.util.Scanner;

public class MemberServiceImpl implements MemberService {
	private Member[] members;
	private int count;
	
	public MemberServiceImpl() {
		members = new Member[3];
		count = 0;
	}
	//1. 회원가입
	public void join(Member member) {
		members[count] = member;
		count++;
		for(int i=0; i<members.length; i++) {
			if(members[i] != null) {
				System.out.println(members[i].toString());
			}
			else {
				System.out.println("회원정보가 없어요");
			}
		}	
	}
	//2. 로그인
	public String login(Member member) {
		String result = "FAIL";
		for(int i=0; i< count; i++) {
			if(member.getUserid().equals(members[i].getUserid())
					&&
				member.getPassword().equals(members[i].getPassword())) {
				result = "SUCCESS";
				break;
			}
		}
		return result;
	}
	//3. 회원목록
	public Member[] list() {
		return members;
	}
	//4. 중복체크
	public String idCheck(Member member) {
		String result = "사용할 수 있는 아이디입니다.";
		for(int i=0; i< count; i++) {
			if(member.getUserid().equals(members[i].getUserid()))
					 {
				result = "이미 존재하는 아이디입니다.";
				break;
			}
		}	
		return result;
	}
	// 5. 비번 수정
	public void changePassword(Member member) {
		Scanner scanner = new Scanner(System.in);
		boolean check = false;
		int index = 0;
		for(int i=0; i< count; i++) {
			if(member.getUserid().equals(members[i].getUserid())
					&&
				member.getPassword().equals(members[i].getPassword())) {
				check = true;
				index = i;
			}	
		}
		if(check) {
			System.out.println("변경할 비밀번호를 입력해주세요");
			members[index].setPassword(scanner.next());
		}
		else {System.out.println("아이디나 비밀번호를 확인해주세요.");}
	}
	// 6. 회원탈퇴
	public void withdrawal(Member member) {
		Scanner scanner = new Scanner(System.in);
		boolean check = false;
		int index = 0;
		for(int i=0; i< count; i++) {
			if(member.getUserid().equals(members[i].getUserid())
					&&
				member.getPassword().equals(members[i].getPassword())) {
				check = true;
				index = i;
			}
		}
		if(check) {
			System.out.println("정말로 탈퇴하시겠습니까?");
			System.out.println("0. YES  1. NO");
			switch(scanner.nextInt()) {
				case 0: 
					members[index] = null;
					System.out.println("탈퇴가 완료되었습니다."); break;
				case 1: System.out.println("탈퇴가 취소되었습니다."); break;
				default : System.out.println("정확하게 입력해주세요.");break;
			}
		}
		else {System.out.println("아이디나 비밀번호를 확인해주세요.");}
	}
	// 7. 아이디검색
	public Member idfind(String id) {
		return null;
	}
	// 8. 이름 검색(동명이인 처리필요)
	public Member[] namefind(String name) {
		int cnt = 0; // 동명이인의 수
		Member[] temp = new Member[cnt];
		return null;
	}
	// 9. 전체 회원수
	public int count() {
		return 0;
	}

	
	
}
