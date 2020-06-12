package member;

public class MemberServiceImpl implements MemberService {
	private Member[] members = new Member[3];
	private int idx = 0;
	
	@Override
	public void join(Member member) {
		// TODO Auto-generated method stub
		System.out.println("App 에서 넘어온 회원정보");
		System.out.println(member.toString());
		members[idx] = member;
		System.out.println("배열에 저장된 회원정보");
		System.out.println(members[idx]);
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}
	
}
