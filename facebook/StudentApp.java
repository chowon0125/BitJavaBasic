package facebook;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Student student = null;
		StudentService studentService = new StudentServiceImpl();
		
		while(true) {
			System.out.println("< 메 뉴 >");
			System.out.println("0. EXIT   1. ADD STUDENT   2. OPEN LIST");
			switch(scanner.nextInt()) {
			case 0 : System.out.println("종 료"); return;
			case 1 : 
				System.out.println("학생 추가");
				student = new Student();
				System.out.println("이름을 입력하세요");
				student.setName(scanner.next());
				System.out.println("반을 입력하세요");
				student.setCls(scanner.next());
				System.out.println("번호를 입력하세요");
				student.setNumber(scanner.nextInt());
				studentService.registration(student);
				break;
			case 2 : 
				System.out.println("학생부 열람");
				Student[] list = studentService.list();
				for(int i = 0; i<list.length; i++) {
					System.out.println(list[i].toString());
				}
				break;
			}
		}
		
		
		
	}
}
