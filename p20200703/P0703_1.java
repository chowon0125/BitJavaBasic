package p20200703;

import java.util.Calendar;
import java.util.Scanner;

class Army{
	private String name, grade, strDt, endDt;
	private int age;
	private Army[] sub;
	
	public Army(String name, int age, String grade, String strDt, String endDt) {
		this.name = name; this.age = age; this.grade=grade; this.strDt=strDt; this.endDt = endDt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStrDt() {
		return strDt;
	}

	public void setStrDt(String strDt) {
		this.strDt = strDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Army[] getSub() {
		return sub;
	}

	public void setSub(Army[] sub) {
		this.sub = sub;
	}
	
	
	public int getOverTimePayByGrade() {
		switch(getGrade()) {
		case "일병": return 100000;
		case "상병": return 200000;
		case "병장": return 300000;
		default : return 0;	
		}
	}
	
	public void printSubOverTimePay() {
		System.out.printf("‘{%s} 의 야근수당은 {%d}원 입니다’%n"
		,name,getOverTimePayByGrade()+getBonus());
	}
	
	public int getThisMMPeriod() {
		Calendar td = Calendar.getInstance();
		Calendar ed = Calendar.getInstance();
		ed.add(Calendar.MONTH, 1);
		ed.set(Calendar.DAY_OF_MONTH,1);
		ed.add(Calendar.DATE, -1);
		
		long difSec = (ed.getTimeInMillis() - td.getTimeInMillis()) / 1000;
		long difDay = difSec / (60*60*24); 
		
		return (int)difDay;
	}
	
	public int getSubPeriod() {
		Calendar sd = Calendar.getInstance();
		Calendar ed = Calendar.getInstance();
		String[] arr = new String[3];
		int[] arr2 = new int[3];
		arr = getStrDt().split("/", 3);
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = Integer.parseInt(arr[i]);
		}
		sd.set(arr2[0], arr2[1], arr2[2]);

		arr = getEndDt().split("/", 3);
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = Integer.parseInt(arr[i]);
		}
		ed.set(arr2[0], arr2[1], arr2[2]);

		long diffSec = (ed.getTimeInMillis() - sd.getTimeInMillis()) / 1000;
		long difDay = diffSec / (60 * 60 * 24);

		return (int) difDay;
	}
	
	public int getSubTotalPeriod() {
		int sum = 0;
		for(int i=0; i<getSub().length; i++) {
			sum += getSub()[i].getSubPeriod();
		}
		return sum;
	}
	
	public void returnSub(Army[] sub) {
		sub = this.getSub();
	}

	public void printSub() {
		for(int i=0; i<getSub().length; i++) {
			System.out.printf("%s %s %s ~ %s%n"
					,getSub()[i].getGrade(),getSub()[i].getName()
					,getSub()[i].getStrDt(),getSub()[i].getEndDt());
		}
	}
	
	public int getBonus() {
		return 0;
	}
	
}

class SpecialArmy extends Army{
	int bonus = 0;
	public SpecialArmy(String name, int age, String grade, String strDt, String endDt, int bonus) {
		super(name, age, grade, strDt, endDt);
		this.bonus = bonus;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	
}

public class P0703_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Army army1 = new Army("홍길동", 20, "이병", "2020/07/03", "2022/05/25");
		Army army2 = new Army("이순신", 21, "일병", "2020/03/15", "2021/12/21");
		Army[] sub = new Army[1];
		sub[0] = army1;
		army2.setSub(sub);
		army2.printSubOverTimePay();
		System.out.println("이번 달 남은 일자 : "+army2.getThisMMPeriod());
		System.out.println("후임들의 남은 복무 기간 합계 : "+army2.getSubTotalPeriod()+"일");
		army2.printSub();
		
		Army army3 = new SpecialArmy("원균", 22, "병장", "2019/03/15", "2020/12/14", 50000);
		Army[] sub2 = new Army[2];
		sub2[0] = army1;
		sub2[1] = army2;
		army3.setSub(sub2);
		army3.printSub();
		army3.printSubOverTimePay();
		System.out.println("후임들의 남은 복무 기간 합계 : "+army3.getSubTotalPeriod()+"일");
	}

}
