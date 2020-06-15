package member;

public interface MemberService {
	public void join(Member member);
	public String login(Member member);
	public String idCheck(Member member);
	// public String modifyPassword(Member member);
	public Member[] list();
}