package p20200623;
/*
 * * 실습: SpecialMember, Member를설계하시오

Member m = new Member(“김길동”);

m.setGrade(“3”);

m.hello(); //  안녕하세요 김길동입니다

SpecialMember sm= new SpecialMember(“홍길동”);

sm.setGrade(“1”);

sm.setSpecialPoint(100); // SpecialMember만 specialPoint관리

Member m2 = sm;

m2.hello(); // 안녕하세요 스패설멤버홍길동입니다
 * 
 */

class Member{
	
	protected String name;
	protected int grade;
	Member(){}
	Member(String name){
		this.name = name;
	}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getGrade() {return grade;}
	public void setGrade(int grade) {this.grade = grade;}
	
	public void hello() {
		System.out.printf("안녕하세요 %s입니다.%n" , name);
	}
}

class SpecialMember2 extends Member{
	private int specialPoint;
	public SpecialMember2(String name) {
		super.name = name;
	}

	public int getSpecialPoint() {return specialPoint;}
	public void setSpecialPoint(int specialPoint) {this.specialPoint = specialPoint;}
	
	public void hello() {
		System.out.printf("안녕하세요 스페셜멤버 %s입니다.%n" , super.name);
	}
}

public class Practice4 {
	public static void main(String[] args) {
		Member m = new Member("홍길동");
		m.setGrade(3);
		m.hello();
		SpecialMember2 sm = new SpecialMember2("홍길동");
		sm.setGrade(1);
		sm.setSpecialPoint(100);
		Member m2 = sm;
		m2.hello();
	}
}
