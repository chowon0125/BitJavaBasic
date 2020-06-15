package member;

public class MemberServiceImpl implements MemberService {
	private Member[] members;
	private int count;
	
	public MemberServiceImpl() {
		members = new Member[3];
		count = 0;
	}
	
	public void join(Member member) {
		
		// System.out.println("App 에서 넘어온 회원정보");
		// System.out.println(member.toString());
		
		members[count] = member;
		count++;
		
		// System.out.println("증가된 인덱스값 : "+count);
		// System.out.println("배열에 저장된 회원정보");
		
		for(int i=0; i<members.length; i++) {
			if(members[i] != null) {
				System.out.println(members[i].toString());
			}
			
			else {
				System.out.println("회원정보가 없어요");
			}
		}	
	}

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

	public Member[] list() {
		return members;
	}

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

	/*
	 * public String modifyPassword(Member member) {
	 
		String logic = "아이디나 비밀번호를 확인하세요";
		for(int i=0; i< count; i++) {
			if(member.getUserid().equals(members[i].getUserid())
					&&
				member.getPassword().equals(members[i].getPassword())) {
				
				member = members[i];
				logic = "T";
				break;
			}
		}
		return logic;
	}
	*/
	
}
