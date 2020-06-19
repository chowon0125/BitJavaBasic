package one;

import java.util.Scanner;

/*
 * RFP
 *  Person(id, pass, name:String) 
 *  	- Student(ssn:String, score:int), 
 *  	- Admin(rank:int)
 * <사용자기능> Student
 * 1. 회원가입
 * 2. 로그인
 * 3. 비번 수정
 * 4. 회원탈퇴
 * 5. 아이디 존재 체크
 * 6. 마이페이지
 * 7. 점수 입력
 * **************
 * <관리자기능> Admin
 * 1. 회원목록
 * 2. 아이디검색
 * 3. 이름검색
 * 4. 전체 회원수
 * 5. 성적별 현황(스코어 기준 이름 내림차순 예.. 1등 이순신(여) 98점, 2등 김유신(남) 85점 )
 */

class Person{
	
	protected String id, pass, name;

	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getPass() {return pass;}
	public void setPass(String pass) {this.pass = pass;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	@Override
	public String toString() {
		return String.format("이름:%s, 아이디:%s, 비밀번호:%s\n", name, id, pass);
	}
}

class Student extends Person{
	
	protected String ssn, score, sex;

	public String getSsn() {return ssn;}
	public void setSsn(String ssn) {this.ssn = ssn;}
	public String getScore() {return score;}
	public void setScore(String score) {this.score = score;}
	@Override
	public String toString() {
		return String.format("이름:%s, 성별:%s, 아이디:%s, 비밀번호:%s, 주민등록번호:%s, 점수:%d\n", name, sex, id, pass, ssn, score);
	}
}

class Admin extends Person{
	
	protected int rank;

	public int getRank() {return rank;}
	public void setRank(int rank) {this.rank = rank;}
	@Override
	public String toString() {
		return String.format("이름:%s, 아이디:%s, 비밀번호:%s, 등급:%d\n", name, id, pass, rank);

	}
}

class Service implements ServiceInterface{
	
	public int index = 0;
	Student[] students = new Student[3]; 
	
	//1. 회원가입
	public void join(Student student) {
		students[index] = student;
		index++;
	}
	//2. 로그인
	public void logIn() {}
	//3. 비번 수정
	public void changePass() {}
	//4. 회원탈퇴
	public void withDrawal() {} 
	//5. 아이디 존재 체크
	public void idCheck() {}
	//6. 마이페이지
	public void myPage() {}
	//7. 점수 입력
	public void insertScore() {}
	//1. 회원목록
	public void list() {
		for(int i=0; i<students.length; i++) {
			students[i].toString();
		}
	}
	//2. 아이디검색
	public void searchId() {}
	//3. 이름검색
	public void searchName() {}
	//4. 전체 회원수
	public void count() {}
	//5. 성적별 현황
	public void report() {}
	
}

interface ServiceInterface{
	
/**1. 회원가입 */
public void join(Student student);
/**2. 로그인  */
public void logIn();
/**3. 비번수정 */
public void changePass();
/**4. 회원탈퇴 */
public void withDrawal();
/**5. 아이디 존재 체크 */
public void idCheck();
/**6. 마이페이지  */
public void myPage();
/**7. 점수입력 */
public void insertScore();

	 
/**1. 회원목록  */
public void list();
/**2. 아이디검색  */
public void searchId();
/**3. 이름검색  */
public void searchName();
/**4.전체 회원수  */
public void count();
/**5. 성적별 현황 */
public void report();

} 


class Constants{
	
	public static final String MAIN_MENU = "0. EXIT  1. 학생  2. 관리자%n";
	public static final String STUDENT_MENU = "0. EXIT  1. 회원가입  2. 로그인  3. 비번수정  4. 회원탈퇴  5. 아이디 존재 체크  6. 마이페이지  7. 점수입력%n";
	public static final String ADMIN_MENU = "0. EXIT  1. 회원목록  2. 아이디검색  3. 이름검색  4.전체 회원수  5. 성적별 현황%n";
	public static final String ERROR = "정확한 값을 입력해주세요.%n";
	public static final String EXIT = "종료%n";
	
	
}

public class PersonApp {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Student student = null;
		ServiceInterface service = new Service();
		while(true) {
			System.out.printf(Constants.MAIN_MENU);
			switch(scanner.nextInt()) {
			case 0: System.out.printf(Constants.EXIT); return;
			case 1: System.out.printf(Constants.STUDENT_MENU);
				studentMenu(service, scanner);break;
			case 2: System.out.printf(Constants.ADMIN_MENU);
				adminMenu(service, scanner);break;
			default : System.out.printf(Constants.ERROR); break;
			}
		}
		
		
		
	}

	private static void adminMenu(ServiceInterface service, Scanner scanner) {
		switch(scanner.nextInt()) {
		case 0: System.out.printf(Constants.EXIT); return;
		case 1: break;
		case 2: break;
		case 3: break;
		case 4: break;
		case 5: break;
		default : System.out.printf(Constants.ERROR); break;
		}
	}

	private static void studentMenu(ServiceInterface service, Scanner scanner) {
		Student student;
		switch(scanner.nextInt()) {
		case 0: System.out.printf(Constants.EXIT); return;
		case 1: 
			student = new Student();
			System.out.printf("회원가입 메뉴%n아이디 :%n");
			student.setId(scanner.next());
			System.out.println("비밀번호 :");
			student.setPass(scanner.next());
			System.out.println("이름 : ");
			student.setName(scanner.next());
			System.out.println("생년월일 6자리 : ");
			student.setSsn(scanner.next());
			service.join(student);
			break;
		case 2: break;
		case 3: break;
		case 4: break;
		case 5: break;
		case 6: break;
		case 7: break;
		default : System.out.printf(Constants.ERROR); break;
		}
	}

}
