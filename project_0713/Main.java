package project_0713;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Member m1 = new Member();
		Member m2 = new Member();
		Housing h1 = new Housing();
		IntegrationInterface s = new ServiceImpl();
		
		m1.setId("abc");
		m1.setPwd("abc");
		m1.setName("abc");
		m1.setAge(18);
		m1.setFamilyNum(3);
		m1.setSubPeriod(80);
		m1.setLessPeriod(768);
		m1.setGrade(s.inputGrade(s.calGrade(m1)));
		
		m2.setId("cde");
		m2.setPwd("acdebc");
		m2.setName("acdebc");
		m2.setAge(18);
		m2.setFamilyNum(2);
		m2.setSubPeriod(40);
		m2.setLessPeriod(1);
		m2.setGrade(s.inputGrade(s.calGrade(m2)));
		s.addApplicant(h1,m2);
		
		h1.setName("강남 아파트");
		
		System.out.println(m1.getGrade());
		System.out.println(m2.getGrade());
		
		System.out.println(s.simulator(h1, m1));
		System.out.println(s.competition(h1, m1));
		
		System.out.println("청약통장 기간 입력");
		System.out.println("해당하는 기간을 입력하세요 (yyyy/mm/dd-yyyy/mm/dd)");
		m1.setSubPeriod(s.finalCalculate(scanner.next()));
		System.out.println(m1.getSubPeriod());
	}
}
