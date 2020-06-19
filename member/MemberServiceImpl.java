package member;

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
	public boolean login(Member member) {
		boolean result = false;
		for(int i=0; i< count; i++) {
			if(member.getUserid().equals(members[i].getUserid())
					&&
				member.getPassword().equals(members[i].getPassword())) {
				result = true;
				break;
			}
		}
		if(result) {System.out.println("로그인 성공");}
		else {System.out.println("로그인 실패");}
		return result;
	}
	//3. 회원목록
	public Member[] list() {
		return members;
	}
	//4. 중복체크
	public void idCheck(Member member) {
		boolean idcheck = false;
		for(int i=0; i< count; i++) {
			if(member.getUserid().equals(members[i].getUserid()))
				idcheck = true;
			}
		if(idcheck){System.out.println("이미 존재하는 아이디입니다.");}
		else {System.out.println("사용할 수 있는 아이디입니다.");}
	}
	// 5. 비번 수정
	public void changePassword(Member member) {
		for(int i=0; i< count; i++) {
			if(member.getUserid().equals(members[i].getUserid())) {
				members[i].setPassword(member.getPassword());
				break;
			}	
		}
	}
	// 6. 회원탈퇴
	public String withdrawal(Member member) {
		String result = "탈퇴 실패";
		for(int i=0; i< count; i++) {
			if(member.getUserid().equals(members[i].getUserid())
					&&member.getPassword().equals(members[i].getPassword())) {
				members[i] = members[count-1];
				members[count-1] = null;
				count --;
				result = "탈퇴 성공";
				break;
			}
		}
		return result;
	}
	// 7. 아이디검색
	public Member idSearch(String id) {
		Member member = new Member();
		for(int i=0; i<members.length; i++) {
			if(id.equals(members[i].getUserid())) {
				member = members[i]; break;
			}
		}
		return member;
	}
	// 8. 이름 검색(동명이인 처리필요)
	public Member[] nameSearch(String name) {
		int cnt = 0; // 동명이인의 수
		for(int i=0; i<members.length; i++) {
			if(name.equals(members[i].getName())) {
				cnt++;
			}
		}
		Member[] searchMembers = new Member[cnt];
		int k = 0;
		for(int i = 0; i<members.length; i++) {
			if(name.equals(members[i].getName())) {
				searchMembers[k] = members[i];
				k++;
				if(k == cnt) break;
			}
		}
		return searchMembers;
	}
	// 9. 전체 회원수
	public int count() {
		return count;
	}
	
	
	
}
