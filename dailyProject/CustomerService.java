package dailyProject;

public interface CustomerService {
	//회원가입
	public void join(Customer customer);
	//로그인
	public String login(Customer customer);
	//아이디중복확인
	public boolean idCheck(Customer customer);
	//고객목록 출력
	public void print();
	//마이페이지
	public void myPage(Customer customer);
	//회원탈퇴
	public String remove(Customer customer);

}
