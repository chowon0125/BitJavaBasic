package p20200625;

public class EmployeeTest{
	public static void main(String[] args) {
		Employee[] emps = new Employee[2];
		Employee e = new Employee("홍길동", 29, "대리", "인사팀");
		Employee e2 = new Manager("홍팀장", 35, "팀장", "인사팀", 200000);
		emps[0] = e;
		emps[1] = e2;
		for(Employee i : emps) {
			System.out.println(i.toString());
		}
	}
}

class Employee{
	
	String name;
	int age;
	String title;
	String dept;
	
	public Employee(String name, int age, String title, String dept) {
		this.name = name;
		this.age = age;
		this.title = title;
		this.dept = dept;
	}
	public String toString() {
		return "일반사원 "+this.name+"입니다";	
	}
}

class Manager extends Employee{
	int titlePay;
	public Manager(String name, int age, String title, String dept, int titlePay) {
		super(name, age, title, dept);
		this.titlePay = titlePay;
	}
	public String toString() {
		return "매니저 "+super.name+"입니다";
	}
	
}
