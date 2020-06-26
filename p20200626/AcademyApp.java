package p20200626;

import java.util.Scanner;

/*

[강의등록]

강의번호: 001

강사번호(0:취소): 200

학생번호(0:취소, 1:등록완료): 100

학생번호(0:취소, 1:등록완료): 101

학생번호(0:취소, 1:등록완료): 102

[강의조회]

강의번호: 001

----------------------------

강사번호: 200

학생번호: 100/101/102


=============================================================

* 강의등록

  - 강사번호, 학생번호는 존재하는 번호를 등록할 때까지
      반복해서 입력요청한다

  - 학생번호는등록완료(1)시까지 반복해서 입력한다

  - 검색하려는강의번호가 없으면
      ‘존재하지 않은 강의번호입니다’

  - 하나의강의에 강사는 한명만
 * 
 */

class Student{
	private String stuName;
	private int stuNum, lecNum;

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public int getLecNum() {
		return lecNum;
	}

	public void setLecNum(int lecNum) {
		this.lecNum = lecNum;
	}
	
	
}

class Instructor{
	private String insName;
	private int insNum, lecNum;

	public String getInsName() {
		return insName;
	}

	public void setInsName(String insName) {
		this.insName = insName;
	}

	public int getInsNum() {
		return insNum;
	}

	public void setInsNum(int insNum) {
		this.insNum = insNum;
	}

	public int getLecNum() {
		return lecNum;
	}

	public void setLecNum(int lecNum) {
		this.lecNum = lecNum;
	}
	
	
}

class AcademyService{
	int stuIdx = 0, insIdx = 0;
	Student[] stuList = new Student[50];
	Instructor[] insList = new Instructor[50];
	
	public void stuInput(Student student) {
		stuList[stuIdx] = student;
		stuIdx++;
	}
	public void insInput(Instructor instructor) {
		insList[insIdx] = instructor;
		insIdx++;
	}
	public void stuInquiry(int stuNum) {
		boolean check = true;
		for(int i=0; i<stuIdx; i++) {
			if(stuNum == stuList[i].getStuNum()) {
				System.out.printf("학생 번호 : %d번  이름 : %s%n",stuNum, stuList[i].getStuName()); check = false; break;
			}
		}
		if(check) {System.out.println("존재하지 않는 관련자입니다.");}
	}
	public void insInquiry(int insNum) {
		boolean check = true;
		for(int i=0; i<insIdx; i++) {
			if(insNum == insList[i].getInsNum()) {
				System.out.printf("강사 번호 : %d번  이름 : %s%n",insNum, insList[i].getInsName()); check = false; break;
			}
		}
		if(check) {System.out.println("존재하지 않는 관련자입니다.");}
	}
	
	public boolean stuDuplicate(int stuNum) {
		boolean check = false;
		for(int i=0; i<stuIdx; i++) {
			if(stuNum == stuList[i].getStuNum()) {
			check = true; break;
			}
		}
		return check;
	}
	public boolean insDuplicate(int insNum) {
		boolean check = false;
		for(int i=0; i<insIdx; i++) {
			if(insNum == insList[i].getInsNum()) {
			check = true; break;
			}
		}
		return check;
	}
	public void lectureInputStd(int stuNum, int lecNum) {
		boolean check = true;
		for(int i=0; i<stuIdx; i++) {
			if(stuNum == stuList[i].getStuNum()) {
				stuList[i].setLecNum(lecNum); check = false; 
				System.out.println("등록 완료"); break;
			}
		}
		if(check) {System.out.println("정확한 학생번호를 입력하세요");}
	}
	public void lectureInputIns(int insNum, int lecNum) {
		boolean check = true;
		for(int i=0; i<insIdx; i++) {
			if(lecNum == insList[i].getLecNum()) {check = false; break;}
			}
		if(check) {
			for(int i=0; i<insIdx; i++) {
				if(insNum == insList[i].getInsNum()) {
					insList[i].setLecNum(lecNum); break;
				}
				else {System.out.println("정확한 강사번호를 입력해주세요");}
			}
		}
		else {System.out.println("이미 강의가 등록된 강사입니다.");}
	}
	
	public void lecInquiry(int lecNum) {
		int[] temp1 = new int[50]; 
		int temp2 = 0;
		int idx = 0;
		
		for(int i=0; i<stuIdx; i++) {
			if(lecNum == stuList[i].getLecNum()) {
				temp1[idx] = stuList[i].getStuNum(); idx++;
			}
		}
		
		for(int i=0; i<insIdx; i++) {
			if(lecNum == insList[i].getLecNum()) {
				temp2 = insList[i].getInsNum();
			}
		}
		
		System.out.printf("강의 번호 : %d%n",lecNum);
		System.out.println("--------------------------");
		if(idx == 0) {System.out.println("등록된 학생이 없습니다.");}
		else {
			System.out.print("학생번호 : ");
			for(int i=0; i<idx; i++) {
				System.out.printf("%d / ",temp1[i]);
			}
			System.out.println("");
		}
		if(temp2 ==0) {System.out.println("등록된 강사가 없습니다.");}
		else {System.out.printf("강사번호 : %d%n",temp2);}
	}
	
	
}


public class AcademyApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AcademyService service = new AcademyService();
		Student student;
		Instructor instructor;
		
		while(true) {
			System.out.println("선택하세요. [0:나가기, 1:학생등록, 2:강사등록, 3. 관련자 조회, 4. 강의등록,5:강의조회]");
			switch(scanner.nextInt()) {
			case 0 : System.out.println("시스템 종료"); return;
			case 1 : 
				int stuNum;
				System.out.println("[학생등록]");
				System.out.println("학생번호를 입력하세요");
				stuNum = scanner.nextInt();
				if(!service.stuDuplicate(stuNum)) {
					student = new Student();
					student.setStuNum(stuNum);
					System.out.println("이름을 입력하세요");
					student.setStuName(scanner.next());
					service.stuInput(student);
					System.out.println("학생 등록 완료");
				}
				else {System.out.println("학생번호가 중복됩니다.");}
				break;
			case 2 : 
				int insNum;
				System.out.println("[강사등록]");
				System.out.println("강사번호를 입력하세요");
				insNum = scanner.nextInt();
				if(!service.insDuplicate(insNum)) {
					instructor = new Instructor();
					instructor.setInsNum(insNum);
					System.out.println("이름을 입력하세요");
					instructor.setInsName(scanner.next());
					service.insInput(instructor);
					System.out.println("강사 등록 완료");
				}
				else {System.out.println("강사번호가 중복됩니다.");}
				break;
			case 3 : 
				System.out.println("[관련자 조회]");
				System.out.println("관련자유형(학생(10)/강사(20)): ");
				switch(scanner.nextInt()) {
				case 10 : 
					System.out.println("학생 번호를 입력하세요");
					service.stuInquiry(scanner.nextInt());
					break;
				case 20 : 
					System.out.println("강사 번호를 입력하세요");
					service.insInquiry(scanner.nextInt());
					break;
				default : 
					System.out.println("올바른 메뉴를 선택하세요");
					break;
				}
				break;
			case 4 : 
				boolean a = true;
				int ins, stu, lec;
				System.out.println("강의 번호를 입력하세요");
				lec = scanner.nextInt();
				while(a) {
					System.out.println("0. 입력 종료  1. 학생 입력");
					switch(scanner.nextInt()){
						case 0 : a = false; break;
						case 1 : 
							System.out.println("학생 번호를 입력하세요");
							stu = scanner.nextInt();
							service.lectureInputStd(stu, lec);
							break;
					}
				}
				System.out.println("강사 번호를 입력하세요");
				ins = scanner.nextInt();
				service.lectureInputIns(ins, lec);
				System.out.println("메뉴로 돌아갑니다.");
				break;
			case 5 : 
				System.out.println("[강의 조회]");
				System.out.println("조회할 강의 번호를 입력하세요.");
				service.lecInquiry(scanner.nextInt());
				break;
			default : break;
			}
		}
		
		
	}
}
