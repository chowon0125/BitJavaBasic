package member;

public interface MemberService {
	public void join(Member member);
	public String login(Member member);
	public String idCheck(Member member);
	// public String modifyPassword(Member member);
	public Member[] list();
	public void changePassword(Member member);
	public void withdrawal(Member member);
	public Member idfind(String id);
	public Member[] namefind(String name);
	int count();
}