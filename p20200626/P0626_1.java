package p20200626;

class Member{
	private String name;
	private int grade;
	
	Member(String name){this.name = name;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getGrade() {return grade;}
	public void setGrade(int grade) {this.grade = grade;}
	public void hello() {System.out.printf("안녕하세요 %s입니다.%n",name);}
}

class SpecialMember extends Member{
	private int specialPoint;
	
	SpecialMember(String name){super(name);}
	public int getSpecialPoint() {return specialPoint;}
	public void setSpecialPoint(int specialPoint) {this.specialPoint = specialPoint;}
	public void hello() {System.out.printf("안녕하세요 스페셜멤버 %s입니다. %n",getName());}
}

public class P0626_1 {
	public static void main(String[] args) {
		Member m = new Member("김길동");
		m.setGrade(3);
		m.hello();
		SpecialMember sm = new SpecialMember("홍길동");
		sm.setGrade(1);
		sm.setSpecialPoint(100);
		Member m2 = sm;
		m2.hello();
	}
}
