package p20200623;

import java.util.Scanner;

/*
 * •실습1: 일반화 : Person, Animal

1.Person

-속성: 이름, 성별, 나이, 키, 몸무게, 

-메소드: 말하다, 먹다, 자다, 쉬다, 일하다

2.Animal

-속성: 종, 이름, 식성, 수명,  

-메소드: 짖다, 먹다, 자다, 쉬다
 * 
 * 
 */


class Employee{
	double salary;
}

class EmployeeSalary extends Employee{
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getSalary() {
		return salary;
	}
	public double getRAF() {
		return salary*0.9;
	}
	public double getDeputy() {
		return salary*0.9;
	}
	public double getChief() {
		return (salary+200000)*0.9;
	}
	public double getHead() {
		return (salary+500000)*0.9;
	}
}

public class Practice02 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeeSalary instance = new EmployeeSalary();
		while(true) {
			System.out.println("0. 종료  1. 기본급 입력  2. 실수령액 조회");
			switch(scanner.nextInt()) {
				case 0 : System.out.println("종료"); return;
				case 1 : 
					System.out.println("기본급을 입력해주세요 (단위 : 원)");
					instance.setSalary(scanner.nextDouble());
					System.out.printf("현재 설정된 기본급은 %.0f원 입니다.%n",instance.getSalary());
					break;
				case 2 :
					System.out.println("조회할 직책을 선택하세요");
					System.out.println("0. 뒤로가기  1. 사원  2. 대리  3. 과장  4. 부장");
					switch(scanner.nextInt()) {
						case 0 : break;
						case 1 :
							System.out.printf("사원 직책의 실수령액 : %.0f원%n",instance.getRAF()); break;
						case 2 :
							System.out.printf("대리 직책의 실수령액 : %.0f원%n",instance.getDeputy()); break;
						case 3 :	
							System.out.printf("과장 직책의 실수령액 : %.0f원%n",instance.getChief()); break;
						case 4 :
							System.out.printf("부장 직책의 실수령액 : %.0f원%n",instance.getHead()); break;
						default : System.out.println("올바른 메뉴를 선택하세요");break;
					}
					break;
				default : System.out.println("올바른 메뉴를 선택하세요"); break;
			}
		}
		
	}

}
