package example2;

import java.util.ArrayList;
import java.util.Scanner;

class AcademyService {
	Scanner scanner = new Scanner(System.in);

	public void addNum(boolean check, Academy person, Academy[] list, int idx) {
		check = true;
		while (check) {
			person.setNum(scanner.nextInt());
			check = false;
			for (int i = 0; i < idx; i++) {
				if (person.getNum() == list[i].getNum()) {
					System.out.println("중복된 번호입니다.");
					check = true;
				}
			}
		}
	}

	public void checkNum(boolean check, Academy[] list, int idx) {
		check = true;
		while (check) {
			int number = scanner.nextInt();
			for (int i = 0; i < idx; i++) {
				if (number == list[i].getNum()) {
					list[i].tostring();
					check = false;
					break;
				}
			}
			if (check) {
				System.out.println("존재하지않는 번호입니다. 다시입력해주세요.");
			}
		}
	}
}

public class AcademySystem {

	public static void main(String[] args) {
		AcademyService as = new AcademyService();
		Scanner scanner = new Scanner(System.in);
		Student[] stulist = new Student[100];
		Teacher[] tealist = new Teacher[100];
		Lecture[] leclist = new Lecture[100];
		Student student;
		Teacher teacher;
		Lecture lecture;
		int stuidx = 0;
		int teaidx = 0;
		int lecidx = 0;
		boolean check = true;
		while (true) {
			System.out.println("선택하세요. [0:나가기, 1:학생등록, 2:강사등록, 3:관련자 조회, 4:강의등록, 5:강의조회]");
			int input = scanner.nextInt();
			Loop1: switch (input) {
			case 0:
				return;
			case 1:
				System.out.println("학생등록");
				student = new Student();
				System.out.println("학생번호를 입력해주세요");
				as.addNum(check, student, stulist, stuidx);
				System.out.println("학생 이름을 입력해주세요");
				student.setName(scanner.next());
				stulist[stuidx] = student;
				stuidx++;
				break;
			case 2:
				System.out.println("강사등록");
				teacher = new Teacher();
				System.out.println("강사번호를 입력해주세요");
				as.addNum(check, teacher, tealist, teaidx);
				System.out.println("강사 이름을 입력해주세요");
				teacher.setName(scanner.next());
				tealist[teaidx] = teacher;
				teaidx++;
				break;
			case 3:
				System.out.println("[관련자조회]");
				System.out.println("관련자 유형을 입력해주세요.");
				int input2 = scanner.nextInt();
				switch (input2) {
				case 10:
					System.out.println("학생번호를 입력해주세요");
					as.checkNum(check, stulist, stuidx);
					break;
				case 20:
					System.out.println("강사번호를 입력해주세요");
					as.checkNum(check, tealist, teaidx);
					break;
				default:
					System.out.println("잘못입력하셨습니다.");
					break;
				}
				break;
			case 4:
				System.out.println("[강의등록]");
				lecture = new Lecture();
				System.out.println("강의번호를 입력해주세요");
				as.addNum(check, lecture, leclist, lecidx);
				System.out.println("강사번호를 입력해주세요(0:취소)");
				check = true;
				teacher = new Teacher();
				while (check) {
					int tea = scanner.nextInt();
					if (tea == 0) {
						check = false;
						break Loop1;
					}
					for (int i = 0; i < teaidx; i++) {
						if (tea == tealist[i].getNum()) {
							teacher = tealist[i];
							check = false;
							break;
						}
					}
					if (check) {
						System.out.println("없는번호입니다.");
					}
				}
				check = true;
				boolean check2 = true;
				System.out.println("학생번호를 입력해주세요.(0:취소, 1:등록완료");
				Student[] tempstulist = new Student[100];
				int tempidx = 0;
				while (check) {
					student = new Student();
					check = true;
					check2 = true;
					int stu = scanner.nextInt();
					if (stu == 0) {
						check = false;
						break Loop1;
					}
					if (stu == 1) {
						check = false;
						break;
					}
					for (int i = 0; i < tempidx; i++) {
						if (stu == tempstulist[i].getNum()) {
							System.out.println("이미 넣은 번호입니다.");
							check2 = false;
							break;
						}
					}
					for (int i = 0; i < stuidx; i++) {
						if (stu == stulist[i].getNum() && check2) {
							student = stulist[i];
							tempstulist[tempidx] = student;
							tempidx++;
							check2 = false;
							break;
						}
					}

					if (check2) {
						System.out.println("없는번호입니다.");
					}
				}
				for (int i = 0; i < tempidx; i++) {
					lecture.stulist.add(tempstulist[i]);
				}
				lecture.setTeacher(teacher);
				leclist[lecidx] = lecture;
				lecidx++;
				break;
			case 5:
				check = true;
				System.out.println("강의번호를 입력해주세요");
				as.checkNum(check, leclist, lecidx);
				break;
			default:
				System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
				break;
			}
		}
	}
}

class Academy {
	protected int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void tostring() {
	}
}

class Person extends Academy {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Student extends Person {
	public void tostring() {
		System.out.println("이름 : " + name + " 학생번호 : " + num);
	}
}

class Teacher extends Person {
	public void tostring() {
		System.out.println("이름 : " + name + " 강사번호 : " + num);
	}
}

class Lecture extends Academy {
	private Teacher teacher;
	ArrayList<Student> stulist = new ArrayList<Student>();

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void tostring() {
		System.out.print("강의번호 : " + num + " 강사번호 : " + teacher.num);
		System.out.print(" 학생번호 :");
		for (int i = 0; i < stulist.size(); i++) {
			System.out.print(" " + stulist.get(i).num);
		}
		System.out.println();
	}
}
