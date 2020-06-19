package oop;

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
		return String.format(Constants.PERSON_STAT, name, id, pass);
	}
}

class Student extends Person{
	
	protected String ssn, score;

	public String getSsn() {return ssn;}
	public void setSsn(String ssn) {this.ssn = ssn;}
	public String getScore() {return score;}
	public void setScore(String score) {this.score = score;}
	@Override
	public String toString() {
		return String.format(Constants.STUDENT_STAT, name, id, pass, ssn, score);
	}
}

class Admin extends Person{
	
	protected int rank;

	public int getRank() {return rank;}
	public void setRank(int rank) {this.rank = rank;}
	@Override
	public String toString() {
		return String.format(Constants.ADMIN_STAT, name, id, pass, rank);
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
	public String logIn(Student student) {
		String login = "아이디나 비밀번호를 확인하세요.";
		for(int i=0; i<index; i++) {
			if(student.getId().equals(students[i].getId())
					&&student.getPass().equals(students[i].getPass())) {
				login = "로그인 성공"; break;
			}
		}
		return login;
	}
	//3. 비번 수정
	public String changePass(Student student) {
		String result = "정확한 아이디를 입력해주세요";
		for(int i=0; i<index; i++) {
			if(student.getId().equals(students[i].getId())){
				students[i].setPass(student.getPass());
				result = "비밀번호 변경 완료"; break;
			}
		}
		return result;
	}
	//4. 회원탈퇴
	public String withDrawal(Student student) {
		String result = "아이디나 비밀번호를 확인해주세요.";
		for(int i=0; i<index; i++) {
			if(student.getId().equals(students[i].getId())
					&&student.getPass().equals(students[i].getPass())) {
				students[i] = students[index-1];
				students[index-1] = null;
				index--;
				result = "탈퇴 성공"; break;
			}
		}
		return result;
	} 
	//5. 아이디 존재 체크
	public String idCheck(String id) {
		String result = "사용 가능한 아이디입니다.";
		for(int i=0; i<index; i++) {
			if(id.equals(students[i].getId())){result = "중복된 아이디입니다.";break;}
		}
		return result;
	}
	//6. 마이페이지
	public void myPage(Student student) {
		int k = -1;
		for(int i=0; i<index; i++) {
			if(student.getId().equals(students[i].getId())
					&&student.getPass().equals(students[i].getPass())) {
				k = i; break;
			}
		}
		if(k == -1) {System.out.println("아이디나 비밀번호를 확인해주세요.");}
		else {System.out.printf("나의 정보\n"+Constants.MY_INFORMATION , students[k].getId(), students[k].getPass()
				,students[k].getName(), students[k].getSsn(), students[k].getScore(), k);}
	}
	//7. 점수 입력
	public String insertScore(String id, String grade) {
		String result = "정확한 아이디를 입력해주세요";
		for(int i=0; i<index; i++) {
			if(id.equals(students[i].getId())){students[i].setScore(grade); result = "성적 입력 완료";}
		}
		return result;
	}
	//1. 회원목록
	public void list() {
		for(int i=0; i<index; i++) {
			System.out.printf(Constants.MY_INFORMATION , students[i].getId(), students[i].getPass()
					,students[i].getName(), students[i].getSsn(), students[i].getScore(), i);
		}
	}
	//2. 아이디검색
	public String searchId(String id) {
		String result = "아이디를 확인해주세요.";
		for(int i=0; i<index; i++) {
			if(id.equals(students[i].getId())) {
				System.out.printf(Constants.MY_INFORMATION , students[i].getId(), students[i].getPass()
						,students[i].getName(), students[i].getSsn(), students[i].getScore(), i);
				result = "회원 정보 조회 완료";
				}
			}
		return result;
	}
	//3. 이름검색
	public void searchName() {}
	//4. 전체 회원수
	public void count() {
		System.out.printf("현재 가입된 회원은 총 %d명 입니다.\n",index);
		}
	//5. 성적별 현황
	public void report() {}
	
}

interface ServiceInterface{
	
/**1. 회원가입 */
public void join(Student student);
/**2. 로그인  */
public String logIn(Student student);
/**3. 비번수정 */
public String changePass(Student student);
/**4. 회원탈퇴 */
public String withDrawal(Student student);
/**5. 아이디 존재 체크 */
public String idCheck(String id);
/**6. 마이페이지  */
public void myPage(Student student);
/**7. 점수입력 */
public String insertScore(String id, String grade);

/**1. 회원목록  */
public void list();
/**2. 아이디검색  */
public String searchId(String id);
/**3. 이름검색  */
public void searchName();
/**4.전체 회원수  */
public void count();
/**5. 성적별 현황 */
public void report();

} 


class Constants{
	public static final String MAIN_MENU = "0. EXIT  1. 학생  2. 관리자\n";
	public static final String STUDENT_MENU 
			= "0. EXIT\n"
			+ "1. 회원가입\n"
			+ "2. 로그인\n"
			+ "3. 비번수정\n"
			+ "4. 회원탈퇴\n"
			+ "5. 아이디 존재 체크\n"
			+ "6. 마이페이지\n"
			+ "7. 점수입력\n";
	public static final String ADMIN_MENU 
			= "0. EXIT\n"
			+ "1. 회원목록\n"
			+ "2. 아이디검색\n"
			+ "3. 이름검색\n"
			+ "4. 전체 회원수\n"
			+ "5. 성적별 현황\n";
	public static final String ERROR = "정확한 값을 입력해주세요.%n";
	public static final String EXIT = "종료%n";
	public static final String PERSON_STAT = "이름:%s, 아이디:%s, 비밀번호:%s\n";
	public static final String STUDENT_STAT = "이름:%s, 아이디:%s, 비밀번호:%s, 주민등록번호:%s, 점수:%d\n";
	public static final String ADMIN_STAT = "이름:%s, 아이디:%s, 비밀번호:%s, 등급:%d\n";
	public static final String MY_INFORMATION = "[아이디 : %s] [비밀번호 : %s] [이름 : %s] [생년월일 : %s] [성적 : %s] [회원번호 : %d번]\n";
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
		case 1: System.out.println("회원 정보"); service.list(); break;
		case 2: 
			System.out.println("검색할 아이디를 입력하세요.");
			System.out.println(service.searchId(scanner.next()));
			break;
		case 3: break;
		case 4: service.count(); break;
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
			System.out.printf("회원가입 메뉴\n아이디 :\n");
			student.setId(scanner.next());
			System.out.println("비밀번호 :");
			student.setPass(scanner.next());
			System.out.println("이름 : ");
			student.setName(scanner.next());
			System.out.println("주민등록번호 : ");
			student.setSsn(scanner.next());
			service.join(student);
			break;
		case 2: 
			student = new Student();
			System.out.printf("로그인 메뉴\n아이디 :\n");
			student.setId(scanner.next());
			System.out.println("비밀번호 :");
			student.setPass(scanner.next());
			System.out.println(service.logIn(student));
			break;
		case 3: 
			student = new Student();
			System.out.printf("비밀번호 변경\n아이디 :\n");
			student.setId(scanner.next());
			System.out.println("비밀번호 :");
			student.setPass(scanner.next());
			System.out.println(service.changePass(student));
			break;
		case 4: 
			student = new Student();
			System.out.printf("회원 탈퇴\n아이디 :\n");
			student.setId(scanner.next());
			System.out.println("비밀번호 :");
			student.setPass(scanner.next());
			System.out.println(service.withDrawal(student));
			break;
		case 5: 
			System.out.printf("아이디 중복 체크\n아이디 :");
			System.out.println(service.idCheck(scanner.next()));
			break;
		case 6: 
			student = new Student();
			System.out.printf("마이페이지\n아이디 :\n");
			student.setId(scanner.next());
			System.out.println("비밀번호 :");
			student.setPass(scanner.next());
			service.myPage(student);
			break;
		case 7: 
			String id;
			System.out.printf("마이페이지\n아이디 :\n");
			id = scanner.next();
			System.out.println("성적 입력:");
			System.out.println(service.insertScore(id, scanner.next()));
			break;
		default : System.out.printf(Constants.ERROR); break;
		}
	}

}
