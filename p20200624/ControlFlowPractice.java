package p20200624;

import java.util.Scanner;

class Student{
	private String number, name, dep;
	private int score;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}

class StudentService{
	int index = 0;
	Student[] students = new Student[50];
	
	public void input(Student student) {
		students[index] = student;
		index++;
	}
	
	public void totAvg() {
		int sum = 0;
		int avg = 0;
		for(int i = 0; i<index; i++) {
			sum += students[i].getScore();
		}
		avg = sum/index;
		System.out.printf("총 학생수 : %d명%n평균점수 : %d점%n", index, avg);
	}
	
	public void depAvg(int dep) { //10. 수학과  20. 국어과  30. 영어과
		int sum = 0;
		int avg = 0;
		int count = 0;
		switch(dep) {
		case 10 : 
			for(int i = 0; i<index; i++) {
				if((students[i].getDep()).equals("수학과")) {
					sum += students[i].getScore(); count++;
				}
			}
			break;
		case 20 : 
			for(int i = 0; i<index; i++) {
				if((students[i].getDep()).equals("국어과")) {
					sum += students[i].getScore(); count++;
				}
			}
			break;
		case 30 : 
			for(int i = 0; i<index; i++) {
				if((students[i].getDep()).equals("영어과")) {
					sum += students[i].getScore(); count++;
				}
			}
			break;
		default : System.out.println("정확한 학과번호를 입력하세요");	
			break;
		}
		if(count !=0) {
			avg = sum/count;
			System.out.printf("평균점수 : %d점%n",avg);
		}
		else {System.out.println("해당 학과에 등록된 학생이 없습니다.");}
	}
	
	public void print() {
		for(int i = 0; i<index; i++) {
			System.out.printf("학번 : %s%n%n"
							+ "이름 : %s%n%n"
							+ "학과 : %s%n%n"
							+ "학점 : %d%n%n"
							+ "--------------%n%n"
							,students[i].getNumber(),students[i].getName(),students[i].getDep(),students[i].getScore());
		}
	}
	
	public static void br() {
		System.out.println("");
	}
}

public class ControlFlowPractice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentService service = new StudentService();
		menu(scanner, service);
	}

	private static void menu(Scanner scanner, StudentService service) {
		Student student;
		while(true) {
			System.out.println("선택하세요. [0:나가기, 1:학생입력, 2:학생수출력, 3:학과별 학점평균, 4:학생목록출력]");
			switch(scanner.nextInt()) {
			case 0 : System.out.println("시스템 종료");return;
			case 1 : 
				student = new Student();
				System.out.println("[학생입력]");
				StudentService.br();
				System.out.println("학번 : ");
				student.setNumber(scanner.next());
				System.out.println("이름 : ");
				student.setName(scanner.next());
				System.out.println("학과 : ");
				student.setDep(scanner.next());
				System.out.println("학점 : ");
				student.setScore(scanner.nextInt());
				service.input(student);
				System.out.println("입력완료");
				StudentService.br();
				break;
			case 2 : 
				System.out.println("[학과수 출력]");
				StudentService.br();
				service.totAvg();
				StudentService.br();
				break;
			case 3 : 
				System.out.println("[학과별 학점평균]");
				StudentService.br();
				System.out.println("조회할 학과를 선택하세요 : 10. 수학과  20. 국어과  30. 영어과");
				service.depAvg(scanner.nextInt());
				StudentService.br();
				break;
			case 4 : 
				System.out.println("[학생목록출력]");
				StudentService.br();
				service.print();
				StudentService.br();
				break;
			default : System.out.println("정확한 메뉴를 선택하세요.");	
				break;
			}
		}
	}
}
